package llh_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        view = request.getParameter("view");
        System.out.println(view);
        
        ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");
        connection = pool.getConnection();
        try
        {
            parseAndExecuteView(view, connection);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        pool.freeConnection(connection);
        
        request.setAttribute("sqlResult", sqlResult);
        RequestDispatcher view = request.getRequestDispatcher("/main_page.jsp");
        view.forward(request, response);
       
    }
    private void parseAndExecuteView(String view, Connection connection) throws SQLException
    {
        statement = connection.createStatement();
        String query_string = "SELECT * FROM " + view;
        results = statement.executeQuery(query_string);
        sqlResult = SQLUtil.getHtmlTable(results);
        System.out.println(sqlResult);
        results.close();
    }
}
