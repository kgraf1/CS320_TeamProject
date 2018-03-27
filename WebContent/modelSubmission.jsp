<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="modelSubmission.css">
</head>
<body>

    <h3 style="text-align: center;">Model Submission</h3>

    <div class="container">
        <form action="/action_page.php">
            <label for="fname">Model Name</label>
            <input type="text" id="modelName" name="modelName" placeholder="">

            <label for="Category">Category</label>
            <select id="category" name="category">
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
            <textarea id="description" name="description" placeholder="Description of your model..." style="height:200px"></textarea>

            <label for="ePrinciple">Engineering Principle</label>
            <textarea id="ePrinciple" name="ePrinciple" placeholder="Principle of your model..." style="height:200px"></textarea>

            <label for="materialdata" style="margin-left: 100px;">Materials Used</label>

            <div class="materialList">
                <textarea id="material1" name="material" placeholder="Material" style="height:100px;width:250px;"></textarea>
                <textarea id="material1" name="quantity" placeholder="Quantity" style="height:100px;width:250px;"></textarea>
                <textarea id="material1" name="cost" placeholder="Cost" style="height:100px;width:250px;"></textarea>
                <textarea id="material1" name="buildTime" placeholder="BuildTime" style="height:100px;width:250px;"></textarea>
                <textarea id="material1" name="description" placeholder="Description" style="height:100px;width:250px;"></textarea>
            </div>

            <div class="materialList">
                <textarea id="material2" name="material" placeholder="Material" style="height:100px;width:250px;"></textarea>
                <textarea id="material2" name="quantity" placeholder="Quantity" style="height:100px;width:250px;"></textarea>
                <textarea id="material2" name="cost" placeholder="Cost" style="height:100px;width:250px;"></textarea>
                <textarea id="material2" name="buildTime" placeholder="BuildTime" style="height:100px;width:250px;"></textarea>
                <textarea id="material2" name="description" placeholder="Description" style="height:100px;width:250px;"></textarea>
            </div>

            <label for="application">Application</label>
            <textarea id="application" name="application" placeholder="Application of your model..." style="height:200px"></textarea>

            <button type="submit"><a href="profilepage.jsp">Submit</a></button>
         </form>
    </div>

</body>
</html>