<%-- 
    Document   : index
    Created on : Sep 28, 2021, 4:54:33 PM
    Author     : HoangLong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>Detail Page</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/style4.css"/>
        <link href="https://fonts.googleapis.con/css2?
              family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" 
              rel="stylesheet"/>
    </head>
    <body>


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
                        <li><a href="${sessionScope.account==null?"account.jsp":"account-detail.jsp"}">Account</a></li>
                        <li><a class="active" href="${sessionScope.account==null?"account.jsp":"carts"}"><i style="font-size: 1.5em" class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i></a></li>
                    </ul>
                </nav>

                <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>

        </div>

        <!--cart items details-->
        <div class="small-container cart-page">
            <form action="change">
                <table>
                    <tr>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Size</th>
                        <th>Subtotal</th>
                    </tr>

                    <c:set var="sub" value="0"/>
                    <c:forEach items="${list}" var="list">
                        <input style="display: none" name="id" value="${list.getID()}"/>
                        <tr>
                            <td>
                                <div class="cart-info">
                                    <img src="${list.getPro().getImgs().get(0).getAddress()}">
                                    <div>
                                        <p><a style="font-size: 1em;" href="details?id=${list.getID()}">${list.getPro().getName()}</a></p>  
                                        <small>Price: $${list.getPro().getPrice()}</small><br/>
                                        <a href="removecart?id=${list.getID()}">Remove</a>
                                    </div>
                                </div>
                            </td>
                            <td>$${list.getPro().getPrice()}</td>

<!--<td><input style="width: 30%;" onchange="this.form.submit()"  name="quan" min="1" max="9" type="number" value="${list.getQuantity()}"></td>-->
                            <td>                                
                                <input style = "width: 40%" onKeyDown="return false" onchange="this.form.submit()" name="quan" type="number" min="1" max="${list.getPro().getQuantity()}" value="${list.getQuantity()}">

                            </td>

                            <td>
                                <select onchange="this.form.submit()" name="size">
                                    <c:forEach begin="35" end="45" var="i">
                                        <option ${i==list.getSize()?"selected":""}>${i}</option>
                                    </c:forEach>
                                </select>

                            </td>
                            <td>$<fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${list.getQuantity()*list.getPro().getPrice()}" /></td>  
                            <c:set var="sub" value="${sub+list.getQuantity()*list.getPro().getPrice()}"/>
                        </tr>
                    </c:forEach>
                </table> 
            </form>


            <div class="row cart_apply_coupon_box">
                <form action="coupon" method="post">
                    <div class="col-xl-6">
                        <div class="apply_coupon">
                            <div class="apply_coupon_input_box">
                                <input type="text" name="cou" value="" placeholder="Enter Coupon Code"
                                       style="height: 70px;">
                            </div>
                            <div class="apply-coupon-button">
                                <button height="70px" class="thm-btn" style="cursor: pointer;" type="submit">Apply Coupon</button>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="col-xl-6">
                    <ul class="total_box list-unstyled" style="transform: translateX(15vw);position: relative;">
                        <li style="display: flex; justify-content: space-between;"><span>Subtotal</span>
                            <p style="color: inherit;">$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${sub}"/> USD</p></li>
                        <li style="display: flex; justify-content: space-between;"><span>Discount</span>
                            <p style="color: inherit;">$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${mess.length()==5?sub*0.05:0}"/> USD</p></li>
                        <li style="display: flex; justify-content: space-between;"><span>Total</span>
                            <p style="color: inherit;">$<fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${mess.length()==5?sub - sub*5/100:sub}"/> USD</p></li>
                    </ul>
                </div>
            </div> 
            <form action="buy" style="border-bottom: 1px solid #f5f0e9;padding-bottom: 70px;">
                <input style="display: none;" type="text" name="id" value="${sessionScope.account.getID()}"/>
                <input style="display: none;" type="text" name="sale" value="${mess.length()==5?1:0}"/>
                <div class="row">
                    <div class="col-xl-12">
                        <div class="button_box">
                            <input type="submit" style="position: relative;transform: translateX(55vw); cursor: pointer; height: 100%;"
                                   class="thm-btn checkout_btn" onclick="thanks()" value="Checkout">
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <!--       already        -->
        <h2 class="title">&#8610; ALREADY PURCHASED &#8611;</h2>
        <div class="small-container cart-page">
            <table style="border-bottom: 1px solid #f5f0e9;padding-bottom: 70px;">
                <tr>
                    <th>Product</th>
                    <th>Size</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th style="padding-right: 3%;">Date</th>
                </tr>

                <jsp:useBean id="HisDAO" class="dal.CartDAO"/>
                <c:forEach items="${HisDAO.getAllHistory(sessionScope.account.getID())}" var="i">

                    <tr>
                        <td>
                            <div class="cart-info">
                                <img src="${i.getImgs().get(0).getAddress()}">
                                <div>
                                    <p style="margin-top: 20%;"><a style="font-size: 1em;" href="details?id=${i.getID()}">${i.getName()}</a></p>  
                                </div>
                            </div>
                        </td>
                        <td>${i.getSize()}</td>
                        <td>${i.getQuantity()}</td>
                        <td>${i.getPrice()}</td>
                        <td>${i.getDate()}</td>
                    </tr>

                </c:forEach>
            </table>
        </div>



        <!--        </div>-->
        <c:if test="${sub>0}">
            <img src="images/thanks.png" id="thanks" style="width: 0vw; margin-left: 20%;">
        </c:if>

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
            ////
            function thanks() {
                document.getElementById("thanks").style.width = "60vw";
            }

        </script>
    </body>
</html>
