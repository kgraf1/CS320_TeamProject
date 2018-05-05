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
   	
    <form action="${pageContext.servletContext.contextPath}/profilePage" method="post">
 
    <div class="container content" style="max-width:1400px;margin-top:80px">
        <!-- The Grid -->
        <div class="row">
            <!-- Left Column -->
            <div class="col left">
            	<br>
                <!-- Profile -->
                <div class="card">
                    <div class="container" style="padding:20px;display:inline-block;width:285px;text-align:center!important;">
                        <h4>My Profile</h4>
                        <hr>
                		<p><img src="_view/profilepicture.jpg" style="width:100px;border-radius:50px;"></p>
                        <p>${profile.firstName} ${profile.lastName}</p>
                        <p>${profile.email}</p>
                        
                        <td><input type="submit" class="button" name="logout" value="Log Out"/></td>
                        <td><input type="submit" class="button" name="options" value="Options"/></td>
                        <!-- <button  class="hiddenButton" onclick="form.action='ProfileOptions';" name="profileId" value="${profileId}"> Options</button><br>
                    	-->
                    </div>
                </div>
                <br>

                <div class="card">
                    <div class="container">
                    	<input type="Submit" class="button" style="width:240px;margin-top:15px;" name="SubmitModel" value="Submit Model">
                    </div>
                </div>
				
                <!-- End Left Column -->
            </div>

            <!-- Middle Column -->
            <div class="col middle">

				<c:if test="${empty models}">
			    	<div class="container card" style="margin:16px!important; width:757px">
			    		<br>
                    	<h4 style="text-align:center;"> You do not have any models. </h4><br>
			    	</div>
			    </c:if>
			    
			  
				<c:forEach items="${models}" var="model">
		        	<div class="container card" style="margin:16px!important; width:757px">
                		<br>
                		<h4 style="text-align:center;"> ${model.title} </h4><br>
                		<hr class="clear">
                		<p style="font-weight:bold;">Model Description:</p> <p> ${model.description} </p>
                		<div style="margin:0 -16px;padding:0 8px;">
                		</div>
                		<button class="button" onclick="form.action='DisplayModel';" style:"width:150px;" name="modelID" value="${model.id}">See more!</button>
            		</div>
		    	</c:forEach>
			   
			</div>
				
            <!-- End Middle Column -->
            
            </div>
            
            <!-- End Grid -->
        </div>

        <!-- End Page Container -->
    </div>
    </form>
</body>
</html>
