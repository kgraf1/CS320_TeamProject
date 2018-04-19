<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/result_page.css">


</head>
<body>
	
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/profilePage">Profile</a>

		<a class="active" href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  		
	</div>

	<form action="${pageContext.servletContext.contextPath}/ModelsByMaterial" method="post">
		<table style="margin-top:30px;">
			<c:forEach items="${models}" var="model">
				<tr class="modelRow">
					<tr>
						<td class="modelTitle"><button class="hiddenButton" onclick="form.action='DisplayModel';" name="modelID" value="${model.id}">${model.title}</button></td>
					</tr>
					<tr>
						<td class="modelDescription">${model.description}</td>
					</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>