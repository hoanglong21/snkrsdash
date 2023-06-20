<%-- 
    Document   : index
    Created on : Sep 28, 2021, 4:54:33 PM
    Author     : HoangLong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>Account Seller</title>
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
                            <img id="only" src="${acc.getImage()==null?"images/2.png":acc.getImage()}" width="100%">
                            <form action="fileUpload" method="post" enctype="multipart/form-data" method="post" style="transform: translate(30px,-30px);">
                                <input type="file" required="" accept="image/*" name="image" id="file" onchange="loadFile(event)" > 
                                <input type="submit" value="Change"/>
                                <input style="display: none;" type="text" value="${acc.getID()}" name="accID">
                            </form>

                        </div>

                        <div class="col-2">
                            <div class="form-container" style=" ${acc.getRoleID()==2?"height: 470px":""}">
                                <div class="form-btn">
                                    <span>Account</span>
                                    <hr id="Indicator" style='transform: translateX(0);'>
                                </div>
                                <form id="LoginForm" style='left: 0; transform: translateY(-50px);' action="upacc" method="post">
                                    <p style="text-align: left; margin-left: 5px;">Role:</p>
                                    <input style="padding-left: 5px;" type="text" readonly="true" value="${acc.getRo().getName()}">
                                    <p style="text-align: left; margin-left: 5px;">Username:</p>         
                                    <input style="padding-left: 5px;" type ="text" readonly="true" value="${acc.getUsername()}">
                                    <p style="text-align: left; margin-left: 5px;">Password:</p>
                                    <input style="padding-left: 5px;" type="password" placeholder="Password" value="${acc.getPassword()}" name="pass">
                                    <p style="text-align: left; margin-left: 5px; ${sessionScope.account.getRoleID()!=2?"display: none;":""}">Address:</p>
                                    <textarea name="address" placeholder="Address"
                                              style="width: 100%; ${acc.getRoleID()!=2?"display: none;":""}">${acc.getAddress()}</textarea>
                                    <button type="submit" class="btn">Change</button>
                                    <a href="logout" class="btn" style="transform: translateY(-50px)">Logout</a>
                                    <input style="display: none;" type="text" value="${acc.getID()}" name="id"/>
                                </form>

                            </div>

                        </div>
                    </div>

                </div>
            </div>

            <!--dashboard-->
            <c:set value="${sessionScope.account}" var="a"/>
            <form style="text-align: center;" action="${a.getRoleID()==2?"carts":"dashboard"}">
                <input type="submit" style="width: 60%; height: 50px;font-size: 1.5em;" class="btn" value="See Dashboard"/>
            </form>

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

            var loadFile = function (event) {
                var image = document.getElementById('only');
                image.src = URL.createObjectURL(event.target.files[0]);
            };
        </script>



    </body>
</html>
