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
        <title>Products Page</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/backstyle.css"/>
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

        <div style="display: flex; min-height: 1000px;">
            <div class="left" style="width: 15%;margin-left: 5%; transform: translateY(30%); position: absolute;">
                <form action="filter" method="post">
                    <h3 style="text-align: center;background-color: #ecbac3;padding: 3%;border-radius: 15px;margin-bottom: 10px;">Filters</h3>
                    <p>Condition</p>
                    <input style="width: inherit;height: inherit; margin-left: 5%;" type="radio" ${sessionScope.condition==null || sessionScope.condition=='1'?'checked':""}  name="condition" value="1"> Available <br>
                    <input style="width: inherit;height: inherit; margin-left: 5%;" type="radio" ${sessionScope.condition=='0'?'checked':""} name="condition" value="0"> Sold out <br>
                    <p>Categories</p>
                    <jsp:useBean id="cDAO" class="dal.CategoryDAO"/>
                    <c:forEach items="${cDAO.all}" var="c">
                        <input style="width: inherit;height: inherit; margin-left: 5%;" ${sessionScope.forNext.contains(c.getID())?'checked':""} type="checkbox" name="cat" value="${c.getID()}"/>  ${c.getName()}<br>
                    </c:forEach>
                    <p>Avg. Customer Review</p>
                    <fieldset class="stars" style="border: none; margin-top: 5%;">
                        <input type="radio" name="stars" id="star1" ${sessionScope.stars=='5'?'checked':""} value="5"/>
                        <label style="font-size: inherit; float: right;width: inherit; transform: translateX(-700%);" class="fa fa-star" for="star1"></label>
                        <input type="radio" name="stars" id="star2" ${sessionScope.stars=='4'?'checked':""} value="4"/>
                        <label style="font-size: inherit; float: right;width: inherit; transform: translateX(-700%);" class="fa fa-star" for="star2"></label>
                        <input type="radio" name="stars" id="star3" ${sessionScope.stars=='3'?'checked':""} value="3"/>
                        <label style="font-size: inherit; float: right;width: inherit; transform: translateX(-700%);" class="fa fa-star" for="star3"></label>
                        <input type="radio" name="stars" id="star4" ${sessionScope.stars=='2'?'checked':""} value="2"/>
                        <label style="font-size: inherit; float: right;width: inherit; transform: translateX(-700%);" class="fa fa-star" for="star4"></label>
                        <input type="radio" name="stars" id="star5" ${sessionScope.stars=='1'?'checked':""} value="1"/>
                        <label style="font-size: inherit; float: right;width: inherit; transform: translateX(-700%);" class="fa fa-star" for="star5"></label>
                        <input type="radio" name="stars" id="star-reset"/> <p style="transform: translateX(45%);font-size: 1em;">& UP</p>
                        <label style="padding: 7px 7px; float: left;width: inherit;font-size: 0.7em;transform: translate(60%,-160%);" style="transform: translate(100%,-100%);" class="reset" for="star-reset">reset</label>
                    </fieldset>
                    <p>Price</p>
                    <div style="display: flex; align-content: space-between;">
                        <input style="width: 40%;" type="number" step="0.01" name="from" min="0" placeholder="$ Min" value="${sessionScope.from==null?'':sessionScope.from}">
                        <p style="width: 20%;font-size: 2.5em;text-align: center;">-</p> 
                        <input style="width: 40%;" type="number" name="to" min="0" placeholder="$ Max" value="${sessionScope.to==null?'':sessionScope.to}">
                    </div>

                    <p>Name</p>
                    <input type="text" placeholder="Search..." name="name" value="${sessionScope.name==null?'':sessionScope.name }"/>
                    <p>Sort</p>
                    <select style="width: 100%;" name="sort">
                        <option ${sessionScope.sort==""?'selected':''} value="">Default shorting</option>
                        <option ${sessionScope.sort=="order by price asc"?'selected':''} value="order by price asc">Short by price - Ascending</option>
                        <option ${sessionScope.sort=="order by price desc"?'selected':''} value="order by price desc">Short by price - Descending</option>
                        <option ${sessionScope.sort=="order by stars asc"?'selected':''} value="order by stars asc">Short by rating - Ascending</option>
                        <option ${sessionScope.sort=="order by stars desc"?'selected':''} value="order by stars desc">Short by rating - Descending</option>
                        <option ${sessionScope.sort=="order by ODQuantity asc"?'selected':''} value="order by ODQuantity asc">Short by sale - Ascending</option>
                        <option ${sessionScope.sort=="order by ODQuantity desc"?'selected':''} value="order by ODQuantity desc">Short by sale - Descending</option>
                    </select>
                    <input type="submit" class="btn" value="Apply"/>
                </form>
            </div>


            <div class="small-container" style="margin-top: 0; margin-left: 25%;">
                <div class="row row-2">
                    <h2 style="margin-left: 43%;">All Products</h2>
                </div>
                <c:set var="page" value="${requestScope.page}"/>
                <div class="row">
                    <c:forEach items="${data}" var="p">
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
                <div class="page-btn">
                    <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                        <span onclick="location.href = 'filter?page=${i}'">${i}</span>
                    </c:forEach>
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
