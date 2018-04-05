
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" type="text/css" href="homepageStyle.css">
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

<!-- Div for the categories tab. Until categories are implemented they all just go to the given error page  -->
<div id ="categoriesDiv">
	<aside id = "categories">
			<h2>Categories:</h2>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input class="hiddenButton" type="submit" name="getConstruction" value="Construction"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input class="hiddenButton" type="submit" name="getDynamics" value="Dynamics"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input class="hiddenButton" type="submit" name="getStatics" value="Statics"/>
			</form>
	</aside>
</div>

<!-- Div for the website welcome information   -->

<div id = "welcomeDiv">
	<section>
		Welcome!
		<p id = "paraCenter"> This is where our site description would be!</p>
	</section>
</div>

<!-- Div for the display of the most popualar models  -->

<div id = "pad">
	<div id = "popularDiv">	
		<section>
			<h4>Most Popular Models:</h4>
		</section>
	</div>
</div>

</body>
</html>