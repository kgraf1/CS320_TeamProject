<!DOCTYPE html>
<html>
<title>Profile Page</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/profilepage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/homepageStyle.css">
<!-- import the homepage css for navigation bar-->


<body>
    <!-- Top Navigation -->
    <div class="topnav">
        <div class="title"> Engineering Models </div>
		<a href="${pageContext.servletContext.contextPath}/homepage">Home</a>
        <a href="${pageContext.servletContext.contextPath}/profilePage" method="post">Profile</a>
        <a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
	</div>
	
	<div style="padding-top:100px; ">
	<form action="${pageContext.servletContext.contextPath}/addProfileImage" method="get">
		<div class="card" style="width:50%; margin:auto;">
		<div class="container" style="padding:20px;width:500px;text-align:center!important; margin:auto;" >
			<h3>Add a new Profile Picture</h3>
			<input type="hidden" name="profileId" value="${profileId}">
			<input type="text" name="profileImage" placeholder="Enter Image Address Here...">
			<input type="submit" name="submitImage">
		</div>
		</div>
	</form>
	</div>