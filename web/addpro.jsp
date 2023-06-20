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
            input.not::-webkit-outer-spin-button,
            input.not::-webkit-inner-spin-button {
                /* display: none; <- Crashes Chrome on hover */
                -webkit-appearance: none;
                margin: 0; /* <-- Apparently some margin are still there even though it's hidden */
            }

            input.not[type=number] {
                -moz-appearance:textfield; /* Firefox */
            }
        </style>
    </head>
    <body>
        <div class="header" style="min-height: 100vh;">
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
                <h2 class="title" >ADD</h2>
            </div>

            <form action="addpro" method="post" enctype="multipart/form-data">
                <div style="display: flex">
                    <!--begin of add-->
                    <div  style="width: 40%;margin-left: 10%;">
                        <table>
                            <tr><td>Name</td><td><input type="text" name="name" required=""/></td></tr>
                            <tr><td>Category</td><td>
                                    <select name="category" required="" style="width: 100%;">
                                        <option disabled="">Category</option>
                                        <c:forEach items="${category}" var="i">
                                            <option value="${i.getID()}">${i.getName()}</option>
                                        </c:forEach>
                                    </select> 
                                </td></tr>
                            <tr><td>Quantity</td><td><input required="" type="number" min="1" name="quantity"/></td></tr>
                            <tr><td>Price</td><td><input required="" type="number" min='0.01' step="0.01" name="price"/></td></tr>
                            <tr><td>Description</td><td><textarea required="" name="description" style="width: 100%; height: 50vh; resize: none;"></textarea></td></tr>
                        </table>
                    </div>
                    <!--end of add-->
                    <div style="width: 40%;">
                        <h3 style="text-align: center">Add your images here</h3>
                        <table>
                            <tr>
                                <td style="text-align: right;transform: translateX(25%);">How many pictures?</td><td style="text-align: center;"><a style="width: 10%;" class="btn" href="addpro?count=${count==1?1:count-1}">-</a>
                                    <input class="not" style="width: 30%; text-align: center" type="number" readonly value="${count>0 && count <10?count:1}" name="count"/>
                                    <a style="width: 10%;" class="btn" href="addpro?count=${count==9?9:count+1}">+</a></td>
                            </tr>
                            <c:forEach begin="1" end="${count>0 && count <10?count:1}" var="i">
                                <c:set value="a${i}" var="x"/>
                                <tr>
                                    <td><img style="margin-left: 85%;" name="picture${i}" id="${x}" src="images/1f.png"></td>
                                    <td ><input style="width: 70%" required type="file"  accept="image/*" name="image${i}" id="file" onchange="loadFile(event, ${x}, this)" ></td>

                                </tr><input style="display: none" name="getPic${i}" id="data${i}"/>
                            </c:forEach>

                        </table>
                    </div>
                </div>
                <h5 style="text-align: center;"><input type='submit' style="width: 20%; cursor: pointer;" class="btn" value='ADD'/></h5>
            </form> 

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

            var loadFile = function (event, str, that) {
                var image = str;
//                str.value = that.value;
//               console.log(that.name.substring(5));
                var b = 'data' + that.name.substring(5);
//                var a = document.getElementById(b);
                document.getElementById(b).setAttribute('value', event.target.value.substring(12));


                console.log(document.getElementById(b).getAttribute('value'));
                image.src = URL.createObjectURL(event.target.files[0]);

            };


//            value="${sessionScope.account.getImage()==null?"images/1f.png":sessionScope.account.getImage()}"
        </script>


    </body>
</html>
