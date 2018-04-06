<!DOCTYPE html>

<html>
	<head>
		<title>Model Website Search</title>
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
	<div class="search-container">
    <form action="${pageContext.servletContext.contextPath}/Search">
      <input type="text" placeholder="Search.." name="searchInput" >
      <button type="submit">Submit</button>
		<aside>
		
		<input type="radio" id="getKeyword" name="search"/>
		<label for="getKeyword">Search by Keyword</label><br>
		<input type="radio" id="getTitle" name="search"/>
		<label for="getTitle">Search by Title</label><br>
		<input type="radio" id="getMaterial" name="search"/>
		<label for="getMaterial">Search by Material</label><br>
		<input type="radio"	id="getProfile" name="search"/>
		<label for="getProfile">Search by Profile</label><br>
		</aside>
	</form>
	</div>
	</body>
</html>