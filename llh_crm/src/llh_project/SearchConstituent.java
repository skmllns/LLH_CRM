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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchConstituent
 */
@WebServlet("/SearchConstituent")
public class SearchConstituent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ResultSet	results 				= null;
	public String		query_results			= "";
	Connection			connection				= null;
	public Statement	statement				= null;
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String last_name = request.getParameter("last_name");
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		connection = pool.getConnection();
				
		try 
		{
			searchConst(connection, last_name);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		pool.freeConnection(connection);
		
		//create a session
		HttpSession session = request.getSession();
		
		//set session attributes
		session.setAttribute("query_results", query_results);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/query_results.jsp");
		dispatcher.forward(request,response);

	}
	
	private void searchConst(Connection connection,  String last_name) throws SQLException 
	{
		statement = connection.createStatement();
		
		
		String search_query = "SELECT * FROM Constituent WHERE last_name = '" + last_name + "'";
		results = statement.executeQuery(search_query);
		if(results != null)
		{
			query_results = SQLUtil.getHtmlTable(results);
			
			results.close();
		}
		
	}
}
