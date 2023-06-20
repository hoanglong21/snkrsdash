<%-- 
    Document   : discount
    Created on : Oct 8, 2021, 5:58:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Welcome</title>
        <link rel="stylesheet" href="css/style2.css" />
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
        <link href="http://fonts.cdnfonts.com/css/alphacentauri" rel="stylesheet">
    </head>

    <body> 
        <nav>
            <div class="logo"><a href="home"><img src = "images/lol.png" style="height: 100px;filter: invert(1);margin-top: 30px;""/></div></a>
            <div class="nav-links">
                <form action="coupon">
                    <P style="color: white;">${mess==null?"Type code here, no space":mess}</P><input type="text" href="home" placeholder="Check coupon code" name="cou"/>
                    <input type="submit" value="Check"/> 
                </form>
            </div>
        </nav>

        <section id="sectionone" class="screen">
            <div id="scene">
                <div data-depth="0.1" class="bg">
                    <img src="images2/background.png" alt="" />
                </div>
                <div data-depth="0.2" class="rock1">
                    <img src="images2/rock.png" alt="" />
                </div>
                <div style="z-index: 5;" data-depth="1.2" class="earth">
                    <img src="images2/earth.png" alt="" />
                </div>
                <div style="z-index: 4;" data-depth="0.1" class="text">
                    <h1 style=" transform: translateY(-15vh); font-size: 2.5em;">Welcome_To</h1>
                    <h1 style=" transform: translateY(-10vh);">SNKRSDASH</h1>
                </div>
                <div data-depth="0.4" class="mid">
                    <img src="images2/mid.png" alt="" />
                </div>
                <div data-depth="0.1" class="fore">
                    <img src="images2/foreground.png" alt="" />
                </div>
            </div>
        </section>
                    
        <section id="sectionone" class="screen hi" style="z-index: -1">
            <div id="scene">
                <div data-depth="0.1" class="bg">
                    <img style="rotate: 180deg;" src="images2/backgroundori.png" alt="" />
                </div>
            </div>
            <iframe style="margin-left: 5%;width: 400px; height: 400px; transform: translate(462px,-555px); border-radius: 50%; z-index: 10;
                position: relative;" 
            title="Study purpose" frameborder="0" allowfullscreen mozallowfullscreen="true" 
            webkitallowfullscreen="true" allow="autoplay; fullscreen; xr-spatial-tracking" 
            xr-spatial-tracking execution-while-out-of-viewport execution-while-not-rendered web-share 
            src="https://sketchfab.com/models/64b6de6073094475b4e9d2bcaa799ec1/embed"> </iframe> 
            <div style="z-index: 4; top: 664px; position: absolute" data-depth="0.1" class="text">
                    <h1 style=" transform: translateY(-15vh); font-size: 2.5em;">Easier_Mode</h1>
                    <h1 style="font-size: 1em;; transform: translateX(-30vh);">Left_mouse_for_change_rotate</h1>
                    <h1 style="font-size: 1em;; transform: translate(-30vh, 5vh);">Right_mouse_for_move</h1>
            </div>
        </section>
                    
        <script src="https://cdnjs.cloudflare.com/ajax/libs/parallax/3.1.0/parallax.min.js"></script>
        <script src="js/script.js" type="text/javascript"></script>
    </body>

</html>