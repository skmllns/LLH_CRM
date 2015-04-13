package llh_project;

import java.io.IOException;
import java.io.PrintWriter;
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

import llh_project.ConnectionPool;

/**
 * Servlet implementation class ViewConstituent
 */
@WebServlet("/ViewConstituent")
public class ViewConstituent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResultSet	results 	= null;
    public String		sqlResult	= "";
    public String		sqlSuccess  = "";
    public Statement	statement	= null;
    Connection			connection	= null;
    String 				view	    = null;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String sqlStatement_view = null;
		
		view = request.getParameter("view");
		System.out.println(view);
//		
		//get instance and connection using connection pool
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");
	
		connection = pool.getConnection();
		
	
		
		try {
			parseAndExecuteView(view, connection);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
				
		pool.freeConnection(connection);
		
		//create a session
		HttpSession session = request.getSession();
		
		//set session attributes
		session.setAttribute("sqlResult", sqlResult);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/query_results.jsp");
		dispatcher.forward(request,response);

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

