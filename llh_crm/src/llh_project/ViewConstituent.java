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
/**
 * Servlet implementation class ViewConstituent
 */
@WebServlet("/ViewConstituent")
public class ViewConstituent extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public ResultSet          results          = null;
    public String             sqlResult        = "";
    public String             sqlSuccess       = "";
    public Statement          statement        = null;
    Connection                connection       = null;
    String                    view             = null;
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
        connection = pool.getConnection();
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
//        
        out.println("</tr>");
        out.println("</table>");
//        
        pool.freeConnection(connection);
        
//        request.setAttribute("sqlResult", sqlResult);
//        RequestDispatcher view = request.getRequestDispatcher("/main_page.jsp");
//        view.forward(request, response);
       
    }
    private ResultSet parseAndExecuteView(String view, Connection connection) throws SQLException
    {
        statement = connection.createStatement();
        String query_string = "SELECT * FROM " + view;
        return statement.executeQuery(query_string);
        /*sqlResult = SQLUtil.getHtmlTable(results);
        System.out.println(sqlResult);
        results.close();*/
    }
}
