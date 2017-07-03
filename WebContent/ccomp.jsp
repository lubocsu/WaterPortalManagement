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

<h1>COMPLAINTS TO BE ATTENDED</h1><p>                                                                                         </p>
<form>
<button type="submit" formaction="admin.html" >HOME</button>
</form>
<br/><br/>
<% 
Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
String URL="jdbc:mysql://localhost:3306/project";
conn=DriverManager.getConnection(URL,"root","shrikara");
ps=conn.prepareStatement("select * from report");
rs=ps.executeQuery();
%>
<table border="1" align="center">
<tr align="center">
<th>COMPLAINT NUMBER</th>
<th>SUBJECT</th>
<th>MOBILE NO.</th>
<th>NAME</th>
</tr>

<%while(rs.next()) {%>
<tr align="center">
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(4) %></td>
<td><%=rs.getString(5) %></td>
</tr>
<%

}
ps.close();
conn.close();

%>

</table>
<form method="post" action="del">
<h1>ATTENDED A COMPLAINT??</h1><br/><br/>
Complaint Number :<input type="text" name="att"/>
<br/>
<input type="submit" value="ATTENDED"/>

</form>

</body>
</html>