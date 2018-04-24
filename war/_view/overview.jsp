<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/result_page.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/models.css">

</head>
<body>
	
	<!-- Here is all the stuff for the topnav || links to profile page, home and search  -->
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/profilePage">Profile</a>

		<a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  		
  		
	</div>
	
	<form action="${pageContext.servletContext.contextPath}/DisplayModel" method="post">
	<div>
		<h1>${model.title}</h1>
		</div>
		<div><center>Written By: <button class="hiddenButton" onclick="form.action='ModelsByProfileName';" name="searchInput" value="${profile.firstName} ${profile.lastName}">${profile.firstName} ${profile.lastName}</button></center></div><br>
	
	
		<div class="tab">
			<button class="active" onclick="form.action='DisplayModel';" name="overviewModelID" value="${model.id}">Overview</button>
			<button onclick="form.action='DisplayModel';" name="engPrincipleModelID" value="${model.id}">Engineering Principle</button>
			<button onclick="form.action='DisplayModel';" name="procedureModelID" value="${model.id}">Procedure</button>
			<button onclick="form.action='DisplayModel';" name="applicationModelID" value="${model.id}">Application</button>
			<button onclick="form.action='DisplayModel';" name="materialsModelID" value="${model.id}">Materials</button>		
			<button onclick="form.action='DisplayModel';" name="ratingsModelID" value="${model.id}">Ratings</button>
		</div>
	

		<div style="float:right; width:67%">
		<div style="border:2px solid gray">
			<h3>Description:</h3>
				<div style="padding-left:20px; padding-right:20px;">${model.description}</div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Category:</h3>
				<div style="padding-left:20px; padding-right:20px;"><button class="hiddenButton" onclick="form.action='ModelsByCategory';" name="searchInput" value="${model.category}">${model.category}</button></div><br>
		</div>
		<br>	
		<div style="border: 2px solid gray">
			<h3>Keywords:</h3>
			<c:forEach items="${keywords}" var="keyword">
				<div style="padding-left:20px; padding-right:20px;"><button class="hiddenButton" onclick="form.action='ModelsByKeyword';" name="searchInput" value="${keyword.word}">${keyword.word}</button></div><br>
			</c:forEach>
		</div>
		<br>
		</div>
	</form>
	
</body>
</html>