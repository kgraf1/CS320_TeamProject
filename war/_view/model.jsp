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
			${model.title}
		</div>
		<div>
			${model.description}
		</div>
		<div>
			${model.category}
		</div>
		<div>
			${model.engPrinciple}
		</div>
		<div>
			${model.thumbnail}
		</div>
		<div>
			${model.citation}
		</div>
		<div>
			${model.procedure}
		</div>
		<div>
			${application.beforeClass}
		</div>
		<div>
			${application.beforeImage}
		</div>
		<div>
			${application.duringClass}
		</div>
		<div>
			${application.duringImage}
		</div>
		<div>
			<c:forEach items="${keywords}" var="keyword">
				<div>
					${keyword.word}
				</div>
			</c:forEach>
		</div>
		<div>
			<c:forEach items="${materials}" var="material">
				<div style="font:bold">
					${material.name}
				</div>
				<div style="padding-left:20px">
					${material.quantity}
				</div>
				<div style="padding-left:20px">
					${material.description}
				</div>
				<div style="padding-left:20px">
					${material.buildTime}
				</div>
				<div style="padding-left:20px">
					${material.cost}
				</div>
			</c:forEach>
		</div>
		<div>
			<c:forEach items="${ratings}" var="rating">
				<div>
					${rating.rate}
				</div>
				<div>
					${rating.comment}
				</div>
			</c:forEach>
		</div>
	
	</form>
	
</body>
</html>