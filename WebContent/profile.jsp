<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>PROFILE</h1><p>                                                                                         </p>
<br/><br/>
<% 
Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
String URL="jdbc:mysql://localhost:3306/project";
conn=DriverManager.getConnection(URL,"root","shrikara");
String mob=(String)session.getAttribute("mobno");
ps=conn.prepareStatement("select * from register where mob='"+mob+"'");
rs=ps.executeQuery();
if(rs.next()) {%>

FIRST NAME : <%=rs.getString(1) %><br/><br/>
LAST NAME : <%=rs.getString(2) %><br/><br/>
ADDRESS :<%=rs.getString(3) %> 
<%=rs.getString(4) %><br/>
<%=rs.getString(5) %><br/>
CHENNAI -<%=rs.getString(7) %><br/><br/>
MOBILE NUMBER : <%=rs.getString(8) %><br/><br/>
EMAIL ID : <%=rs.getString(9) %><br/><br/>

<%

}
ps.close();
conn.close();

%>


<form method="post" action="relog1.html" target="_blank">

<input type="submit" value="EDIT"/>

</form>

</body>
</html>