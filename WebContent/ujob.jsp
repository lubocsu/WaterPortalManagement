<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function validate()
{if(rpt.head.value!=""&&rpt.body.value!="")
	return true;
else return false;
}
</script>
</head>
<body>
<img src="D:\eclipse_project_saved_content\WMS\logo.jpg" height="25%" width="550" >
<form action="admin.html">
<button type="submit" >HOME</button>
</form>
<form name="rpt" method="post" action="uj" target="_parent" onsubmit="return validate()">
<h1>UPLOAD JOB</h1>
<h2>HEADDER : </h2><textarea  rows="1" cols="30" name="head" ></textarea>[max of 30 characters] <br/><br/>
<h2>DESCRIPTION : </h2><textarea rows="5" cols="20" name="body" ></textarea>[max of 100 characters]<br/><br/>
<input type="submit" value="Submit"/>
</form>
</body>
</html>