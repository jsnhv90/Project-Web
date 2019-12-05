<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Search</title>
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
            <span class="w3-bar-item w3-right">FPT Library</span>
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
                <a href="#" class="w3-bar-item w3-button w3-padding w3-blue"><i class="fa fa-search fa-fw"></i> Search</a>
                <a href="/BookManagement/admin/borrow" class="w3-bar-item w3-button w3-padding"><i class="fa fa-eye fa-fw"></i> View borrow of students</a>
                <a href="/BookManagement/admin/report" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell fa-fw"></i> Report</a>
                <a href="/BookManagement/admin/register" class="w3-bar-item w3-button w3-padding"><i class="fa fa-bank fa-fw"></i> Register account </a>
                <a href="" class="w3-bar-item w3-button w3-padding"><i class="fa fa-history fa-fw"></i> History</a>
                <a href="/BookManagement/logout" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Log out</a><br><br>
            </div>
        </nav>


        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- !PAGE CONTENT! -->
        <div class="w3-main" style="margin-left:300px;margin-top:43px;">

            <div>
                <!--Searching form-->
                <div class="w3-container w3-white w3-padding-16">
                    <form action="" method="POST">  <!--go to search controller-->
                        <div class="w3-row-padding" style="margin:0 -16px;">
                            <div class="w3-half w3-margin-bottom">
                                <label><i class="fa fa-book"></i> Title</label>
                                <input class="w3-input w3-border" type="text" placeholder="Ex. Harry Potter" id="title">
                            </div>
                            <div class="w3-half">
                                <label><i class="fa fa-male"></i> Author</label>
                                <input class="w3-input w3-border" type="text" placeholder="Ex. J. K. Rowling" id="author">
                            </div>
                        </div>
                        <div class="w3-row-padding" style="margin:8px -16px;">
                            <div class="w3-quarter">
                                <label><i class="fa fa-tag"></i> Category</label>
                                <select class="w3-select w3-border" id="category">
                                    <option value="any">Any</option>
                                    <c:forEach items="${requestScope.categories}" var="category">
                                        <option value="${category}">${category}</option>
                                    </c:forEach>
                                    <!--load tu database ra cac category-->
                                </select>
                            </div>
                            <div class="w3-quarter">
                                <label><i class="fa fa-group"></i> Publisher</label>
                                <input class="w3-input w3-border" type="text" id="publisher" placeholder="Ex. Pearson">
                            </div>
                            <div class="w3-quarter">
                                <label><i class="fa fa-language"></i> Language</label>
                                <select class="w3-select w3-border" id="language">
                                    <option value="any">Any</option>
                                    <!--load tu database ra cac language-->
                                    <c:forEach items="${requestScope.languages}" var="language">
                                        <option value="${language}">${language}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="w3-quarter">
                                <label><i class="fa fa-bookmark"></i> Format</label>
                                <select class="w3-select w3-border" id="format">
                                    <option value="any">Any</option>
                                    <!--load tu database ra cac format-->
                                    <c:forEach items="${requestScope.formats}" var="format">
                                        <option value="${format}">${format}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <input class="w3-button w3-dark-grey" type="button" value="Search" onclick="search()"/>
                    </form>
                    <hr>
                </div>
                <!--Books-->
                <div id="demo" class="w3-white">
                    <c:forEach items="${requestScope.books}" var="book">
                        <div class="w3-container w3-white">
                            <div class="w3-quarter w3-margin">
                                <!--image and button of this book-->
                                <img src="/BookManagement/images/nobookcover.jpg" class="w3-image" style="height: 300px; margin-left: 10%; margin-bottom: 10px">
                                <input class="w3-button w3-dark-grey" type="button" style="margin-left: 10%" value="Add to Borrow" onclick="cart(${book.isbn}, '${book.title}', ${book.amount})"/>
                                <input class="w3-button w3-dark-grey" style="margin-left: 5%" type="button" value="Info" onclick="info('${book.isbn}')"/>
                            </div>
                            <div class="w3-twothird">
                                <!--book info-->
                                <h3><strong>${book.title}</strong></h3>
                                <h4 style="color: blue">${book.author.firstName} ${book.author.lastName}</h4>
                                <span class="fa fa-star w3-text-yellow w3-large">
                                    <strong>
                                        ${book.rating == 0 ? 'Not Rated': book.rating}
                                    </strong>
                                </span>
                                &nbsp; &nbsp; 
                                <span class="w3-large">${book.category}</span> 
                                <hr>
                                <p style="height: 200px; overflow-y: auto">
                                    ${book.description eq null ? 'No Description': book.description}
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                    <!--Paging - Pager-->
                    <hr><span style="margin-left: 25%"></span>
                    <c:if test="${requestScope.pageindex > 1}">
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(1)" value="First"> 
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(${requestScope.pageindex - 1})" value="Previous"> 
                    </c:if>
                    <c:if test="${requestScope.pageindex >= 3}">
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(${requestScope.pageindex - 2})" value="${requestScope.pageindex - 2}"> 
                    </c:if>
                    <c:if test="${requestScope.pageindex >= 2}">
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(${requestScope.pageindex - 1})" value="${requestScope.pageindex - 1}"> 
                    </c:if>
                    <input type="button" class="w3-button" value="${requestScope.pageindex} (Current page)">
                    <c:if test="${requestScope.pageindex + 1 <= requestScope.totalpage}">
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(${requestScope.pageindex + 1})" value="${requestScope.pageindex + 1}"> 
                    </c:if>
                    <c:if test="${requestScope.pageindex + 2 <= requestScope.totalpage}">
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(${requestScope.pageindex + 2})" value="${requestScope.pageindex + 2}"> 
                    </c:if>
                    <c:if test="${requestScope.pageindex < requestScope.totalpage}">
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(${requestScope.pageindex + 1})" value="Next"> 
                        <input type="button" class="w3-button w3-dark-grey" onclick="paging(1)" value="Last">
                    </c:if> 
                </div>
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

            function  paging(index) {
                var title = document.getElementById("title").value;
                var author = document.getElementById("author").value;
                var category = document.getElementById("category").value;
                var publisher = document.getElementById("publisher").value;
                var language = document.getElementById("language").value;
                var format = document.getElementById("format").value;
                $.ajax({
                    type: "GET",
                    url: "page",
                    data: ({
                        pageindex: index,
                        title: title,
                        author: author,
                        category: category,
                        publisher: publisher,
                        language: language,
                        format: format
                    }),
                    success: function (result) {
                        $("#demo").html(result);
                    }
                });
            }

            function search() {
                var title = document.getElementById("title").value;
                var author = document.getElementById("author").value;
                var category = document.getElementById("category").value;
                var publisher = document.getElementById("publisher").value;
                var language = document.getElementById("language").value;
                var format = document.getElementById("format").value;
                $.ajax({
                    type: 'POST',
                    url: "search",
                    data: ({
                        title: title,
                        author: author,
                        category: category,
                        publisher: publisher,
                        language: language,
                        format: format
                    }),
                    success: function (result) {
                        $("#demo").html(result);
                    }
                });
            }

            function cart(isbn, title, amount) {
                if (amount > 0) {
                    $.ajax({
                        type: "GET",
                        url: "cart",
                        data: ({
                            isbn: isbn,
                            title: title
                        }),
                        success: function (result) {
                            alert(result);
                        }
                    });
                } else {
                    alert('out of stock to borrow');
                }
            }

            function info(isbn) {
                window.location = "bookinfo?isbn=" + isbn;
            }
        </script>

    </body>
</html>



