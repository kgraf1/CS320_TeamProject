<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/result_page.css">

</head>
<body>
	
	<!-- Here is all the stuff for the topnav || links to profile page, home and search  -->
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a class="active" href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp">Profile</a>

		<a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  		
	</div>
	
	<form action="${pageContext.servletContext.contextPath}/DisplayModel" method="post">
	
		<div>
			<h1>${model.title}</h1>
		</div>
		<div><center>Written By: <button class="hiddenButton" onclick="form.action='ModelsByProfileName';" name="searchInput" value="${profile.firstName} ${profile.lastName}">${profile.firstName} ${profile.lastName}</button></center></div><br>
		<div style="border:2px solid gray">
			<h3>Description:</h3>
				<div style="padding-left:20px">${model.description}</div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Category:</h3>
				<div style="padding-left:20px"><button class="hiddenButton" onclick="form.action='ModelsByCategory';" name="searchInput" value="${model.category}">${model.category}</button></div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Engineering Principle:</h3>
				<div style="padding-left:20px">${model.engPrinciple}</div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Thumbnail:</h3>
				<div style="padding-left:20px">${model.thumbnail}</div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Citation:</h3>
				<div style="padding-left:20px">${model.citation}</div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Procedure:</h3>
				<div style="padding-left:20px">${model.procedure}</div><br>
		</div>
		<br>
		<div style="border: 2px solid gray">
			<h3>Application:</h3>
				<h4 style="padding-left:20px">Before Class:</h4>
					<div style="padding-left:40px">${application.beforeClass}</div><br>
				<h4 style="padding-left:20px">Before Image:</h4>	
					<div style="padding-left:40px">${application.beforeImage}</div><br>
				<h4 style="padding-left:20px">During Class:</h4>	
					<div style="padding-left:40px">${application.duringClass}</div><br>
				<h4 style="padding-left:20px">During Image:</h4>	
					<div style="padding-left:40px">${application.duringImage}</div><br>
		</div>	
		<br>	
		<div style="border: 2px solid gray">
			<h3>Keywords:</h3>
			<c:forEach items="${keywords}" var="keyword">
				<div style="padding-left:20px"><button class="hiddenButton" onclick="form.action='ModelsByKeyword';" name="searchInput" value="${keyword.word}">${keyword.word}</button></div><br>
			</c:forEach>
		</div>
		<br>
		<div style="border: 2px solid gray">
		<h3>Materials:</h3>
			<c:forEach items="${materials}" var="material">
				<div style="font:bold; padding-left:20px;"><button class="hiddenButton" onclick="form.action='ModelsByMaterial';" name="searchInput" value="${material.name}">${material.name}</button></div><br>
				<div style="padding-left:40px">Quantity: ${material.quantity}</div><br>
				<div style="padding-left:40px">Description: ${material.description}</div><br>
				<div style="padding-left:40px">Build Time: ${material.buildTime}</div><br>
				<div style="padding-left:40px">Cost: ${material.cost}</div><br>
			</c:forEach>
		</div>
		<br>
		<div style="border:2px solid gray">
			<h3 style="padding-left:20px">Ratings:</h3>
			<h4 style="padding-left:40px;">An average rating of ${average}</h4>
			<c:forEach items="${ratings}" var="rating">
				<h4 style="padding-left:20px">Rating</h4>
					<div style="padding-left:40px">${rating.rate}</div><br>
				
				<h4 style="padding-left:40px">Comment:</h4>
					<div style="padding-left:60px">${rating.comment}</div><br>
			</c:forEach>
		</div>
		<br>
		  <!--  
		  <div class="materialList" style="border: 2px solid gray">
			<h3>Add a new Rating! Test with just onclick</h3>
            	<textarea id="newrating" name="newrate" placeholder="Rating out of 5" style="height:100px;width:250px;" value = "${newrating}"></textarea>
            	<textarea id="newcomment" name="newcomment" placeholder="Comment" style="height:100px;width:250px;" value = "${newcomment }"></textarea>
            <td class="AddRating"><button class="hiddenButton" method = "get" onclick="form.action='addRatingSubmission';"  name="modelID" value="${model.id}">Add a New Rating</button></td>
           </div>
         -->
	</form>
	<form action = "${pageContext.servletContext.contextPath}/addRatingSubmission" method="get">
	<br>
		<div class="materialList" style="border: 2px solid gray">
			<h3>Add a new Rating!</h3>
			<br>
            <td class="AddRating"><button class="hiddenButton" method = "get" onclick="form.action='addRatingSubmission';"  name="modelID" value="${model.id}">Add a New Rating</button></td>
           </div>
		
	</form>
	<!--<a href="${pageContext.servletContext.contextPath}/_view/ratingSubmission.jsp" > Go to add rating via href</a>-->
</body>
</html>