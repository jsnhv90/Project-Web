
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
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
            <span class="w3-bar-item w3-right">Book Store</span>
        </div>


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">
            <c:if test="${not empty error}">
                <h3 style="color: red">${error}</h3>
        </c:if>
            <form action="reg" method="post">
                <div class="w3-container w3-white">
                    <h2>Register Account</h2>
                    <hr>
                    <!--profile-->
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-half w3-margin-bottom">
                            <label></i> User Name</label>
                            <input class="w3-input w3-border" name="uid" type="text">
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Password</label>
                            <input class="w3-input w3-border" name="pwd" type="password" 
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
                            <input class="w3-input w3-border" name="fname" type="text" >
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Last Name</label>
                            <input class="w3-input w3-border" name="lname" type="text" >
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Gender</label><br>
                            <input class="w3-radio" name="gender" type="radio" value="male"> Male
                            <input class="w3-radio" name="gender" type="radio" value="female"> Female
                        </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Phone</label>
                            <input class="w3-input w3-border" name="phone" type="text" >
                        </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Birth Date</label>
                            <input class="w3-input w3-border" name="date" type="date" >
                        </div>
                        <div class="w3-quarter w3-margin-bottom">
                            <label></i> Address</label>
                            <input class="w3-input w3-border" name="address" type="text" >
                        </div>
                    </div>
                    <div class="w3-row-padding" style="margin:0 -16px;">
                        <div class="w3-half w3-margin-bottom">
                            <label></i> ID Number: </label>
                            <input class="w3-input w3-border" name="id" type="text" >
                        </div>
                        <div class="w3-half w3-margin-bottom">
                            <label></i> Email</label>
                            <input class="w3-input w3-border" name="email" type="text" >
                        </div>
                    </div>
                </div>
                <div class="w3-container w3-white">
                    <hr><span style="margin-left: 35%"></span>
                    <input class="w3-button w3-dark-grey" type="submit" value="Register Account" onclick=""/><br><br>
                    <input class="w3-button w3-dark-grey" type="reset" value="Clear All" onclick=""/><br><br>
                    <a href="LoginView.jsp">Go Back</a>
                </div>
            </form>       


            <!-- Footer -->
            <footer class="w3-container w3-padding-16 w3-light-grey">
                <p>&copy; Powered by <a href="https://www.facebook.com/iam.tunq" title="W3.CSS" target="_blank" class="w3-hover-text-green">Nguyễn Việt Tùng</a></p> and <a href="https://www.facebook.com/muthiendia" title="W3.CSS" target="_blank" class="w3-hover-text-green">Hoàng Mạnh</a>  
            </footer>

            <!-- End page content  --> 
        </div>
        <script type="text/javascript">
            $('input').prop("required", true);
        </script>


    </body>
</html>
