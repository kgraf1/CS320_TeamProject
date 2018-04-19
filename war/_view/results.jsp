<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>Results Page</title>

<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/result_page.css">
</head>


<body>

<!-- Here is all the stuff for the topnav || links to profile page, home and search  -->
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp">Profile</a>
  		
	</div>


	<form action="${pageContext.servletContext.contextPath}/Search" method="post">
		<table>
			<c:forEach items="${models}" var="model">
				<tr class="modelRow">
					<tr>
						<td class="modelTitle">${model.title}</td>
					</tr>
					<tr>
						<td class="modelDescription">${model.description}</td>
					</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>