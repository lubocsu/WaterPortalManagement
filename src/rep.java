

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
 * Servlet implementation class rep
 */
@WebServlet("/rep")
public class rep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	PreparedStatement smt=null;
	Statement smt1=null;
	ResultSet rs=null;
	PrintWriter out=null;
    public rep() {
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
			HttpSession session=request.getSession();
			String fname=(String)session.getAttribute("username");
			String fmob=(String)session.getAttribute("mobno");
			System.out.println(fmob+fname);
			con=(Connection) DriverManager.getConnection(URL,"root","shrikara");
			smt=con.prepareStatement("insert into report(sub,rpt,mob,fnm) values(?,?,?,?)");
			smt1=(Statement) con.createStatement();
			String sub=request.getParameter("sub");
			String rpt=request.getParameter("rpt");
			smt.setString(1, sub);
     		smt.setString(2,rpt);
     		smt.setString(3, fmob);
     		smt.setString(4,fname);
     		int v=smt.executeUpdate();
     		rs=smt1.executeQuery("select rno from report where mob='"+fmob+"' and fnm='"+fname+"'and rpt='"+rpt+"'and sub='"+sub+"' ");
     		rs.next();
     		if(v==1)
     		{
     			out.println("<h1>Complaint successfully registered</h1><br/>");
     			
     			out.println("COMPLAINT NUMBER: "+rs.getString(1)+"will be attended in 48hrs");
     			
     		}
		}
		catch(Exception e)
		{
			System.out.println(e+"    error");
			RequestDispatcher rd=request.getRequestDispatcher("unsuccessful.html");
			   rd.forward(request, response);}
	}
	}
	


