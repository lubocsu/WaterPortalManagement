

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update1")
public class update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	  
		Connection con=null;
		PreparedStatement smt=null;
		Statement smt1=null;
		ResultSet rs=null;
		PrintWriter out=null;
    public update1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{System.out.println("successfully UPDATED");
			response.setContentType("text/html");
			out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://LocalHost:3306/project";
			con=(Connection) DriverManager.getConnection(URL,"root","shrikara");
			HttpSession session=request.getSession();
			String fmob=(String)session.getAttribute("mobno");
			
			String npwd=request.getParameter("npwd");
			System.out.println("successfully UPDATED");
			smt=con.clientPrepareStatement("update register set pwd='"+npwd+"' where mob='"+fmob+"'");
			System.out.println("successfully UPDATED");
			//smt.setString(10, npwd);
     		
     		
     		/*smt1=(Statement) con.createStatement();
     		rs=smt1.executeQuery("select * from register");
 while(rs.next())
 {
	 if(rs.getString(8)==mob)
	 {	 out.println("mobile number already exist");
	 RequestDispatcher rd=request.getRequestDispatcher("register.html");
		rd.forward(request, response);
	 }
	 
 }*/
     		int v=smt.executeUpdate();
     		if(v==1)
     		{
     			System.out.println("successfully UPDATED");
     			RequestDispatcher rd=request.getRequestDispatcher("login.html");
     			rd.forward(request, response);
     		}
     		else 
     		{
     			out.println("please fill correctly");
     			RequestDispatcher rd=request.getRequestDispatcher("unsuccessful.html");
     			rd.forward(request, response);
     					}
    		}
		catch(Exception e)
		{
			out.println(e);
			out.println("SORRY UNABLE TO UPDATE PLEASE CONTACT NEAREST WATER PORTAL OFFICE or send a mail to chennaiwp.pwd@gmail.com<br/><br/><a href user.html>back</a>");
 			//RequestDispatcher rd=request.getRequestDispatcher("register.html");
 			//rd.forward(request, response);
		}
	}

}
