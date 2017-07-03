<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;%>
</head>
<body>
<img src="D:\eclipse_project_saved_content\WMS\logo.jpg" height="25%" width="550" >
<form action="htafj.html">
<button type="submit" >HOW TO APPLY FOR JOB</button>
</form>
<h1>JOBS</h1>
<% 

Class.forName("com.mysql.jdbc.Driver");
String URL="jdbc:mysql://localhost:3306/project";
conn=DriverManager.getConnection(URL,"root","shrikara");
ps=conn.prepareStatement("select * from job order by jno desc");
rs=ps.executeQuery();
%>
<ul>
<%while(rs.next()) {%>
<li><div><h2>
<%=rs.getString(2) %></h2><br/>
<%=rs.getString(3) %><br/>
JOB ID: <%=rs.getString(1) %>
</div></li>
<% 
}
ps.close();
conn.close();

%>
</ul>
</body>
</html>