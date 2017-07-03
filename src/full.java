

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class full
 */
@WebServlet("/full")
public class full extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	PreparedStatement smt=null;
	Statement smt1=null;
	ResultSet rs=null;
	PrintWriter out=null;
    public full() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html");
			out=response.getWriter();
			System.out.println("no is");
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3306/project";
			con=(Connection) DriverManager.getConnection(URL,"root","shrikara");
			smt1=(Statement) con.createStatement();
			
			
			
			int no=Integer.parseInt(request.getParameter("readmore"));
			System.out.println("no is"+no);
			rs=smt1.executeQuery("select * from news where no='"+no+"' ");
			if(rs.next())
			{		//String head=rs.getString(2);
			//String body=rs.getString(3);
			out.println("<br/>"+rs.getString(2)+"<br/><br/>");
			out.println("<p>"+rs.getString(3)+"</p>");
		}}
		catch(Exception e)
		{
			System.out.println(e);
			//RequestDispatcher rd=request.getRequestDispatcher("unsuccessful.html");
			// rd.forward(request, response);
			}
	}
			
	}


