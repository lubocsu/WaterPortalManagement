

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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class reg1
 */
@WebServlet("/reg1")
public class reg1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	PreparedStatement smt=null;
	Statement smt1=null;
	ResultSet rs=null;
	PrintWriter out=null;
    public reg1() {
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
			String URL="jdbc:mysql://LocalHost:3306/project";
			con=(Connection) DriverManager.getConnection(URL,"root","shrikara");
			smt=con.clientPrepareStatement("insert into register values(?,?,?,?,?,?,?,?,?,?,?)");
			String fnm=request.getParameter("fnm");
			String lnm=request.getParameter("lnm");
			String dno=request.getParameter("dno");
			String st=request.getParameter("st");
			String ar=request.getParameter("ar");
			String cty=request.getParameter("cty");
			String zip=request.getParameter("zip");
			String mob=request.getParameter("mob");
			String eid=request.getParameter("eid");
			String pwd=request.getParameter("pwd");
			String role=request.getParameter("role");
     		smt.setString(1, fnm);
     		smt.setString(2, lnm);
     		smt.setString(3,dno);
     		smt.setString(4, st);
     		smt.setString(5,ar);
     		smt.setString(6, cty);
     		smt.setString(7, zip);
     		smt.setString(8,mob);
     		smt.setString(9,eid);
     		smt.setString(10,pwd);
     		smt.setString(11,role);
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
     			out.println("successfully registered<a admin.html>DONE</a>");
     			
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
			out.println("<a href register.html>Register</a>");
 			//RequestDispatcher rd=request.getRequestDispatcher("register.html");
 			//rd.forward(request, response);
		}
	}

}
