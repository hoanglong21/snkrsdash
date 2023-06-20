<%-- 
    Document   : index
    Created on : Sep 28, 2021, 4:54:33 PM
    Author     : HoangLong
--%>

<%@page import="model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>Detail Page</title>
        <link rel="stylesheet" href="css/cmtstyle.css"/>
        <link rel="stylesheet" href="css/backstyle.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://fonts.googleapis.con/css2?
              family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" 
              rel="stylesheet"/>


    </head>
    <body>
        <c:set var="relates" value="${relates}"/>
        <c:set var="p" value="${p}"/>

        <div class="container">
            <div class="navbar">
                <a href="home"><img class="logo" src="images2/Logo.png" style="height: 100px; padding-top: 50px;"/></a>
                <nav>
                    <ul id = "MenuItems" style="max-height: 200px;margin-top: 25px;">
                        <jsp:useBean id="DAO" class="dal.AccountDAO"/>
                        <li><i class="fa fa-credit-card" aria-hidden="true"></i> <i class="fa fa-usd" aria-hidden="true"></i> ${DAO.getMoney(sessionScope.account.getID())}</li>
                        <li><a href="index.html">Welcome</a></li>
                        <li><a href="home">Home</a></li>
                        <li><a class="active" href="products">Products</a></li>
                        <li><a href="discount.jsp">Discount</a></li>
                        <li><a href="contact.jsp">Contact</a></li>
                        <li><a href="${sessionScope.account==null?"account.jsp":"account-detail.jsp"}">Account</a></li>
                        <li><a href="${sessionScope.account==null?"account.jsp":"carts"}"><i style="font-size: 1.5em" class="fa fa-shopping-cart fa-2x" aria-hidden="true"></i></a></li>
                    </ul>
                </nav>

                <img src="images/menu.png" class="menu-icon" onclick="menutoggle()">
            </div>
        </div>

        <!--single product details-->
        <div class="small-container single-product">
            <div class="row">
                <div class="col-2">
                    <img src="${p.getImgs().get(0).getAddress()}" width="100%"id="productImg">
                    <div class="small-img-row">
                        <c:forEach items="${p.getImgs()}" var="imgs">
                            <div class="small-img-col">
                                <img onclick="change(this)" src="${imgs.getAddress()}" width="100%" height = "80%"class="small-img"> 
                            </div>
                        </c:forEach>
                    </div>


                </div>
                <div class="col-2">
                    <p><a href="home">Home</a> / <a href="tab?catid=${p.getCatID()}">${p.getCate().getName()}</a> / ${p.getName()}</p>
                    <h1>${p.getName()}</h1>
                    <h4>$${p.getPrice()}</h4>
                    <form action="${sessionScope.account==null?"account.jsp":"addcarts"}">
                        <input style="display: none" value="${p.getID()}" name="id">
                        <select name="Size">
                            <option disabled>Select Size</option>
                            <option value="35">35</option>
                            <option value="36">36</option>
                            <option value="37">37</option>
                            <option value="38">38</option>
                            <option value="39">39</option>
                            <option value="40" selected="">40</option>
                            <option value="41">41</option>
                            <option value="42">42</option>
                            <option value="43">43</option>
                            <option value="44">44</option>
                            <option value="45">45</option>
                        </select>
                        <input style="width: 100px;" type="number" onKeyDown="return false" min="1" max="${p.getQuantity()}" value="1" name="Quantity">
                        <input class="btn" type="submit" value="Add to cart" style="width: 25%;">
                    </form>

                    <h3>Product Details <i class='fa fa-indent'></i></h3>
                    <br>
                    <p>${p.getDescription()}</p>
                </div>
            </div>
        </div>

        <!--home-->
        <div style="border: 1px solid white;width: 65%;margin: auto;height: 8vh; background-color: #f9c3c9;">
            <h2 style="text-align: center;height: 5vh;margin-top: 2vh;">
                <a style="color: aliceblue; font-weight: bold;" href="shop?id=${p.getAcc().getID()}"> ${p.getAcc().getUsername()}</a> 
                <i style="color: aliceblue; font-weight: bold;" class="fa fa-home" aria-hidden="true"></i></h2>  
        </div>


        <!--title of comment-->
        <div class="small-container">
            <div class="row row-2">
                <h2>Feedback</h2>
            </div>
        </div>
        <!--        comment      -->
        <div class="container" style="width: 70%;">
            <div class="be-comment-block" style="border: 10px solid #feb0b0;">
                <!--maybe add cmt here-->
                <h1 class="comments-title">Add your feedback</h1>                
                <form id="form" action="feedback">
                    <input style="display: none;" type="text" value="${p.getID()}" name="proid"/>
                    <fieldset class="stars" style="border: none;">
                        <input type="radio" name="stars" id="star1" required="" value="5"/>
                        <label class="fa fa-star" for="star1"></label>
                        <input type="radio" name="stars" id="star2" value="4"/>
                        <label class="fa fa-star" for="star2"></label>
                        <input type="radio" name="stars" id="star3" value="3"/>
                        <label class="fa fa-star" for="star3"></label>
                        <input type="radio" name="stars" id="star4" value="2"/>
                        <label class="fa fa-star" for="star4"></label>
                        <input type="radio" name="stars" id="star5" value="1"/>
                        <label class="fa fa-star" for="star5"></label>
                        <input type="radio" name="stars" id="star-reset"/>
                        <label style="transform: translate(100%,-100%);" class="reset" for="star-reset">reset</label>
                    </fieldset>
                    <textarea style="width: 85%; height: 30vh; margin-top: 3%;"
                              name="feedback" type="text" required="" placeholder="Add your feedback here"></textarea>
                    <input style="width: 20%;font-weight: bold;height: 100%;" type="submit" class="btn" value="Feedback"/>
                </form>
                <jsp:useBean id="fbDAO" class="dal.FeedbackDAO"/>
                <h1 class="comments-title">Feedback (${fbDAO.getFeedbackByProID(p.getID()).size()})</h1>
                <c:forEach items="${fbDAO.getFeedbackByProID(p.getID())}" var="i">
                    <div class="be-comment">
                        <div class="be-img-comment">	
                            <a href="#">
                                <img src="${i.getAcc().getImage()!=null?i.getAcc().getImage():'images/2.png'}" alt="" class="be-ava-comment">
                            </a>
                        </div>
                        <div class="be-comment-content">

                            <span class="be-comment-name">
                                <a href="#">${i.getAcc().getUsername()}</a>
                            </span>
                            <span class="be-comment-time">
                                <i class="fa fa-clock-o"></i>
                                ${i.getDate()}
                            </span>
                            <div class="rating" style="transform: translateY(-10px);    "> 
                                <i class="fa ${i.getStars()<0.25?'fa-star-o':
                                               i.getStars()>=0.25 && i.getStars()<0.75?'fa-star-half-o':
                                               i.getStars()>=0.75?'fa-star':''}"></i>
                                <i class="fa ${i.getStars()<1.25?'fa-star-o':
                                               i.getStars()>=1.25 && i.getStars()<1.75?'fa-star-half-o':
                                               i.getStars()>=1.75?'fa-star':''}"></i>
                                <i class="fa ${i.getStars()<2.25?'fa-star-o':
                                               i.getStars()>=2.25 && i.getStars()<2.75?'fa-star-half-o':
                                               i.getStars()>=2.75?'fa-star':''}"></i>
                                <i class="fa ${i.getStars()<3.25?'fa-star-o':
                                               i.getStars()>=3.25 && i.getStars()<3.75?'fa-star-half-o':
                                               i.getStars()>=3.75?'fa-star':''}"></i>
                                <i class="fa ${i.getStars()<4.25?'fa-star-o':
                                               i.getStars()>=4.25 && i.getStars()<4.75?'fa-star-half-o':
                                               i.getStars()>=4.75?'fa-star':''}"></i>
                            </div>
                            <p class="be-comment-text" style="margin-bottom: 20px;">
                                ${i.getDescription()}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>



        <!--title-->
        <div class="small-container">
            <div class="row row-2">
                <h2>Related Products</h2>
                <a href="filter?cat=${p.getCatID()}&condition=1">View more</a>
            </div>
        </div>

        <!--products-->
        <div class="small-container">
            <div class="row">
                <c:forEach items="${relates}" var="p">
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

        <img style="${p.getQuantity()==0?'position : absolute; top: 50vh;left: 13vw; opacity: 0.5;rotate: -7deg;':"display: none"}" 
             src="images/soldout.png">




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

        <!--js for product gallery-->

        <script>
            var productImg = document.getElementById("productImg");
            var smallImg = document.getElementsByClassName("small-img");
            function change(img) {
                productImg.src = img.src;
            }

        </script>
    </body>
</html>
