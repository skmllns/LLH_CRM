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
 * Servlet implementation class AddBoard
 */
@WebServlet("/AddBoard")
public class AddBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//member information
		
		String member_id   		  = request.getParameter("member_id");
		String board_pos	      = request.getParameter("board_pos");
		String pos_start_date     = request.getParameter("pos_start_date");
		
		ConnectionPool pool = ConnectionPool.getInstance("jdbc/skmull02");		
		Connection connection = pool.getConnection();
		
		//add tuple to table
		try 
		{
			addBoard(connection, member_id, board_pos, pos_start_date);
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
//		PrintWriter out = response.getWriter();
//        out.println("<body>");
//        out.println("<\"Successfully added member with ID #" + member_id + "\">");
        
		pool.freeConnection(connection);
		response.sendRedirect("welcome.jsp");

	}
		
	private void addBoard(Connection connection, String member_id, String board_pos, String pos_start_date)
							  throws SQLException 
	{
		System.out.println("entered add board function");
	
		Statement statement = connection.createStatement();
		int i = -1;
		
		String update = "INSERT INTO "
				+ "skmull02.board (board_id, board_pos, pos_start_date) VALUES ('" + member_id + "', '" + board_pos
				+ "', '" + pos_start_date + "')";
		System.out.println(update);
		i = statement.executeUpdate(update);
		//
		String add_member;
		if(i == 1)
		{
			add_member = "Successfully added '" + member_id + "' to board members.";
		}
		
		else
		{
			add_member = "Uh oh, couldn't add '" + member_id + "' to board members.";
		}
		
		System.out.println(add_member);
		
		}
		
	}
		
		
