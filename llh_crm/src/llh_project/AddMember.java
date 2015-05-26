package llh_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMember
 */
@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMember() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//member information
		
		String member_id   		  = request.getParameter("member_id");
		String member_type 	      = request.getParameter("member_type");
		String member_year        = request.getParameter("member_year");
		
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		Connection connection = pool.getConnection();
		
		//add tuple to table
		try 
		{
			addMember(connection, member_id, member_type, member_year);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
        
		pool.freeConnection(connection);
		response.sendRedirect("welcome.jsp");

	}
		
	private void addMember(Connection connection, String member_id, String member_type, String member_year)
							  throws SQLException 
	{
		System.out.println("entered add constituent function");
		Statement statement = connection.createStatement();
		
		String update = "INSERT INTO "
				+ "skmull02.member (member_id, member_type, member_year) VALUES ('" + member_id + "', '" + member_type
				+ "', '" + member_year + "')";
		System.out.println(update);
		statement.executeUpdate(update);
		
		}
		
	}
		
		
