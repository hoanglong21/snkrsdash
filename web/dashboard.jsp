<%-- 
    Document   : dashboard
    Created on : Oct 9, 2021, 10:47:56 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://fonts.googleapis.con/css2?
              family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" 
              rel="stylesheet"/>
        <style>
            table td, table th {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="header" style="min-height: 100vh;">
            <div class="container" style="padding-bottom: 100px;">
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
                        <div style="position: fixed; right:0;right: 0; z-index: 10;">
                            <a href="statistics.jsp?op=Potential Shop" style="font-size: 0.8em;" class="btn">Statistics  &#8594;</a>
                        </div>
            
            <h2 class="title" style="${acc==null?"display: none":""}">Users</h2>

            <div class="container" style="padding-bottom: 5vh; ${acc==null?"display: none":""}">
                <table border="1px">
                    <thead>
                        <tr>
                            <th style="width: 10vh">ID</th>
                            <th style="width: 20vh">Username</th>
                            <th style="width: 20vh">Role</th>
                            <th style="width: 20vh">Email</th>
                            <th style="width: 20vh">Image</th>
                            <th style="width: 30vh; text-align: center;">Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${acc}" var="a">
                            <tr>
                                <td style="width: 10vh">${a.getID()}</td>
                                <td style="width: 20vh">${a.getUsername()}</td>
                                <td style="width: 20vh">${a.getRo().getName()}</td>
                                <td style="width: 20vh">${a.getEmail()}</td>
                                <td style="width: 20vh"><img src="${a.getImage()!=null?a.getImage():'images/2.png'}"</td>
                                <td style="width: 30vh; text-align: center;"><a class="btn" href="upacc?id=${a.getID()}">Update</a> 
                                    <a style="display: none;" class="btn"  href="delacc?id=${a.getID()}">Delete</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

            <h2 class="title" >Products</h2>
            <h4 style="text-align: center;"><a class="btn" href="addpro">Add product</a></h4>
            <div class="container" style="padding-bottom: 5vh;">
                <table border="1px">
                    <thead>
                        <tr>
                            <th style="width: 10vh">ID</th>
                            <th style="width: 20vh">Name</th>
                            <th style="width: 20vh">Price</th>
                            <th style="width: 20vh">Quantity</th>
                            <th style="width: 20vh">Category</th>
                            <th style="width: 20vh">Owner</th>
                            <th style="width: 20vh">Image</th>
                            <th style="width: 30vh; text-align: center;">Option</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pro}" var="p">
                            <tr>
                                <td style="width: 10vh">${p.getID()}</td>
                                <td style="width: 20vh">${p.getName()}</td>
                                <td style="width: 20vh">${p.getPrice()}</td>
                                <td style="width: 20vh">${p.getQuantity()}</td>
                                <td style="width: 20vh">${p.getCate().getName()}</td>
                                <td style="width: 20vh">${p.getAcc().getUsername()}</td>
                                <td style="width: 20vh"><img src="${p.getImgs().get(0).getAddress()}"</td>
                                <td style="width: 30vh; text-align: center;"><a class="btn" href="uppro?id=${p.getID()}">Update</a> &nbsp;&nbsp;&nbsp;<a class="btn"  href="delpro?id=${p.getID()}">Delete</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
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
