

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
 * Servlet implementation class log
 */
@WebServlet("/log")
public class log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	PreparedStatement smt=null;
	Statement smt1=null;
	ResultSet rs=null;
	PrintWriter out=null;
    public log() {
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
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost:3306/project";
			con=(Connection) DriverManager.getConnection(URL,"root","shrikara");
			smt1=(Statement) con.createStatement();
			String mno=request.getParameter("mno");
			String pwd=request.getParameter("pwd");
			rs=smt1.executeQuery("select * from register where mob='"+mno+"' and pwd='"+pwd+"'");
     		
     		
     		System.out.println("in login page");
     		
     		if(rs.next()){
     			 
     			 	if(rs.getString(11).equalsIgnoreCase("admin")) 
     			   {HttpSession session=request.getSession();
     			 		session.setAttribute("username",rs.getString(1));
     			  session.setAttribute("mobno",rs.getString(8));
     			 session.setAttribute("pwd",rs.getString(10));
     			 		
     			 		RequestDispatcher rd=request.getRequestDispatcher("admin.html");
  				   rd.forward(request, response);
     			   }
     			 else 
     			{ HttpSession session=request.getSession();
			 		session.setAttribute("username",rs.getString(1));
			  session.setAttribute("mobno",rs.getString(8));
			  session.setAttribute("pwd",rs.getString(10));
     				 
     				 RequestDispatcher rd=request.getRequestDispatcher("user.html");
				   rd.forward(request, response);
  			   }
     			      			
     		 
     		}
     		else{
     				 RequestDispatcher rd=request.getRequestDispatcher("unsuccessful.html");
				   rd.forward(request, response);
  			   
     		}	 
     			 
     		 
	}
		catch(Exception e)
		{
			System.out.println(e);
			RequestDispatcher rd=request.getRequestDispatcher("unsuccessful.html");
			   rd.forward(request, response);}
	}
}


