<!DOCTYPE html>
<html>
<title>Profile Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">



<link rel="stylesheet" type="text/css" href="profilepage.css">
<link rel="stylesheet" type="text/css" href="homepageStyle.css">
<!-- import the homepage css for navigation bar-->
<style>
   
</style>
<body>
    <!-- Top Navigation -->
    <div class="topnav">
        <div class="title"> Engineering Models </div>

        <a class="active" href="${pageContext.servletContext.contextPath}/_view/homepage.jsp">Home</a>

        <a href="${pageContext.servletContext.contextPath}/_view/profilepage.jsp" method="post">Profile</a>
        
        <a href="${pageContext.servletContext.contextPath}/_view/search.jsp">Search Models</a>
</div>
    
    <!-- Page Container -->
    <div class="container content" style="max-width:1400px;margin-top:80px">
        <!-- The Grid -->
        <div class="row">
            <!-- Left Column -->
            <div class="col left">
                <!-- Profile -->
                <div class="card">
                    <div class="container" style="display:inline-block;width:auto;text-align:center!important;">
                        <h4>My Profile</h4>
                        <p><img src="C:\Users\katek\Downloads\avatar3.png" style="height:106px;width:106px;border-radius:50%;" alt="Avatar"></p>
                        <hr>
                        <p>Professor of Engineering</p>
                        <p>York, PA</p>
                    </div>
                </div>
                <br>

                <div class="card">
                    <div class="container">
                        <p><button type="button" class="button" style="width:300px;"><a href="modelSubmission.jsp">Submit a model</a></button></p>
                    </div>
                </div>

                <!-- End Left Column -->
            </div>

            <!-- Middle Column -->
            <div class="col middle">

                <div class="container card" style="margin:16px!important; width:757px">
                    <br>
                    <img src="C:\Users\katek\source\repos\hammer.jpg" alt="Avatar" style="width:60px;float:left!important;border-radius:50%;margin-right:16px!important;">
                    <h4 style="text-align:center;">When Worlds Collide</h4><br>
                    <hr class="clear">
                    <p style="font-weight:bold;">Model Description:</p> <p> This model takes two objects and demonstrates yada yada yada...</p>
                    <p style="font-weight:bold;">Time:</p> <p> about 3 minutes</p>
                    <div style="margin:0 -16px;padding:0 8px;">
                    </div>
                    <button type="button"class="button" style="width:150px;">See more!</button>
                </div>

                <div class="container card" style="margin:16px!important; width:757px">
                    <br>
                    <img src="C:\Users\katek\source\repos\hammer.jpg" alt="Avatar" style="width:60px;float:left!important;border-radius:50%;margin-right:16px!important;">
                    <h4 style="text-align:center;">When Worlds Collide</h4><br>
                    <hr class="clear">
                    <p style="font-weight:bold;">Model Description:</p> <p> This model takes two objects and demonstrates yada yada yada...</p>
                    <p style="font-weight:bold;">Time:</p> <p> about 3 minutes</p>
                    <div style="margin:0 -16px;padding:0 8px">
                    </div>
                    <button type="button" class="button" style="width:150px;">See more!</button>
                </div>

                <div class="container card" style="margin:16px!important; width:757px">
                    <br>
                    <img src="C:\Users\katek\source\repos\hammer.jpg" alt="Avatar" style="width:60px;float:left!important;border-radius:50%;margin-right:16px!important;">
                    <h4 style="text-align:center;">When Worlds Collide</h4><br>
                    <hr class="clear">
                    <p style="font-weight:bold;">Model Description:</p> <p> This model takes two objects and demonstrates yada yada yada...</p>
                    <p style="font-weight:bold;">Time:</p> <p> about 3 minutes</p>
                    <div style="margin:0 -16px;padding:0 8px">
                    </div>
                    <button type="button" class="button" style="width:150px;">See more!</button>
                </div>

                <!-- End Middle Column -->
            </div>

            <!-- Right Column -->
            <div class="col right">
                <div class="card" style="text-align:center;">
                    <div class="container" style="display:inline-block;width:auto;text-align:center!important;">
                        <p>Upcoming Events:</p>
                        <img src="" alt="Image" style="width:100%;">
                        <p><strong>Holiday</strong></p>
                        <p>Friday 15:00</p>
                        <p><button class="button" style="color:#000!important;background-color:#dfe5e8!important;width:100%;">Info</button></p>
                    </div>
                </div>
                <br>

                <div class="card" style="text-align:center;">
                    <div class="container" style="display:inline-block;width:auto;text-align:center!important;">
                        <p>Friend Request</p>
                        <img src="" alt="Image" style="width:50%"><br>
                        <span>Jane Doe</span>
                        <div class="row" style="opacity:0.60;">
                            <div style="float:left;width:49.99999%">
                                <button class="button" style="color:#000!important;background-color:#dfe5e8!important;width:90px;" title="Accept">Accept</button>
                            </div>
                            <div style="float:left;width:49.99999%;">
                                <button class="button" style="color:#000!important;background-color:#dfe5e8!important;width:90px;" title="Decline">Decline</button>
                            </div>
                        </div>
                    </div>
                </div>
                <br>

                <div class="card" style="padding-top:16px!important;padding-bottom:16px!important;text-align:center;">
                    <p>ADS</p>
                </div>
                <br>

                <div class="card" style="padding-top:32px!important;padding-bottom:32px!important;text-align:center;">
                    <p><i class="fa fa-bug w3-xxlarge"></i></p>
                </div>

                <!-- End Right Column -->
            </div>

            <!-- End Grid -->
        </div>

        <!-- End Page Container -->
    </div>
    <br>

   
   
</body>
</html>
