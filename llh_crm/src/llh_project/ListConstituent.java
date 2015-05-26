package llh_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListConstituent
 */
@WebServlet("/ListConstituent")
public class ListConstituent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListConstituent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered do get function of list_constituent");
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");
        Connection connection = pool.getConnection();
        String add_type       = request.getParameter("add_type");
        
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<head>");
	    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
	    out.println("</head>");
		out.println("<h2> Select a constituent </h2>");
		out.println("<form method=post>");
		out.println("<input type=\"hidden\" name=\"table\" value=\"skmull02." + add_type + "\">");
		out.println("<select name=\"mydropdown\">");
		
		
		try
		{
			ResultSet rs = null;
	        String template = "SELECT * FROM skmull02.constituent";
	        try
	        {
	            Statement s = connection.createStatement();
	            rs = s.executeQuery(template);
	        }
	        
	        catch (SQLException e)
	        {
	            System.out.println(e.getMessage());
	        } 
	        
	        
			while (rs.next())
			{
				String fullName = rs.getString(2) +" "+ rs.getString(3);
				String myOption = "<option value=\"" + rs.getString(1) + "\">" + fullName + "</option>";
				out.println(myOption);
			} 
		} catch (Exception e)
		{
			System.out.println("Could not read result set");
			e.printStackTrace();
		} 
		
		out.println("</select>");
		out.println("<BR></BR>");
		out.println("<input type=\"submit\" value=\"Select\">");
		out.println("</FORM>");

		out.println("</BODY>");
		pool.freeConnection(connection);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entered post");
		String member_id = request.getParameter("mydropdown");
		String add_type  = request.getParameter("add_type");
		System.out.println("Member id " + member_id);
		System.out.println("Add_type " + add_type);
		
		
		request.setAttribute("member_id", member_id);
		String full_url = "/add_" + add_type + ".jsp";
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(full_url);
		dispatcher.include(request,response);
	}

}
