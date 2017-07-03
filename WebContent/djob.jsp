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

<h1>JOBS.....</h1><p>                                                                                         </p>
<form action="admin.html">
<button type="submit"  >HOME</button>
</form>
<br/><br/>
<% 
Connection conn=null;
PreparedStatement ps=null;
ResultSet rs=null;
Class.forName("com.mysql.jdbc.Driver");
String URL="jdbc:mysql://localhost:3306/project";
conn=DriverManager.getConnection(URL,"root","shrikara");
ps=conn.prepareStatement("select * from job");
rs=ps.executeQuery();
%>
<table border="1" align="center">
<tr align="center">
<th>JOB NUMBER</th>
<th>HEADDER</th>
<th>DESCRIPTION</th>

</tr>

<%while(rs.next()) {%>
<tr align="center">
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(4) %></td>

</tr>
<%

}
ps.close();
conn.close();

%>

</table>
<form method="post" action="jdel">
<h1>DELETE A JOB??</h1><br/><br/>
JOB Number :<input type="text" name="att"/>
<br/>
<input type="submit" value="DELETE"/>

</form>

</body>
</html>