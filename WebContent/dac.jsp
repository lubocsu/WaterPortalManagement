<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="java.sql.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;

Class.forName("com.mysql.jdbc.Driver");
String URL="jdbc:mysql://localhost:3306/project";
conn=DriverManager.getConnection(URL,"root","shrikara");
String mob=(String)session.getAttribute("mobno");
ps=conn.prepareStatement("delete from register where mob ='"+mob+"'");
rs=ps.executeQuery();
ps=conn.prepareStatement("delete from report where mob ='"+mob+"'");
rs=ps.executeQuery();
ps.close();
conn.close();

%>
</body>
</html>