<!DOCTYPE html>
<html>
<title>Profile Page</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">



<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/profileoptions.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/_view/homepageStyle.css">
<!-- import the homepage css for navigation bar-->
<style>
   
</style>
<body>

 <!-- Top Navigation -->
    <div class="topnav">
        <div class="title"> Engineering Models </div>
		<a href="${pageContext.servletContext.contextPath}/homepage">Home</a>
        <a class="active" href="${pageContext.servletContext.contextPath}/profilePage" method="post">Profile</a>
        <a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
	</div>
    
    <!-- Page Container --> 
    <h1>Profile Options</h1>
    
    <form action="${pageContext.servletContext.contextPath}/ProfileOptions" method="post">
    <div style="border:2px solid gray">
				<h3>Change Username:</h3>
				<textarea id="newusername" name="newusername" placeholder="New Username" style="height:100px;width:250px;" value="${newusername}"></textarea>
				
	</div>
	<br>
	<div style="border:2px solid gray">
				<h3>Change Password:</h3>
				<textarea id="newpassword" name="newpassword" placeholder="New Password" style="height:100px;width:250px;" value="${newpassword}"></textarea>
				
	</div>
	<br>
	<div style="border:2px solid gray">
		<input type="Submit" class="button" name="submitchanges" value="Submit Changes"/>
	</div>
    </form>
    
</body>
</html>