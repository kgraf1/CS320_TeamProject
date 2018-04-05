<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
		<br>
		<form action="${pageContext.servletContext.contextPath}/modelsbytitle" method="get">
			<input type="Submit" name="submitmodelsbytitle" value="Search for Models By Title">
		</form>
		<br>
		<form action="${pageContext.servletContext.contextPath}/modelsbykeywords" method="post">
			<input type="Submit" name="submitmodelbykeyword" value="Search for Models by Keywords">
		</form>	
		<br>			
		<form action="${pageContext.servletContext.contextPath}/modelsbymaterial" method="post">
			<input type="Submit" name="submitmodelbymaterial" value="Search for Models by Material">
		</form>	
		<br>			
		<form action="${pageContext.servletContext.contextPath}/modelsbyprofilename" method="get">
			<input type="Submit" name="submitmodelbyprofilename" value="Search for Models by Profile Name">
		</form>
		<br>
	</body>
</html>