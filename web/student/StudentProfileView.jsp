<%-- 
    Document   : StudentProfileView
    Created on : Oct 22, 2017, 8:27:32 PM
    Author     : vy dau khac
--%>

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
            body{
                color:darkslategray;
                background-color: seashell;
            }
        </style>
    </head>
    <body class="w3-light-grey">

        <!-- Top container -->
        <div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
            <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i> Menu</button>
            <span class="w3-bar-item w3-right">TM Library</span>
        </div>

        <!-- Sidebar/menu -->
        <jsp:include page="../StudentNavi.jsp" />


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">
            <form action="profile" method="POST">
                <div class="w3-container w3-white">
                    <h2>Your Profile</h2>
                    <hr>
                    <!--profile-->
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-half w3-margin-bottom">
                            <label></i> User Name</label>
                            <input class="w3-input w3-border" type="text" name="username" value="${sessionScope["account"].username}" readonly>
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Password</label>
                            <input class="w3-input w3-border" type="password" name="password" 
                                   value="${sessionScope["account"].password}" required 
                                   onmousedown="this.type = 'text'" onmouseup="this.type = 'password'" 
                                   onmousemove="this.type = 'password'">
                        </div>
                    </div>
                </div>

                <div class="w3-container w3-white">
                    <h2>Your Information</h2>
                    <hr>
                    <!--profile-->
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-half w3-margin-bottom">
                            <label></i> First Name</label>
                            <input class="w3-input w3-border" type="text" value="${sessionScope["account"].firstName}" disabled>
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Last Name</label>
                            <input class="w3-input w3-border" type="text" value="${sessionScope["account"].lastName}" disabled>
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Gender</label><br>
                            <input class="w3-radio" type="radio" ${sessionScope["account"].male eq true ? 'checked' : ''} disabled> Male
                            <input class="w3-radio" type="radio" ${sessionScope["account"].male eq false ? 'checked' : ''} disabled> Female
                        </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Phone</label>
                            <input class="w3-input w3-border" type="text" name="phone" value="${sessionScope["account"].phone}" required>
                        </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Birth Date</label>
                            <input class="w3-input w3-border" type="date" value="${sessionScope["account"].dob}" disabled>
                        </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Address</label>
                            <input class="w3-input w3-border" type="text" name="address" value="${sessionScope["account"].address}" required>
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Student ID</label>
                            <input class="w3-input w3-border" type="text" value="${sessionScope["account"].studentId}" disabled>
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Email</label>
                            <input class="w3-input w3-border" type="text" name="email" value="${sessionScope["account"].email}" required>
                        </div>
                    </div>
                </div>
                <div class="w3-container w3-white">    
                    <hr><span style="margin-left: 35%"></span>
                    <input class="w3-button w3-dark-grey" type="submit" value="Update Profile"/><br><br>
                </div>
            </form>

            <!-- Footer -->
            <jsp:include page="/Footer.jsp"/>

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
