<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
        </style>
    </head>
    <body class="w3-light-grey">

        <!-- Top container -->
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Menu</button>
            <span class="w3-bar-item w3-right">Book Management</span>
        </div>

        <!-- Sidebar/menu -->
        <nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar"><br>
            <div class="w3-container w3-row">
                <div class="w3-col s4">
                    <img src=${sessionScope["account"].male eq true ? 
                               "/BookManagement/images/avatar_male.png" : "/BookManagement/images/avatar_female.png"} 
                         class="w3-circle w3-margin-right" style="width:50px" />
                </div>
                <div class="w3-col s8 w3-bar">
                    <span>Welcome,<br><strong>${sessionScope["account"].firstName} ${sessionScope["account"].lastName}</strong></span>
                </div>
            </div>
            <hr>
            <div class="w3-container">
                <h5>Options</h5>
            </div>
            <div class="w3-bar-block">
                <a href="#" class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
                <a href="/BookManagement/admin/search" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search fa-fw"></i> Search</a>
                <a href="/BookManagement/admin/borrow" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> View borrow of students </a>
                <a href="/BookManagement/admin/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell fa-fw"></i> Report </a>
                <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-bank fa-fw"></i> Register </a>
                <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-history fa-fw"></i> History</a>
                <a href="/BookManagement/logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Log out</a><br><br>
            </div>
        </nav>


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <div class="w3-container w3-white">
                <h2>Register Account</h2>
                <hr>
                <!--profile-->
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label></i> User Name</label>
                        <input class="w3-input w3-border" type="text">
                    </div>
                    <div class="w3-half w3-margin-bottom">
                        <label></i> Password</label>
                        <input class="w3-input w3-border" type="password" 
                               onmousedown="this.type = 'text'" onmouseup="this.type = 'password'" 
                               onmousemove="this.type = 'password'">
                    </div>
                </div>
            </div>

            <div class="w3-container w3-white">
                <h2>Information</h2>
                <hr>
                <!--profile-->
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label></i> First Name</label>
                        <input class="w3-input w3-border" type="text" >
                    </div>
                    <div class="w3-half w3-margin-bottom">
                        <label></i> Last Name</label>
                        <input class="w3-input w3-border" type="text" >
                    </div>
                </div>
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-quarter w3-margin-bottom">
                        <label></i> Gender</label><br>
                        <input class="w3-radio" name="gender" type="radio" > Male
                        <input class="w3-radio" name="gender" type="radio" > Female
                    </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label></i> Phone</label>
                        <input class="w3-input w3-border" type="text" >
                    </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label></i> Birth Date</label>
                        <input class="w3-input w3-border" type="date" >
                    </div>
                    <div class="w3-quarter w3-margin-bottom">
                        <label></i> Address</label>
                        <input class="w3-input w3-border" type="text" >
                    </div>
                </div>
                <div class="w3-row-padding" style="margin:0 -16px;">
                    <div class="w3-half w3-margin-bottom">
                        <label></i> Student ID</label>
                        <input class="w3-input w3-border" type="text" >
                    </div>
                    <div class="w3-half w3-margin-bottom">
                        <label></i> Email</label>
                        <input class="w3-input w3-border" type="text" >
                    </div>
                </div>
            </div>
            <div class="w3-container w3-white">
                <hr><span style="margin-left: 35%"></span>
                <input class="w3-button w3-dark-grey" type="button" value="Register Account" onclick=""/><br><br>
            </div>

            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                <jsp:include page="../Footer.jsp" />
            </footer>

            <!-- End page content  --> 
        </div>

        <script>
            // Get the Sidebar
            var mySidebar = document.getElementById("mySidebar");
            // Get the DIV with overlay effect
            var overlayBg = document.getElementById("myOverlay");
            // Toggle between showing and hiding the sidebar, and add overlay effect
            function  w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

            // Close the sidebar with  the close button
            function  w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }
        </script>

    </body>
</html>
