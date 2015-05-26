package llh_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStaff
 */
@WebServlet("/AddStaff")
public class AddStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//staff information
    	String member_id		  = request.getParameter("member_id");
		String ao_interest        = request.getParameter("ao_interest");
		String skill 	      	  = request.getParameter("skill");
		String title			  = request.getParameter("title");
		String date_active        = request.getParameter("date_active");
		String staff_code		  = request.getParameter("staff_code");
		
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		Connection connection = pool.getConnection();
		
		//add tuple to table
		try 
		{
			addStaff(connection, member_id, ao_interest, title, skill, date_active, staff_code);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
        
		pool.freeConnection(connection);
		response.sendRedirect("welcome.jsp");

	}
		
	private void addStaff(Connection connection, String member_id, String ao_interest, String skill, String title,
			String date_active, String staff_code)
							  throws SQLException 
	{
		System.out.println("entered add constituent function");
		Statement statement = connection.createStatement();
		
		String update = "INSERT INTO "
				+ "skmull02.staff (staff_id, ao_interest, skills, title, date_active, staff_code) "
				+ "VALUES ('" + member_id + "', '" + ao_interest + "', '" + skill + 
				"', '" + title + "', '" + date_active + "', '" + staff_code + "')";
		System.out.println(update);
		statement.executeUpdate(update);
			
	}
		
}		

