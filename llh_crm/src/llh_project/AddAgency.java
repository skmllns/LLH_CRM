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
 * Servlet implementation class AddAgency
 */
@WebServlet("/AddAgency")
public class AddAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAgency() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//member information
		
		String member_id   		  = request.getParameter("member_id");
		String agency_area		  = request.getParameter("agency_area");
		
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		Connection connection = pool.getConnection();
		
		//add tuple to table
		try 
		{
			addAgency(connection, member_id, agency_area);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	       
		pool.freeConnection(connection);
		response.sendRedirect("welcome.jsp");

	}
		
	private void addAgency(Connection connection, String member_id, String agency_area)
							  throws SQLException 
	{
		System.out.println("entered add constituent function");
		//create statement and insert tuple into table
		//input: constituent information
		Statement statement = connection.createStatement();
		int i = -1;
		
		String update = "INSERT INTO "
				+ "skmull02.partner (partner_id, agency_area) VALUES ('" + member_id + "', '" + agency_area + "')";
		System.out.println(update);
		
	}
}
		
