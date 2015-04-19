package llh_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import llh_project.ConnectionPool;
/**
 * Servlet implementation class SearchConstituent
 */
@WebServlet("/SearchConstituent")
public class SearchConstituent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ResultSet	results 				= null;
	public String		sqlResult				= "";
	Connection			connection				= null;
	public Statement	statement				= null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String last_name = request.getParameter("last_name");
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		connection = pool.getConnection();
				
	
        
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
        try
        {
            results = parseAndExecuteView(last_name, connection);
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
//        
        out.println("</tr>");
        out.println("</table>");
//        
        pool.freeConnection(connection);

	}
	
	private ResultSet parseAndExecuteView(String last_name, Connection connection) throws SQLException
    {
        statement = connection.createStatement();
        String search_query = "SELECT * FROM Constituent WHERE last_name = '" + last_name + "'";
        System.out.println(search_query);
        return statement.executeQuery(search_query);
        /*sqlResult = SQLUtil.getHtmlTable(results);
        System.out.println(sqlResult);
        results.close();*/
    }
}
