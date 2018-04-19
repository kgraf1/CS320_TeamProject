<!DOCTYPE html>

<html>
	<head>
		<title>Model Website Search</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
		
		<style type="text/css">
			.error {
				color: red;
				font-weight: bold;				
			}
			
			tr.button {
				padding-left: 20px;
				margin: 20 px;
			}
		</style>
	</head>

	<body>
	
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/profilePage">Profile</a>
  		
  		<a class="active" href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  		
	</div>
	
	
	<div style="padding-top:30px;" class="search-container">
    <form action="${pageContext.servletContext.contextPath}/Search" method="post">
      <input type="text" placeholder="Search.." name="searchInput" >
      <button type="submit">Submit</button>
		<aside>
		
		<input type="radio" id="getKeyword" name="search" value="getKeyword"/>
		<label for="getKeyword">Search by Keyword</label><br>
		<input type="radio" id="getTitle" name="search" value="getTitle"/>
		<label for="getTitle">Search by Title</label><br>
		<input type="radio" id="getMaterial" name="search" value="getMaterial"/>
		<label for="getMaterial">Search by Material</label><br>
		<input type="radio"	id="getProfile" name="search" value="getProfile"/>
		<label for="getProfile">Search by Profile</label><br>
		</aside>
	</form>
	</div>
	</body>
</html>