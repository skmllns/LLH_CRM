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
 * Servlet implementation class AddVendor
 */
@WebServlet("/AddVendor")
public class AddVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVendor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//staff information
    	String member_id		  = request.getParameter("member_id");
		String vendor_type		  = request.getParameter("vendor_type");
		String vendor_product	  = request.getParameter("vendor_product");
		
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		Connection connection = pool.getConnection();
		
		//add tuple to table
		try 
		{
			addVendor(connection, member_id, vendor_type, vendor_product);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
        
		pool.freeConnection(connection);
		response.sendRedirect("welcome.jsp");

	}
		
	private void addVendor(Connection connection, String member_id, String vendor_type, String vendor_product)
							  throws SQLException 
	{
		System.out.println("entered add constituent function");
		//create statement and insert tuple into table
		//input: constituent information
		Statement statement = connection.createStatement();
		
		String update = "INSERT INTO "
				+ "skmull02.vendor (staff_id, vendor_type, vendor_product) "
				+ "VALUES ('" + member_id + "', '" + vendor_type + "', '" + vendor_product + "')";
		System.out.println(update);
		statement.executeUpdate(update);
			
	}
		
}		

