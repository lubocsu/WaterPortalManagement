<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String mob1=request.getParameter("mno");
String pwd1=request.getParameter("pwd");
HttpSession ses=request.getSession();
if(mob1.equals((String)ses.getAttribute("mobno"))&&pwd1.equals((String)ses.getAttribute("pwd")))
{out.println("cwp.jsp");
	RequestDispatcher rd=request.getRequestDispatcher("editc.html");
rd.forward(request, response);
		
	}
else%>

<h1>INVALID DATA <a href="cpwd.html">TRY AGAIN</a></h1>

</body>
</html>