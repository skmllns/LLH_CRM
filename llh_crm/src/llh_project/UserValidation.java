package llh_project;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class UserValidation2
 */
@WebServlet("/UserValidation")
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public String db_name = null;
	public String user_name = null;
	public String password = null;
	public String driver = null;
	public String url = null;
	public static Connection db_connection = null;
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @see HttpServlet#HttpServlet()
     */
    public UserValidation() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        
    	super();
    	
    	//initialize database variables
        initalize();
        
        //connect to database
        establish_db_connection();
        
    }

    //initialize database variables
    public void initalize()
    {
    	 driver = "com.ibm.db2.jcc.DB2Driver";
         db_name = "skmull02";
         user_name = "skmull02";
         password = "Spring2015";
         url = "jdbc:db2://216.249.138.198:50000/skmull02";
    }
    
    //connect to database
    private void establish_db_connection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
    	try
    	{
    		Class.forName(driver).newInstance();
    		db_connection = DriverManager.getConnection(url, "skmull02", "Spring2015");
    	  	
    	}
    
    	catch (ClassNotFoundException cle)
        {
            System.out.println("  Driver class not found, please check the PATH" + " and CLASSPATH system variables to ensure they are correct");
        }
        catch (SQLException sqle)
        {
            System.out.println("  Could not open connection");
            sqle.printStackTrace();
        }
        catch (Exception ne)
        {
            System.out.println("  Unexpected Error");
            ne.printStackTrace();
        }
    }
    
    public void disconnectFromDatabase()
    {
        if (db_connection != null)
        {
            try
            {
                System.out.println("Disconnecting from database ...");
                db_connection.close();
                System.out.println("Disconnected from database.");
            }
            catch (Exception sqle)
            {
                System.out.println("Error closing connection");
                sqle.printStackTrace();
            }
        }
    }
   
    //validate login info
    private int validate_login_info(String user_name, String password) throws SQLException
    {    	
    	//initially set login information to not found
    	int login_info_found = 0;
    	
    	String input_user_name = user_name;
    	String input_password = password;

    	Statement statement = db_connection.createStatement();
    	String query = "SELECT * FROM LOGIN";
    	ResultSet results = statement.executeQuery(query);
    	    	
    	while(results.next())
    	{
    		//if user input matches the database information, set boolean value to 1
    		if(results.getString(1).equals(input_user_name))
    		{
    			if(results.getString(2).equals(input_password))
    			{
    				login_info_found = 1;
    				System.out.println("Found user name and password!");
    			}
    		}
    	}
    	
    	return login_info_found;
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String success_url = "/welcome.jsp";
		String failure_url = "/login.jsp";
		int login_info_found = 0;
		
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		//validate login info
		try 
		{
			login_info_found = validate_login_info(user_name, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
		//set appropriate Welcome page messages
		if(login_info_found == 1)
		{
			ServletContext context = getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher(success_url);
	        dispatcher.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Sorry, login failed, please try again");
			ServletContext context = getServletContext();
	        RequestDispatcher dispatcher = context.getRequestDispatcher(failure_url);
	        dispatcher.forward(request, response);
		}
	}

}
