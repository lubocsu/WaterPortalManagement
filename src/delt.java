

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class delt
 */
@WebServlet("/delt")
public class delt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection con=null;
	PreparedStatement smt=null;
	Statement smt1=null;
	ResultSet rs=null;
	PrintWriter out=null;
    public delt() {
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
			
			smt=con.clientPrepareStatement("delete from register where mob=?");
			String mno=request.getParameter("mob");
			smt.setString(1,mno);
			int v=smt.executeUpdate();
			if(v==1)
			{out.println("successfully Deleted...<a href admin.html>HOME?</a>");
 			
				
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
