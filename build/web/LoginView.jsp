<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Management</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>    <style>
        div.a {
            text-align: center;
            font-size: 10px;
        }

    </style>
    <style>
        body{
            color:darkslategray;
            background-color: seashell;
        }
        img {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        #img1 {
            border: 10px solid transparent;
            padding: 15px;            background-color: wheat;


        }
    </style>
    <style type="text/css">


        .ghost
        {
            /* position centered */
            display:inline-block;
            position: relative;
            top: 50%;
            left:50%;
            -webkit-transform: translateX(-50%) translateY(-50%);
            -ms-transform: translateX(-50%) translateY(-50%);
            transform: translateX(-50%) translateY(-50%);
            /* text styles */
            font-family: Tahoma, Verdana, Segoe, sans-serif;
            font-size: 3em;
            letter-spacing: 0.1em;
            color:darkslategray;
            /* modify text */
            text-decoration:none;
            text-transform:uppercase;
            text-rendering:optimizeLegibility;
            /* add a border */
            border:0.15em solid #fff;
            padding:0.2em 0.4em;
            /* animate the change */
            -webkit-transition: color 400ms, background 600ms, border-color 700ms;
            transition: color 300ms, background 600ms, border-color 700ms;
        }
        .ghost:hover
        {
            background:wheat;
            border-color:#91f21b;
            color:#545e7a;
        }
    </style>
    <body>
        <!--Navbar (sit on top)--> 
        <div class="w3-top">

            <div class="w3-bar w3-white w3-wide w3-padding w3-card-2">
                <div class="w3-left w3-hide-small">
                    <img class="w3-image" src="/BookManagement/images/iconfinder_book_285636.png" alt="Việt Tùng" style="width:100%;">
                </div>
                <a href="LoginView.jsp" class="w3-bar-item w3-button"><b>TM Libary</b></a>
                <!--Float links to the right. Hide them on small screens--> 
                <div class="w3-right w3-hide-small">
                    <!--Login form-->
                    <form action="login" method="POST">
                        <input type="text" id="username" placeholder="username" required name="username">
                        <input type="password" placeholder="password" required name="password">
                        <input type="submit" value="Login" class="btn btn-danger"/>

                    </form>
                    <div class="a"><a href="Reg.jsp">Sign up</a> </div>


                </div>
            </div>
        </div>
        <!--Header--> 
        <header class="w3-display-container w3-content w3-wide" style="max-width:1500px;">
            <div class="container">

                <div id="myCarousel" class="carousel slide" data-ride="carousel">

                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                        <li data-target="#myCarousel" data-slide-to="3"></li>
                    </ol>

                    <!--  Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img class="w3-image" src="/BookManagement/images/Homepage_Billboard_HeroA_10-15.jpg" alt="page image" style="width:100%;">
                            <div class="w3-display-middle w3-margin-top w3-center">
                                <h1 class="w3-xxlarge w3-text-white">
                                    <span class="w3-padding w3-black w3-opacity-min">
                                        <b>TM Libary</b>
                                    </span></h1>
                            </div>
                        </div>

                        <div class="item">
                            <img class="w3-image" src="/BookManagement/images/tung3.JPG" alt="Việt Tùng" style="width:100%;">
                            <div class="w3-display-middle w3-margin-top w3-center">
                                <h1 class="w3-xxlarge w3-text-white">
                                    <span class="w3-padding w3-black w3-opacity-min">
                                        <b>TM Libary</b>

                                    </span></h1>
                            </div>
                        </div>

                        <div class="item">
                            <img class="w3-image" src="/BookManagement/images/tung2.JPG" alt="Việt Tùng" style="width:100%">
                            <div class="w3-display-middle w3-margin-top w3-center">
                                <h1 class="w3-xxlarge w3-text-white">
                                    <span class="w3-padding w3-black w3-opacity-min">
                                        <b>Librarian</b>

                                    </span></h1>
                            </div>
                        </div>

                        <div class="item">
                            <img class="w3-image" src="/BookManagement/images/manh1.jpg" alt="Hoàng Mạnh" style=" width:100%;">
                            <div class="w3-display-middle w3-margin-top w3-center">
                                <h1 class="w3-xxlarge w3-text-white">
                                    <span class="w3-padding w3-black w3-opacity-min">
                                        <b>Librarian</b>

                                    </span></h1>
                            </div>
                        </div>
                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </header>

        <div class="w3-content w3-padding" style="max-width:1564px">

            <!--About Section--> 
            <div class="w3-container">
                <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">About</h3>
                <img class="c" src="/BookManagement/images/Quote-Book-is-a-gift.png" > 
            </div>

            <!--Function Session--> 
            <div class="w3-container">
                <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Best book borrow in this week</h3>
            </div>

            <div class="w3-row-padding a" >
                <div class="w3-col l3 m6 w3-margin-bottom">
                    <img id="img1" src="/BookManagement/images/book1.jpg" alt="Search" style="width:70%">
                    <h5 >Serpent & Dove</h5>
                </div>
                <div class="w3-col l3 m6 w3-margin-bottom">
                    <img id="img1" src="/BookManagement/images/book2.jpg" alt="Search" style="width:70%">
                    <h5>The Crue Prince</h5>
                </div>
                <div class="w3-col l3 m6 w3-margin-bottom">
                    <img id="img1" src="/BookManagement/images/book3.jpg" alt="Search" style="width:68%">
                    <h5>Catch and Kill</h5>
                </div>
                <div class="w3-col l3 m6 w3-margin-bottom">
                    <img id="img1" src="/BookManagement/images/book4.jpg" alt="Search" style="width:70%">
                    <h5>The Queen of Nothing</h5>
                </div>


            </div>


            <div>
                <br>
                <a class="ghost" href="" onclick="Myfunction()">SEE MORE</a>
            </div>



            <!--Contact Section--> 
            <div class="w3-container w3-padding-32">
                <h3 class="w3-border-bottom w3-border-light-grey">Contact</h3>
                <p>You can contact us in some way below.</p>
                <div class="w3-col s4 w3-justify">
                    <p><i class="fa fa-fw fa-map-marker"></i>FPT Hòa Lạc</p>
                    <p><i class="fa fa-fw fa-phone"></i>037 554 1892 or 098 451 6125</p> 
                    <p><i class="fa fa-fw fa-envelope"></i>tungnvhe130151@fpt.edu.vn</p>
                    <br>
                    <a href="https://www.instagram.com/____tug__/" target="_blank"><i class="fa fa-instagram w3-hover-opacity w3-large"></i></a>
                    <a href="https://www.facebook.com/iam.tunq" target="_blank"><i class="fa fa-facebook-official w3-hover-opacity w3-large" ></i></a>
                    <a href="https://www.pinterest.com/pin/693695148838088758/" target="_blank"><i class="fa fa-pinterest-p w3-hover-opacity w3-large"></i></a>
                    <a href="https://www.linkedin.com/in/t%C3%B9ng-nguy%E1%BB%85n-5a0469153/" target="_blank"><i class="fa fa-linkedin w3-hover-opacity w3-large"></i></a>
                </div>
            </div>

        </div>
        <jsp:include page="/Footer.jsp"/>
    </body>
    
    <script>
        function Myfunction(){
            alert("Please login to borrow books");
            document.getElementById("username").focus();
    }
    </script>

</html>
