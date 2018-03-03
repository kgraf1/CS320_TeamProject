
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" type="text/css" href="homepageStyle.css">
</head>

<body>

<!-- Here is all the stuff for the topnav || links to porfile page, home and search  -->
<div class="topnav">
  <div class = "title"> Engineering Models </div>
  <a class="active" href="homepage.jsp">Home</a>
  <a href="error.jsp">Profile</a>
  
  
 
  <div class="search-container">
    <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit">Submit</button>
    </form>
  </div>
</div>

<!-- Div for the categories tab. Untill catagories are implemented they all just go to the given error page  -->
<div id ="categoriesDiv">
	<aside id = "categories">
		<h2>
			Categories:
			<br>
			<a href = "error.jsp">Construction</a>
			<br>
			<a href = "error.jsp">Dynamics</a>
			<br>
			<a href = "error.jsp">Heat Transfer</a>
		</h2>
		

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