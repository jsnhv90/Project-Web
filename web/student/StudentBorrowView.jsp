<%-- 
    Document   : StudentBorrowView
    Created on : Oct 24, 2017, 11:31:26 AM
    Author     : vy dau khac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Borrow</title>
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
            <c:if test="${empty requestScope.books}">
                <h2>No Chosen Books</h2> 
            </c:if>
            <c:if test="${not empty requestScope.books}">
                <div class="w3-container w3-white">
                    <h2>Your Chosen Books</h2>
                    <hr>
                    <table class="w3-table">
                        <tr>
                            <th>ISBN</th>
                            <th>Title</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach items="${requestScope.books}" var="b">
                            <tr>
                                <td>${b.isbn}</td>
                                <td>${b.title}</td>
                                <td><a href="bookinfo?isbn=${b.isbn}" class="w3-button"><i class="fa fa-eye"></i> View</a></td>
                                <td><button class="w3-button" onclick="remove(${b.isbn}, this)"><i class="fa fa-remove"></i> Remove</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

                <div class="w3-container w3-white">

                    <form action="borrow" method="POST">
                        <hr><span style="margin-left: 40%"></span>
                        <input type="submit" class="w3-button w3-dark-grey" value="Borrow">
                    </form>

                </div>
            </c:if>

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

            function remove(isbn, btn) {
                $.ajax({
                    type: "POST",
                    url: "cart",
                    data: ({
                        isbn: isbn
                    }),
                    success: function (result) {
                        alert(result);
                        //remove from table
                        var row = btn.parentNode.parentNode;
                        row.parentNode.removeChild(row);
                    }
                });
            }
        </script>

    </body>
</html>

