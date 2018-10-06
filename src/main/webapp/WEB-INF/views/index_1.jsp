<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dokomandu</title>

    <!-- Scripts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <script src="js/app.js" defer></script>

    <!-- Fonts -->
    <link rel="dns-prefetch" href="https://fonts.gstatic.com">

    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600" rel="stylesheet" type="text/css">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">

    <!-- Styles -->
    <link href="css/app.css" rel="stylesheet">
    <link href="css/jquery-ui.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
</head>
<body>
    <div id="app">
        <!--  side nav  -->
        <div class="side-navigation fixed">
            <div class="nav-header">
                <a href="">
                    <img src="img/cart.jpg" alt="">
                    <span class="title">DokuMandu</span>
                </a>
            </div>
            <ul class="side-nav-list">
                <li>
                    <a href="/">
                        <span> <i class="fas fa-home text-secondary"></i> </span>
                        <strong>Home</strong>
                    </a>
                </li>
            </ul>
        </div>
        <!--  Top nav  -->
        <div class="top-navigation">
            <div class="container d-flex m-0 p-0">
                <div class="nav-left d-flex">
                    <div class="hamburger-menu">
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
                </div>
                <div class="nav-right">
                    <!-- Right Side Of Navbar -->
                    <ul class="navbar-nav d-flex flex-row justify-content-around navbar-nav">
                        <li><a class="nav-link" href="#">Login</a></li>
                        <li><a class="nav-link" href="#">Register</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!--  content section  -->
        <div class="main-content">
            <div class="container">
                content goes here
            </div>
        </div>
    </div>
    <script src="js/jquery-ui.min.js" defer></script>
    <script src="js/custom.js" defer></script>
</body>
</html>