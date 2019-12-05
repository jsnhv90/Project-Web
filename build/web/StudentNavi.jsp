<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                <a href="/BookManagement/student/search" class="w3-bar-item w3-button w3-padding"><i class="fa fa-search fa-fw"></i> Search</a>
                <a href="/BookManagement/student/borrow" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> View Your Chosen & Borrow</a>
                <a href="/BookManagement/student/news" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell fa-fw"></i> Notification</a>
                <a href="/BookManagement/student/profile" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i> Profile</a>
                <a href="/BookManagement/student/history" class="w3-bar-item w3-button w3-padding"><i class="fa fa-history fa-fw"></i> History</a>
                <a href="/BookManagement/logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Log out</a><br><br>
            </div>
        </nav>
    </body>
</html>
