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
 * Servlet implementation class AddDonor
 */
@WebServlet("/AddDonor")
public class AddDonor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDonor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//member information
		
    	String member_id   		  = request.getParameter("member_id");
		String fund				  = request.getParameter("fund");
		String don_type 	      = request.getParameter("don_type");
		String don_amt        	  = request.getParameter("don_amt");
		String don_date			  = request.getParameter("don_date");
		
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		Connection connection = pool.getConnection();
		
		//add tuple to table
		try 
		{
			addMember(connection, member_id, fund, don_type, don_amt, don_date);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		PrintWriter out = response.getWriter();
        out.println("<body>");
        out.println("<\"Successfully added donor with ID #" + member_id + "\">");
        
		pool.freeConnection(connection);
		response.sendRedirect("welcome.jsp");

	}
		
	private void addMember(Connection connection, String member_id, String fund, String donor_type, String donor_amt, String donor_date)
							  throws SQLException 
	{
		System.out.println("entered add constituent function");
		//create statement and insert tuple into table
		//input: constituent information
		Statement statement = connection.createStatement();
		int i = -1;
		
		String update = "INSERT INTO "
				+ "skmull02.donor (donor_id, fund, don_type, don_amt, don_date) VALUES ('" + member_id + "', '" + fund
				+ "', '"  + donor_type + "', '" + donor_amt + "', '" + donor_date + "')";
		System.out.println(update);
		i = statement.executeUpdate(update);
		//
		String add_member;
		if(i == 1)
		{
			add_member = "Successfully added '" + member_id + "' to donors.";
		}
		
		else
		{
			add_member = "Uh oh, couldn't add '" + member_id + "' to donors.";
		}
		
		System.out.println(add_member);
		
		}
		
	}
		
		
