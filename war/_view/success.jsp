<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added Model!</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
</head>
<body>

<div class="topnav">
  <div class = "title"> Engineering Models </div>
  
  <a href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  <a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp">Profile</a>
  
  <a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  
  
</div>

<h1> Model Added Successfully!</h1>

<a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp">Return to profile page</a>

<!--<form action="${pageContext.servletContext.contextPath}/_view/profilepage.jsp" method="get">
			<input type="Submit" name="submitmodel" value="Return To Profile Page">
</form> -->

</body>
</html>