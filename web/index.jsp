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
        <title>Home Page</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://fonts.googleapis.con/css2?
              family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" 
              rel="stylesheet"/>
        <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
        <script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
    </head>
    <body>
        <div class="header">
            <div class="container" style="padding-bottom: 100px;">
                <div class="navbar">
                    <a href="home"><img class="logo" src="images2/Logo.png" style="height: 100px; padding-top: 50px;"/></a>
                    <nav>
                        <ul id = "MenuItems" style="max-height: 200px;margin-top: 25px;">
                            <jsp:useBean id="DAO" class="dal.AccountDAO"/>
                            <li><i class="fa fa-credit-card" aria-hidden="true"></i> <i class="fa fa-usd" aria-hidden="true"></i> ${DAO.getMoney(sessionScope.account.getID())}</li>
                            <li><a href="index.html">Welcome</a></li>
                            <li><a class="active" href="home">Home</a></li>
                            <li><a href="products">Products</a></li>
                            <li><a href="discount.jsp">Discount</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="${sessionScope.account==null?"account.jsp":"account-detail.jsp"}">Account</a></li>
                            <li><a href="${sessionScope.account==null?"account.jsp":"carts"}"><i style="font-size: 1.5em" class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i></a></li>
                        </ul>
                    </nav>

                    <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
                </div>
                <div class="row">
                    <div class="col-2">
                        <h1>HYPEBEAST<br>Sneaker Store</h1>
                        <p>Life ins't perfect but your SNEAKER can be.</p>
                        <a href="products" class="btn">Explore Now  &#8594;</a>
                    </div>
                    <div class='col-2'>
                        <img id="only" src="images/jordan-1-unc.png"/>
                    </div>
                </div>  
            </div>
        </div>

        <!--slide-->
        <div class="categories">
            <h2 class="title">&#8610; CATEGORIES &#8611;</h2>
            <!-- Flickity HTML init -->
            <div class="gallery js-flickity"
                 data-flickity-options='{ "wrapAround": true }'>
                <div onclick="location.href = 'filter?cat=1&condition=1'" 
                     class="gallery-cell" style="background-image: url('images/pic1.png'); width: 80%; height: 80vh" ></div>
                <div onclick="location.href = 'filter?cat=2&condition=1'"  
                     class="gallery-cell" style="background-image: url('images/pic2.png'); width: 80%; height: 80vh" ></div>
                <div onclick="location.href = 'filter?cat=3&condition=1'" 
                     class="gallery-cell" style="background-image: url('images/pic3.png'); width: 80%; height: 80vh" ></div>
                <div onclick="location.href = 'filter?cat=4&condition=1'" 
                     class="gallery-cell" style="background-image: url('images/pic4.png'); width: 80%; height: 80vh" ></div>
                <div onclick="location.href = 'filter?cat=5&condition=1'" 
                     class="gallery-cell" style="background-image: url('images/pic5.png'); width: 80%; height: 80vh" ></div>
            </div>  
        </div>


        <!--lates products-->
        <div class="small-container">
            <h2 class="title">Newest Products</h2>
            <div class="row">
                <c:forEach items="${new}" var="p">
                    <div class="col-4 up">
                        <div onclick="location.href = 'details?id=${p.getID()}';" class="onePic" style="background-image: url('${p.getImgs().get(0).getAddress()}'); cursor:pointer;">

                        </div>
                        <div>
                            <h4>${p.getName()}</h4>
                            <jsp:useBean id="daoStars" class="dal.FeedbackDAO"/>
                            <div class="rating">
                                <i class="fa ${daoStars.getStarsByID(p.getID())<0.25?'fa-star-o':
                                               daoStars.getStarsByID(p.getID())>=0.25 && daoStars.getStarsByID(p.getID())<0.75?'fa-star-half-o':
                                               daoStars.getStarsByID(p.getID())>=0.75?'fa-star':''}"></i>
                                <i class="fa ${daoStars.getStarsByID(p.getID())<1.25?'fa-star-o':
                                               daoStars.getStarsByID(p.getID())>=1.25 && daoStars.getStarsByID(p.getID())<1.75?'fa-star-half-o':
                                               daoStars.getStarsByID(p.getID())>=1.75?'fa-star':''}"></i>
                                <i class="fa ${daoStars.getStarsByID(p.getID())<2.25?'fa-star-o':
                                               daoStars.getStarsByID(p.getID())>=2.25 && daoStars.getStarsByID(p.getID())<2.75?'fa-star-half-o':
                                               daoStars.getStarsByID(p.getID())>=2.75?'fa-star':''}"></i>
                                <i class="fa ${daoStars.getStarsByID(p.getID())<3.25?'fa-star-o':
                                               daoStars.getStarsByID(p.getID())>=3.25 && daoStars.getStarsByID(p.getID())<3.75?'fa-star-half-o':
                                               daoStars.getStarsByID(p.getID())>=3.75?'fa-star':''}"></i>
                                <i class="fa ${daoStars.getStarsByID(p.getID())<4.25?'fa-star-o':
                                               daoStars.getStarsByID(p.getID())>=4.25 && daoStars.getStarsByID(p.getID())<4.75?'fa-star-half-o':
                                               daoStars.getStarsByID(p.getID())>=4.75?'fa-star':''}"></i>
                            </div>
                            <div style="display: flex;justify-content: space-between; ">
                                <p>$${p.getPrice()}</p>
                                <p><a href="shop?id=${p.getAcc().getID()}"> ${p.getAcc().getUsername()}</a></p>
                            </div>
                        </div>

                    </div>    
                </c:forEach>
            </div>

        </div>

        <!--        Offer       -->
        <div class="offer">
            <div class="small-container">
                <div class="row">
                    <div class="col-2">
                        <img src="images/ex.png" class="offer-img">
                    </div>
                    <div class="col-2">
                        <p>Exclusive available on SNKRSDASH</p>
                        <h1>Jesus Shoes</h1>
                        <small>In reference to religious symbolism and the cult appeal of 
                            streetwear, digital culture studio MSCHF has created ‘jesus shoes‘. 
                            the design injects 60cc of holy water into the bubble of a air max sole 
                            to allow wearers to literally ‘walk on water’ with every step. realized
                            with a somewhat tongue-in-cheek attitude, the shoes utilize the classic 
                            NIKE silhouette to investigate ideas of devotion in both religion and 
                            commercial products.</small><br/>
                        <a href="details?id=17" class="btn">Buy Now &#8594;</a>
                    </div>
                </div>
            </div>
        </div>

        <!--        testimonial       -->
        <div class="testimonial">
            <div class="small-container">
                <div class="row onlyYou">
                    <div class="col-3">
                        <i class="fa fa-quote-left"></i>
                        <p>Love this store</p>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <img src="images/user-1.png">
                        <h3>Emma</h3>
                    </div>
                    <div class="col-3">
                        <i class="fa fa-quote-left"></i>
                        <p>Best store ever</p>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <img src="images/user-2.png">
                        <h3>Kevin</h3>
                    </div>
                    <div class="col-3">
                        <i class="fa fa-quote-left"></i>
                        <p>100% legit!</p>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                        </div>
                        <img src="images/user-3.png">
                        <h3>Lucy</h3>
                    </div>
                </div>
            </div>
        </div>
        <!--        brands       -->
        <div class="brands">
            <div class="small-container">
                <div class="row onlyYou">
                    <div class="col-5">
                        <img src="images/adidas-logo.png">
                    </div>
                    <div class="col-5">
                        <img src="images/nike-logo.jpg">
                    </div>
                    <div class="col-5">
                        <img src="images/off-white-logo.png">
                    </div>
                    <div class="col-5">
                        <img src="images/vans-logo.png">
                    </div>
                    <div class="col-5">
                        <img src="images/converse-logo.png">
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
    </body>
</html>
