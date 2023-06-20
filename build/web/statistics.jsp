<%-- 
    Document   : index
    Created on : Sep 28, 2021, 4:54:33 PM
    Author     : HoangLong
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <title>Account Page</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://fonts.googleapis.con/css2?
              family=Poppins:wght@300;400;500;600;700&display=swap" 
              rel="stylesheet"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" 
              rel="stylesheet"/>
        <script type="text/javascript">
            window.onload = function () {

            var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2", // "light1", "light2", "dark1", "dark2"
                    animationEnabled: true, // change to true
                    backgroundColor: "rgba(0, 0, 0, 0.00)",
                    title: {
                    text:  "${param.op}"
                    },
                    axisX: {
                    labelFontSize: 20,
                    },
                    axisY: {
                    labelFontSize: 20,
                    },
                    data: [
                    {
                    // Change type to "column" "bar", "area", "spline", "pie",etc.
                    type: "column",
                            dataPoints: [
            <jsp:useBean id="DAOst" class="dal.AccountDAO"/>
            <c:if test="${param.op=='Potential Shop'}">
                <c:set value="3" var="option"/>
            </c:if>
            <c:if test="${param.op=='Potential Customer'}">
                <c:set value="2" var="option"/>
            </c:if>
            <c:set var="min" value="${0}"/>
            <c:set var="max" value="${0}"/>
            <c:set var="sum" value="${0}"/>
            <c:set var="count" value="${0}"/>
            <c:forEach items="${DAOst.all}" var="i">

                <c:if test="${i.getRoleID()==option}">
                            {label: "${i.getUsername()}", y: ${i.getAchieve()}},
                    <c:if test="${i.getAchieve()<min}"> <c:set var="min" value="${i.getAchieve()}"/> </c:if>
                    <c:if test="${i.getAchieve()>max}"> <c:set var="max" value="${i.getAchieve()}"/> </c:if>
                    <c:set var="sum" value="${i.getAchieve() + sum}"/>
                    <c:set var="count" value="${1 + count}"/>
                </c:if>
            </c:forEach>
                            ]
                    }
                    ]
            });
            chart.render();
            }
        </script>
        <style>
            th, td, td:last-child, th:last-child {
                text-align: center;
            }
        </style>
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
            <!--statistic page-->
            <table style="width: 30%;text-align: center;margin: auto;">
                <tr>
                    <td><a href="statistics.jsp?op=Potential Shop" class="btn" style="font-size: 1em; ${param.op=='Potential Shop'?'background: #f76883':''}">Potential Shops</a></td>
                    <td><a href="statistics.jsp?op=Potential Customer" class="btn" style="font-size: 1em; ${param.op=='Potential Customer'?'background: #f76883':''}">Potential Customers</a></td>
                </tr>
            </table>
            <div id="chartContainer" style="height: 370px; width: 70%; margin: auto;margin-bottom: 5%;"></div>
            <table border="1px" style="width: 70%; margin: auto;margin-bottom: 5%;">
                <tr>
                    <th>Min</th><th>Max</th><th>Sum</th><th>Average</th><th>Count</th>
                </tr>
                <tr>
                    <td>${min}</td><td>${max}</td><td>${sum}</td><td>${sum/count}</td><td>${count}</td>
                </tr>
            </table>
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


        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
</html>