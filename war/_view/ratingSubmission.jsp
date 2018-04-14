<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Rating!</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">

</head>
<body>
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a class="active" href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp">Profile</a>

		<a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  		
	</div>
	
	 <form action="${pageContext.servletContext.contextPath}/addRatingSubmission" method="post">
	 	<p>The model this rating will be added to is ${modelId}</p>
		<br>
		<div class="materialList" style="border: 2px solid gray">
			<h3>Add a new Rating!</h3>
            	<textarea id="newrate" name="newrate" placeholder="Rating out of 5" style="height:100px;width:250px;" value="${newrate}"></textarea>
            	<textarea id="newrate" name="newcomment" placeholder="Comment" style="height:100px;width:250px;" value="${newcomment}"></textarea>
            </div>
         <input type="Submit" name="submitrating" value="Add New Rating!"> 
	</form>
</body>
</html>