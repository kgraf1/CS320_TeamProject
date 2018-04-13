<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/_view/modelSubmission.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/_view/homepageStyle.css">
</head>

<body>

	<!-- Uncomment when errorMessage is instantiated
 	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>
	--> 
	
    
	
	<div class="topnav">
  		<div class = "title"> Engineering Models </div>
  		<h3 style="text-align: center;">Model Submission</h3>
  		<a class="active" href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>
  
  		<a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp">Profile</a>

		<a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
  		
	</div>
	
    <div class="container">
        <form action="${pageContext.servletContext.contextPath}/addModelSubmission" method="post">
        
            <label for="name">Model Name</label>
            <textarea id="name" name="name" placeholder="Name... " value="${name}"></textarea>

            <label for="Category">Category</label>
            <select name="category">
                <option value="" disabled selected hidden>Please Choose...</option>
                <option value="construction">Construction</option>
                <option value="dynamics">Dynamics</option>
                <option value="fluids">Fluids</option>
                <option value="heatTransfer">Heat Transfer</option>
                <option value="materialScience">Material Science</option>
                <option value="mechanics">Mechanics</option>
                <option value="statics">Statics</option>
                <option value="thermodynamics">Thermodynamics</option>
            </select>

            <label for="description">Description</label>
            <textarea id="description" name="description" placeholder="Description of your model..." style="height:200px" value="${description}"></textarea>

            <label for="ePrinciple">Engineering Principle</label>
            <textarea id="ePrinciple" name="ePrinciple" placeholder="Principle of your model..." style="height:200px" value="{engPrinciple}"></textarea>

			<label for="keywords" style="margin-left: 100px;">Keywords</label>
			
			<div class="keywords">
				<textarea id="keyword1" name="keyword1" placeholder="keyword" style="height:100px;width:150px;" value="${keyword1}"></textarea>
				<textarea id="keyword2" name="keyword2" placeholder="keyword" style="height:100px;width:150px;" value="${keyword2}"></textarea>
				<textarea id="keyword3" name="keyword3" placeholder="keyword" style="height:100px;width:150px;" value="${keyword3}"></textarea>
				<textarea id="keyword4" name="keyword4" placeholder="keyword" style="height:100px;width:150px;" value="${keyword4}"></textarea>
				<textarea id="keyword5" name="keyword5" placeholder="keyword" style="height:100px;width:150px;" value="${keyword5}"></textarea>
			</div>
			
            <label for="materialdata" style="margin-left: 100px;">Materials Used</label>

            <div class="materialList">
            	<textarea id="material1" name="material1" placeholder="Material" style="height:100px;width:250px;" value="${material1}"></textarea>
            	<textarea id="material1" name="quantity1" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity1}"></textarea>
                <textarea id="material1" name="cost1" placeholder="Cost" style="height:100px;width:250px;" value="${cost1}"></textarea>
                <textarea id="material1" name="buildTime1" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime1}"></textarea>
                <textarea id="material1" name="description1" placeholder="Description" style="height:100px;width:250px;" value="${description1}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material2" name="material2" placeholder="Material" style="height:100px;width:250px;" value="${material2}"></textarea>
            	<textarea id="material2" name="quantity2" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity2}"></textarea>
                <textarea id="material2" name="cost2" placeholder="Cost" style="height:100px;width:250px;" value="${cost2}"></textarea>
                <textarea id="material2" name="buildTime2" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime2}"></textarea>
                <textarea id="material2" name="description2" placeholder="Description" style="height:100px;width:250px;" value="${description2}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material3" name="material3" placeholder="Material" style="height:100px;width:250px;" value="${material3}"></textarea>
            	<textarea id="material3" name="quantity3" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity3}"></textarea>
                <textarea id="material3" name="cost3" placeholder="Cost" style="height:100px;width:250px;" value="${cost3}"></textarea>
                <textarea id="material3" name="buildTime3" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime3}"></textarea>
                <textarea id="material3" name="description3" placeholder="Description" style="height:100px;width:250px;" value="${description3}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material4 name="material4" placeholder="Material" style="height:100px;width:250px;" value="${material4}"></textarea>
            	<textarea id="material4" name="quantity4" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity4}"></textarea>
                <textarea id="material4" name="cost4" placeholder="Cost" style="height:100px;width:250px;" value="${cost4}"></textarea>
                <textarea id="material4" name="buildTime4" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime4}"></textarea>
                <textarea id="material4" name="description4" placeholder="Description" style="height:100px;width:250px;" value="${description4}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material5" name="material5" placeholder="Material" style="height:100px;width:250px;" value="${material5}"></textarea>
            	<textarea id="material5" name="quantity5" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity5}"></textarea>
                <textarea id="material5" name="cost5" placeholder="Cost" style="height:100px;width:250px;" value="${cost5}"></textarea>
                <textarea id="material5" name="buildTime5" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime5}"></textarea>
                <textarea id="material5" name="description5" placeholder="Description" style="height:100px;width:250px;" value="${description5}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material6" name="material6" placeholder="Material" style="height:100px;width:250px;" value="${material6}"></textarea>
            	<textarea id="material6" name="quantity6" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity6}"></textarea>
                <textarea id="material6" name="cost6" placeholder="Cost" style="height:100px;width:250px;" value="${cost6}"></textarea>
                <textarea id="material6" name="buildTime6" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime6}"></textarea>
                <textarea id="material6" name="description6" placeholder="Description" style="height:100px;width:250px;" value="${description6}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material7" name="material7" placeholder="Material" style="height:100px;width:250px;" value="${material7}"></textarea>
            	<textarea id="material7" name="quantity7" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity7}"></textarea>
                <textarea id="material7" name="cost7" placeholder="Cost" style="height:100px;width:250px;" value="${cost7}"></textarea>
                <textarea id="material7" name="buildTime7" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime7}"></textarea>
                <textarea id="material7" name="description7" placeholder="Description" style="height:100px;width:250px;" value="${description7}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material8" name="material8" placeholder="Material" style="height:100px;width:250px;" value="${material8}"></textarea>
            	<textarea id="material8" name="quantity8" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity8}"></textarea>
                <textarea id="material8" name="cost8" placeholder="Cost" style="height:100px;width:250px;" value="${cost8}"></textarea>
                <textarea id="material8" name="buildTime8" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime8}"></textarea>
                <textarea id="material8" name="description8" placeholder="Description" style="height:100px;width:250px;" value="${description8}"></textarea>            	
            </div>
            
            <div class="materialList">
            	<textarea id="material9" name="material9" placeholder="Material" style="height:100px;width:250px;" value="${material9}"></textarea>
            	<textarea id="material9" name="quantity9" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity9}"></textarea>
                <textarea id="material9" name="cost9" placeholder="Cost" style="height:100px;width:250px;" value="${cost9}"></textarea>
                <textarea id="material9" name="buildTime9" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime9}"></textarea>
                <textarea id="material9" name="description9" placeholder="Description" style="height:100px;width:250px;" value="${description9}"></textarea>            	
            </div>

			<div class="materialList">
            	<textarea id="material10" name="material10" placeholder="Material" style="height:100px;width:250px;" value="${material10}"></textarea>
            	<textarea id="material10" name="quantity10" placeholder="Quantity" style="height:100px;width:250px;" value="${quantity10}"></textarea>
                <textarea id="material10" name="cost10" placeholder="Cost" style="height:100px;width:250px;" value="${cost10}"></textarea>
                <textarea id="material10" name="buildTime10" placeholder="BuildTime" style="height:100px;width:250px;" value="${buildTime10}"></textarea>
                <textarea id="material10" name="description10" placeholder="Description" style="height:100px;width:250px;" value="${description10}"></textarea>            	
            </div>
            
            <label for="application">Application</label>
            <textarea id="application" name="beforeClass" placeholder="Before class..." style="height:200px" value="${beforeClass}"></textarea>
            <textarea id="application" name="beforeImage" placeholder="Before image..." style="height:200px" value="${beforeImage}"></textarea>
            <textarea id="application" name="duringClass" placeholder="During class..." style="height:200px" value="${duringClass}"></textarea>
            <textarea id="application" name="duringImage" placeholder="During image..." style="height:200px" value="${duringImage}"></textarea>

           <input type="Submit" name="submitmodel" value="Create Physical Model">
         </form>
    </div>
</body>
</html>