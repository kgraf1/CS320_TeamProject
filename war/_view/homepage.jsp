
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
</head>

<body>

<!-- Here is all the stuff for the topnav || links to profile page, home and search  -->
<div class="topnav">
  <div class = "title"> Engineering Models </div>
  
  <a href="${pageContext.servletContext.contextPath}/homepage">Home</a>
  
  <a>
  	<form action="${pageContext.servletContext.contextPath}/profilePage" method="get">
  		<input type="submit" style="background:none;border:0;font-size:15px;" name="getProfile" value="Profile"/>
  	</form>
 </a>
  
  <a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  
  
</div>


<!-- Div for the categories tab. Until categories are implemented they all just go to the given error page  -->
<div id ="categoriesDiv">
	<aside >
			<h2>Categories:</h2>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getThermo" value="Thermodynamics"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getConstruction" value="Construction"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getDynamics" value="Dynamics"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getFluids" value="Fluids"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getHeat" value="Heat Transfer"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getMaterial" value="Material Science"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getMechanics" value="Mechanics"/>
			</form>
			<br>
			<form action="${pageContext.servletContext.contextPath}/ModelsByCategory" method="post">
				<input style="font-size:30px;" class="hiddenButton" type="submit" name="getStatics" value="Statics"/>
			</form>
	</aside>
</div>

<!-- Div for the website welcome information   -->

<div id = "welcomeDiv">
	<section>
		<p id = "paraCenter"> Welcome to Engineering Models! Here you can find models for your engineering 
		class! Search for models by Category, Keyword, their Materials, or by who made it! You can even 
		give the model a rating and leave a comment! 
		<br>
		To add your own, just go to your profile page above to fill out the form and submit!
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