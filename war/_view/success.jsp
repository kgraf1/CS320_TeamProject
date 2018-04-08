<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success!</title>
</head>
<body>
<h1> Model Added Successfully!</h1>

<form action="${pageContext.servletContext.contextPath}/_view/profilepage.jsp" method="post">
			<input type="Submit" name="submitmodel" value="Return To Profile Page">
</form> 

</body>
</html>