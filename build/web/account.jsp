<%-- 
    Document   : index
    Created on : Sep 28, 2021, 4:54:33 PM
    Author     : HoangLong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>Account Page</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://fonts.googleapis.con/css2?
              family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" 
              rel="stylesheet"/>
    </head>
    <body>
        <div class="all">
            <div class="container">
                <div class="navbar">
                    <a href="home"><img class="logo" src="images2/Logo.png" style="height: 100px; padding-top: 50px;"/></a>
                    <nav>
                        <ul id = "MenuItems" style="max-height: 200px;margin-top: 25px;">
                            <jsp:useBean id="DAO" class="dal.AccountDAO"/>
                            <li><i class="fa fa-credit-card" aria-hidden="true"></i> <i class="fa fa-usd" aria-hidden="true"></i> ${DAO.getMoney(sessionScope.account.getID())}</li>
                            <li><a href="index.html">Welcome</a></li>
                            <li><a href="home">Home</a></li>
                            <li><a href="products">Products</a></li>
                            <li><a href="discount.jsp">Discount</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a class="active" href="${sessionScope.account==null?"account.jsp":"account-detail.jsp"}">Account</a></li>
                            <li><a href="${sessionScope.account==null?"account.jsp":"carts"}"><i style="font-size: 1.5em" class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i></a></li>
                        </ul>
                    </nav>

                    <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
                </div>

            </div>
            <!--account page-->
            <div class="account-page">
                <div class="container">
                    <div class="row">
                        <div class="col-2">
                            <img id="only" src="images/jordan-1-unc.png" width="100%">
                        </div>

                        <div class="col-2">
                            <div class="form-container">
                                <div class="form-btn">
                                    <span onclick="login()">Login</span>
                                    <span onclick="register()">Register</span>
                                    <hr id="Indicator">
                                </div>
                                <p style="transform: translateY(10px);">${error==null?"":error}</p>
                                <form id="LoginForm" action="login">
                                    <input type ="text" placeholder="Username" name="Username">
                                    <input type="password" placeholder="Password" name="Password">
                                    <input type="submit" class="btn" value="Login"/>
                                    <a href="contact.jsp">Forgot password</a>
                                </form>

                                <form id="RegForm" action="register">
                                    <input type="text" placeholder="Username" name="Username">
                                    <input type="email" placeholder="Email" name="Email">
                                    <input type="password" placeholder="Password" name="Password">
                                    <select style="margin-top: 10px; width: 100%" name="RoleID">
                                        <option value="2">Customer</option>
                                        <option value="3">Seller</option>
                                    </select>
                                    <button type="submit" class="btn">Register</button>
                                </form>
                            </div>

                        </div>
                    </div>

                </div>
            </div>


            <!--        footer       -->
            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class="footer-col-1">
                            <h3>Download Our App</h3>
                            <p>Download App for Android and ios mobile phone.</p>
                            <div class="app-logo">
                                <img src="images/play-store.png">
                                <img src="images/app-store.png">
                            </div>
                        </div>
                        <div class="footer-col-2">
                            <img src="images/lol.png" style="filter: invert(0.8);">
                            <p>Our Purpose Is To Sustainably Make the Pleasure and
                                Benefits of Sports Accessible to the Many.</p>
                        </div>
                        <div class="footer-col-3">
                            <h3>Useful Links</h3>
                            <ul>
                                <li>Coupons</li>
                                <li>Blog Post</li>
                                <li>Return Policy</li>
                                <li>Join Affiliate</li>
                            </ul>
                        </div>
                        <div class="footer-col-4">
                            <h3>Follow us</h3>
                            <ul>
                                <li>Facebook</li>
                                <li>Twitter</li>
                                <li>Instagram</li>
                                <li>Youtube</li>
                            </ul>
                        </div>
                    </div>
                    <hr>
                    <p class="copyright">Copyright 2021 - HoangLong21</p>
                </div>
            </div>
        </div>

        <!--js for toggle menu-->
        <script>
            var MenuItems = document.getElementById("MenuItems");

            MenuItems.style.maxHeight = "0px";

            function menutoggle() {
                if (MenuItems.style.maxHeight === "0px") {
                    MenuItems.style.maxHeight = "200px";
                } else {
                    MenuItems.style.maxHeight = "0px";
                }
            }
        </script>


        <!--js for toggle form-->
        <script>
            var LoginForm = document.getElementById("LoginForm");
            var RegForm = document.getElementById("RegForm");
            var Indicator = document.getElementById("Indicator");

            function register() {
                RegForm.style.transform = "translateX(0px)";
                LoginForm.style.transform = "translateX(0px)";
                Indicator.style.transform = "translateX(100px)";
            }

            function login() {
                RegForm.style.transform = "translateX(300px)";
                LoginForm.style.transform = "translateX(300px)";
                Indicator.style.transform = "translateX(0px)";
            }
        </script>
    </body>
</html>
