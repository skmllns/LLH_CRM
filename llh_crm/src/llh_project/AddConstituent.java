package llh_project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddConstituent
 */
@WebServlet("/AddConstituent")
public class AddConstituent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ResultSet	results 				= null;
    public String		sqlResult				= "";
    public String		sqlSuccess 				= "";
    public Statement	statement				= null;
    public Statement	statement_member		= null;
    public Statement	statement_staff			= null;
    public Statement	statement_board			= null;
    public Statement 	statement_donor			= null;
    public Statement    statement_vendor		= null;
    public Statement	statement_agency		= null;
    public Statement	statement_grant			= null;
    public String		add_const   			= "";
    Connection			connection				= null;
    String 				queryValue  			= null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddConstituent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//basic constituent information
				String first_name = request.getParameter("first_name");
				String last_name = request.getParameter("last_name");
				String const_type = request.getParameter("const_type");
				String address = request.getParameter("address");
				String city = request.getParameter("city");
				String state = request.getParameter("state");
				String zip_code = request.getParameter("zip_code");
				String country = request.getParameter("country");
				String neighborhood = request.getParameter("neighborhood");
				String phone_num = request.getParameter("phone_num");
				String email = request.getParameter("email");
				String refer_method = request.getParameter("refer_method");
				String interest = request.getParameter("interest");
				String comments = request.getParameter("comments");
					
					
				System.out.println(first_name + last_name + const_type);

				System.out.println("entered get");
				
				//get instance and connection using connection pool
				ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
				connection = pool.getConnection();
				
				//add tuple to table
				try 
				{
					addConst(connection, first_name, last_name, const_type, address, city, state, zip_code, country, neighborhood, email,
							phone_num, refer_method, interest, comments);
					
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
				
					
				pool.freeConnection(connection);
				
				//create a session
				HttpSession session = request.getSession();
				
				//set session attributes
				session.setAttribute("result", "Successfully added constituent.");
				
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/welcome.jsp");
				dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
				
		
	}

	private void addConst(Connection connection, String first_name, String last_name, String const_type,
						  String address, String city, String state, String zip_code, String country,
						  String neighborhood, String email, String phone_num, String refer_method, String interest, String comments) 
								  throws SQLException 
	{
		System.out.println("entered add constituent function");
		//create statement and insert tuple into table
		//input: constituent information
		statement = connection.createStatement();
		int i = -1;
		
		String update = "INSERT INTO Constituent (first_name, last_name, con_type, address, city, state, zip_code, country,"
				+ "neighborhood, email, phone_num, referral_method, interests, comments) "
				+ "VALUES('" + first_name + "','" + last_name + "','" + const_type +  "','" 
				+ address + "', '" + city + "', '" + state + "','" + zip_code + "','" + country + "', '" + neighborhood + "', '" 
				+ email + "', '" + phone_num + "', '" + refer_method + "', " + interest + ", '" + comments + "')";
				
		System.out.println(update);
		i = statement.executeUpdate(update);
//		
		if(i == 1)
		{
			add_const = "Successfully added '" + first_name + "' to constituents.";
		}
		
		else
		{
			add_const = "Uh oh, couldn't add '" + first_name + "' to constituents.";
		}
		
		System.out.println(add_const);
		
	}
	
	
}

//		
//		


