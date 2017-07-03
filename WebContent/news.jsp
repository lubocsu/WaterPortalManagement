<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="java.sql.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>

<body>

<h1>NEWS</h1>
<% 

Class.forName("com.mysql.jdbc.Driver");
String URL="jdbc:mysql://localhost:3306/project";
conn=DriverManager.getConnection(URL,"root","shrikara");
ps=conn.prepareStatement("select * from news order by no desc limit 20");
rs=ps.executeQuery();
%>
<h2><b><i><u>HEADLINES</u></i></b></h2><br/>
<%while(rs.next()) {%>
<h2>
<%=rs.getString(2) %></h2>
<br/>

<form name="frm" method="post" action="full" target="_blank" >
<input type="hidden" name="readmore" value="<%= rs.getInt(1) %>">
<input type="submit" value="READ MORE" />


</form>

<br/>
<%

}
ps.close();
conn.close();

%>
</body>

</html>