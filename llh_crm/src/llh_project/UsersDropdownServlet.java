package llh_project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

import llh_project.DatabaseConnectionController;
import llh_project.UsersController;

/**
 * Servlet implementation class UsersDropdownServlet
 */
@WebServlet("/UsersDropdownServlet")
public class UsersDropdownServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsersDropdownServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int columnCount = 0;
		ResultSetMetaData metaData;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<BR>");
		out.println("<BODY>");
		out.println("<table cellpadding=\"5\" border=\"2\">");
		out.println("<tr>");

		DatabaseConnectionController dbCC = new DatabaseConnectionController("COMPANY");
		dbCC.establishDBConnection();
		UsersController Ucc = new UsersController(dbCC.getDbConnection());
		ResultSet rs = Ucc.getUsersList();
		try
		{
			metaData = rs.getMetaData();
			columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++)
			{
				out.println("<td><b>" + metaData.getColumnName(i) + "</td>");
			}
			out.println("</tr>");
			while (rs.next())
			{
				out.println("<tr>");
				for (int i = 1; i <= columnCount; i++)
				{
					out.println("<td>" + rs.getString(i) + "</td>");
				} // end for
			} // end while
		} catch (SQLException sqle)
		{
			System.out.println("Could not read result set");
			sqle.printStackTrace();
		}
		out.println("</tr>");
		out.println("</table>");
		


		out.println("<FORM METHOD=POST>");
		out.println("<select name=\"mydropdown\">");
		try
		{
			rs = Ucc.getUsersList();
			while (rs.next())
			{
				String fullName = rs.getString(3) +" "+ rs.getString(4) +" "+ rs.getString(5);
				String myOption = "<option value=\"" + rs.getString(1) + "\">" + fullName + "</option>";
				out.println(myOption);
			} // end while
		} catch (Exception e)
		{
			System.out.println("Could not read result set");
			e.printStackTrace();
		} // end try catch
		out.println("</select>");
		out.println("<BR>");
		out.println("<input type=\"submit\" value=\"Select\">");
		out.println("</FORM>");

		out.println("</BODY>");
		dbCC.disconnectFromDatabase();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<BR>");
		out.println("User: " + request.getParameter("mydropdown") + "<BR>");
	}

}
