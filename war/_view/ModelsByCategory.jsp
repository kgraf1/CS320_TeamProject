<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="result_page.css">

</head>
<body>
	
	<!-- Here is all the stuff for the topnav || links to profile page, home and search  -->
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a class="active" href="homepage.jsp">Home</a>
  
  		<a href="profilepage.jsp">Profile</a>
  
  		<div class="search-container">
    		<form action="search.jsp">
      			<input type="text" placeholder="Search.." name="search" >
      			<button type="submit">Submit</button>
      		</form>
  		</div>
	</div>

	<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
		<c:forEach items="${models}" var="model">
			<tr class="modelRow">
				<tr>
					<td class="modelName">${model.title}</td>
				</tr>
				<tr>
					<td class="modelDescription">${model.description}</td>
				</tr>
		</c:forEach>
	</form>

</body>
</html>