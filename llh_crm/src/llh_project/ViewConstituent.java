package llh_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ViewConstituent
 */
@WebServlet("/ViewConstituent")
public class ViewConstituent extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public ResultSet          results          = null;
    public ResultSet 		  results_1		   = null;
    public String             sqlResult        = "";
    public String             sqlSuccess       = "";
    public Statement          statement        = null;
    public Statement		  statement2	   = null;
    Connection                connection       = null;
    String                    view             = null;
    String					  query_string	   = null;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        view = request.getParameter("view");
        System.out.println(view);
        
        int column_count = 0;
        ResultSetMetaData metaData;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<body>");
        out.println("<table>");
        out.println("<tr style=\"font-size=80%\">");
       
//        
        ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");
        Connection connection = pool.getConnection();
//        
        try
        {
            results = parseAndExecuteView(view, connection);
            metaData = results.getMetaData();
            column_count = metaData.getColumnCount();
            for(int i = 1; i <= column_count; i++)
            {
            	out.println("<td ><b>" + metaData.getColumnName(i) + "</td>");
            }
            
            out.println("</tr>");
            while(results.next())
            {
            	out.println("<tr>");
            	for(int i = 1; i <= column_count; i++)
            	{
            		out.println("<td>" + results.getString(i) + "</td>");
            	}
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
        out.println("</tr>");
        out.println("</table>");
       
        pool.freeConnection(connection);

       
    }
    private ResultSet parseAndExecuteView(String view, Connection connection) throws SQLException
    {
    	System.out.println(view);
    	
    	//hot mess
    	//want to get unique column names from given table in order to use it in the join table query
    	statement = connection.createStatement();
    	statement2 = connection.createStatement();
    	
    	String query = "SELECT * FROM " + view;
    	results_1 =  statement2.executeQuery(query);
      
        ResultSetMetaData metaData = results_1.getMetaData();
        int column_count = metaData.getColumnCount();
        //System.out.println(column_count);
        
        String[] col_names = new String[column_count-1];
        for(int i = 2; i <= column_count; i++)
        {
        	col_names[i-2] = metaData.getColumnName(i);
        }
        System.out.println(Arrays.toString(col_names));
      
        if(view.equals("skmull02.constituent"))
        		
        {
        	//System.out.println("entered if");
        	query_string = "SELECT * FROM skmull02.constituent";
        }
        
       else 
        {
    	   //System.out.println("entered else");
    	   query_string = "SELECT skmull02.constituent.const_id, skmull02.constituent.first_name, "
    			   			+ "skmull02.constituent.last_name";
    	   for(int x = 0; x < column_count - 1; x++)
    	   {
    		   query_string += ", " + view + "." + col_names[x];
    	   }
    	   query_string += " FROM skmull02.constituent JOIN " + view + " ON skmull02.constituent.const_id = " + view + "." + view.substring(9) + "_id";
        }
        
        //System.out.println(query_string);
        
        return statement.executeQuery(query_string);
 
    }
}
