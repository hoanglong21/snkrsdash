CREATE DATABASE snkrsdash;
GO

use snkrsdash;
GO

create table [Roles] (
	ID int primary key,
	[Name] nvarchar(10),
	--And some thing can do and can't do--
)

create table Accounts (
	ID int IDENTITY(1,1) primary key,
	Username nvarchar(30) UNIQUE,
	[Password] nvarchar(30),
	[RoleID] int,
	Address nvarchar(150),
	Achieve int DEFAULT 0,
	Money float DEFAULT 50000,
	Email nvarchar(100) UNIQUE,
	Image nvarchar(150),
	foreign key (RoleID) references [Roles](ID)
)

create table Categories (
	ID int IDENTITY(1,1) primary key,
	[Name] nvarchar(30)
)

create table Products (
	ID int IDENTITY(1,1) primary key,
	[Name] nvarchar(50),
	Price float,
	Quantity int,
	CatID int,
	[Description] nvarchar(500),
	OwnerID int,
	foreign key (CatID) references Categories(ID),
	foreign key (OwnerID) references Accounts(ID)
)

create table Images (
	ID int IDENTITY(1,1) primary key,
	[Name] nvarchar(50),
	[Address] nvarchar(150),
	ProductID int,
	foreign key (ProductID) references Products(ID)
)

create table Orders (
	ID int IDENTITY(1,1) primary key,
	OrderDate date,
	AccountID int,
	foreign key (AccountID) references Accounts(ID)
)

create table OrderDetails (
	OrderID int,
	ProductID int,
	Price float,
	Quantity int,
	Size int,
	Discount float,
	primary key(OrderID, ProductID),
	foreign key (OrderID) references Orders(ID),
	foreign key (ProductID) references Products(ID)
)

create table Carts (
	ID int IDENTITY(1,1),
	AccountID int,
	ProductID int,
	Quantity int,
	Size int,
	foreign key (ProductID) references Products(ID),
	foreign key (AccountID) references Accounts(ID),
	primary key(ID, AccountID, ProductID)
)

create table Feedbacks (
	AccountID int,
	ProductID int,
	Date date,
	Stars float,
	Description nvarchar(1000),
	foreign key (ProductID) references Products(ID),
	foreign key (AccountID) references Accounts(ID),
	primary key(AccountID, ProductID)
)


---------------------  DATA BELOW ---------------------------------------

insert into Roles
values (1, 'Admin'),(2, 'Customer'),(3, 'Seller')

insert into Accounts (Username, Password, RoleID, Email)
values ('admin', 'admin123', 1, 'admin@gmai.com'), ('hoanglong', '123', 2, 'hl@gmai.com'), ('biStore', '111', 3, 'bi@gmail.com'),
		('Sneaker Moon', 'admin123', 3, 'moon@gmail.com'), ('Sneaker Ghost', '123', 3, 'go@gmail.com'), ('Sneaker Blank', '111', 3, 'bl@gmail.com')

insert into Categories (Name)
values ('Adidas'),('Nike'),('Off-White'),('Vans'),('Converse')

insert into Products (Name, Price, Quantity, CatID, OwnerID, Description)
values 
('4D RUN 1.0 SHOES', 242, 10, 1, 3, 'These insights created a unique 3D-printed lattice structure tuned to cushion and support your feet exactly where needed when you are on the move.'),
('ALPHABOUNCE INSTINCT', 120, 15, 1, 3, 'Features Adaptive Torsion System in s-curve pattern, made with BOUNCE, designed to provide maximum cushion and comfort without sacrificing the foot’s natural movement'),
('NMD_R1 SHOES', 159, 13, 1, 3, 'One thing’s for sure. Our world is always changing. Shift, adapt and keep up in these adidas NMD_R1 Shoes. Blending the best of modern adidas technology with archival running style, they have a Boost midsole for superior cushioning and endless energy. A moulded heel patch delivers added stability so you can easily switch directions when plans change. Which they definitely will.'),
('YEEZY BOOST 700 V2 TEPHRA', 348, 7, 1, 3, 'If you’re looking for a tough sneaker then you need to buy the new adidas Yeezy Boost 700 V2 Tephra. This Yeezy Boost 700 V2 comes with a tephra upper, tephra midsole, and a tephra sole.'),
('ULTRABOOST 4.0 DNA SHOES', 199, 20, 1, 3, 'A young legend. The adidas Ultraboost debuted in 2015, and it became a go-to far beyond the realm of running. These shoes have a soft knit upper that offers ventilation where you need it most. They ride on our original tooling, with a Boost midsole for comfort you need to feel to believe.'),

('ULTRABOOST 20 ISS U.S. NATIONAL LAB', 133, 4, 1, 4, 'The design aesthetic of the new adidas Ultraboost 20 takes inspiration from our partnership with the ISS U.S. National Lab and, with more to come from the partnership, we plan on taking Boost to even greater heights.'),
('ULTRABOOST 21 SHOES', 188, 9, 1, 4, 'Prototype after prototype. Innovation after innovation. Testing after testing. Meet us in the hot pursuit of the pinnacle harmonization of weight, cushioning, and responsiveness. Ultraboost 21. Say hello to incredible energy return.'),
('YEEZY 500 SOFT VISION', 200, 11, 1, 4, 'The YEEZY 500 Soft Vision features an upper composed of cow suede, premium leather and mesh. A rubber wrap along the midsole of the foot provides support and abrasion resistance with reflective piping details around the lace eyelets that add visibility in low-light conditions. The adiPRENE+ cushioning absorbs impact and optimizes rebound while a light rubber outsole provides traction.'),
('YEEZY BOOST 350 V2 CITRIN REFLECTIVE', 220, 12, 1, 4, 'The YEEZY BOOST 350 V2 Citrin features an upper composed of multi-toned re-engineered Primeknit. The post-dyed monofilament side stripe is woven into the upper. The midsole utilizes adidas’ innovative BOOST™ technology.'),
('YEEZY BOOST 350 V2 ZEBRA', 250, 10, 1, 4,	'The YEEZY BOOST 350 V2 White/Core Black/Red features a Primeknit upper, distinct center stitching, and heel tab. The midsole utilizes adidas’ innovative BOOST™ technology.'),

('Air Force 1 Mid Jewel NYC Cool Grey', 155, 12, 2, 5, 'Coming in many different flavours and styles, the Air Force 1 ruled the city’s sneakerculture at that time, and to celebrate that legacy, this makeup is here to bring back the vibes. With a much-loved Cool Grey upper, Metallic Silver jewel Swooshes and an OG shape, this special edition NYC Air Force 1 Mid Jewel celebrates the city, its style and all sneaker-loving New Yorkers.'),
('Air Jordan 4 Shimmer', 245, 10, 2, 5, 'Inclusivity should always stand out. The Air Jordan 4 Shimmer celebrates women who create safe and inclusive spaces for other women within their own communities. The shoe features a mix of burnished leather and soft nubuck in warm, earthy neutrals that’ll age and naturally sheen over time. And to make sure you’re always seen, the tongue is capped with a Metallic Silver Jumpman, representing a mirror in which to see yourself being comfortable in your own skin and your own space.'),
('Dunk High Aluminium', 143, 14, 2, 5, 'Modern footwear technology brings the design’s comfort into the 21st century, while a bold combination of white and Aluminium gives this makeup a bright, shining feeling.'),
('Dunk Low Next Nature Pale Coral', 129, 19, 2, 5, 'Crafted with Pale Coral and white synthetic leather made from recycled polyester, the Dunk Low Next Nature channels vintage basketball style and simple living onto the streets.'),
('ISPA Flow 2020 SE Black', 259, 9, 2, 5, 'Since launching in November 2018, Nike ISPA has continued to redefine sportswear around its organising philosophy: Improvise. Scavenge. Protect. Adapt. The label’s latest offering features the ISPA Flow 2020—an airy silhouette that uses lightweight textile to create a sock-like feel for incredible comfort.'),

('LeBron 18 Low x Mimi Plange Daughters', 207, 5, 2, 3, 'LeBron is committed to loving and celebrating all of the important women in his life, and the LeBron 18 Low "Daughters" is a deep reflection of that devotion. Designed by unfashion visionary Mimi Plange, this LeBron 18 Low is her second sneaker design in her collaboration with LeBron. For this colourway, Mimi uses the symbolic rose as a dedication to raising strong daughters, spreading a message of empowerment for girls to express their own beauty, resilience and growth.'),
('MSCHF x INRI AIR MAX 97 CUSTOM', 3160, 3, 2, 3, 'in reference to religious symbolism and the cult appeal of streetwear, digital culture studio MSCHF has created ‘jesus shoes‘. the design injects 60cc of holy water into the bubble of a air max sole to allow wearers to literally ‘walk on water’ with every step. realized with a somewhat tongue-in-cheek attitude, the shoes utilize the classic NIKE silhouette to investigate ideas of devotion in both religion and commercial products.'),
('NIKE AIR MAX 1 SKETCH TO SHELF', 175, 23, 2, 3, 'In terms of products, the shoes are designed with the dominant white tone, as the background for the details, black or red drawings that the motifs describe each part of the shoes, exactly like what is shown on the drawing. by Tinker.'),
('NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS', 350, 6, 2, 3, 'Grab a fresh pair of Nike SB’s and cop the Jordan 1 Retro High OG Defiant SB Light Bone. This AJ 1 SB comes with a grey upper plus white and black accents, black Nike "Swoosh", white midsole, and a white sole'),
('SB Dunk High Gundam', 143, 7, 2, 3, 'The "Gundam" SB Dunk High is a testament to imagination and work ethic, and brings DIY inspiration and science-fiction fashion to an iconic line of eccentric SB Dunks.'),

('Chuck Taylor All Star Classic', 68, 34, 5, 4, 'As a legend of the Converse Classic line, the high-collar white version is chosen by many young people because of its soft, lightweight material and stylish design. This is the product that makes you satisfied with the extremely standard mix & match, especially the ability to bring out your personality no matter where you are, whatever you do.'),
('Chuck Taylor All Star Hoop Hunter', 70, 18, 5, 4, 'Continue to use Camo motifs on the high neck design to help you get a personalized product from the toe to the heel. Patching the Chuck Taylor All Star logo also did not forget to take advantage of this motif to refresh the familiar round logo.'),
('Chuck Taylor All Star Mono Suede', 49, 30, 5, 4, 'Chuck Taylor All Star Mono Suede features an extremely trendy Blue Sky color during the past time mixed with high-quality suede material to help keep feet soft and comfortable when moving. Designed with advanced Ortholife technology, the sole is equipped with a high-quality rubber layer that matches the color of the shoe body and shoelaces to create outstanding accents, helping you attract all eyes when wearing shoes down the street.'),
('Chuck Taylor All Star Wordmark', 70, 15, 5, 4, 'The strong combination of high neck design, Camo motifs and Wordmark CONVERSE accents are boldly printed on the side of the shoe body.'),
('Converse All-Court Basketball', 79, 17, 5, 4, 'Converse continues to launch the All-court Basketball version of the newly launched sports shoe line. The product is upgraded to support movement with a shoe body made of high-quality leather, combined with a reed detail made from elastic mesh fabric. In addition, the design takes white as the main color with subtle accents, creating an ideal item to wear when practicing or walking down the street.'),

('Converse Chuck Taylor All Star CX Black Ice', 100, 14, 5, 5, 'Converse continues to return to the race with the new Converse Chuck Taylor All Star CX version with a very unique yet sophisticated color scheme, enough to balance any outfit for you to go down the street. More impressive with Stretch Faux Leather material and CX Foam sole integrated in this new product, giving you more comfort.'),
('Converse Chuck Taylor All Star Lift Canvas', 79, 24, 5, 5, 'Bringing back the high sole version in a basic dark look, the Converse Platform Canvas is a smooth and harmonious combination of the thick rubber Platform sole and the lightweight, durable Canvas Upper. With basic colors and a hack that can’t be underestimated, you can confidently wear this item to meet friends in the most beautiful and radiant outfits.'),
('Converse Chuck Taylor All Star Seasonal Color', 66, 22, 5, 5, 'The trendy and trendy color scheme from the Converse Seasonal Color shoe line brings a new product in the eye-catching Obsidian Mist color gamut. The comfortable, sporty design inherited from the classic shoe line will give you moments of comfort. With the advantages of being easy to carry, easy to wear, with fashionable and outstanding colors, Converse Seasonal Obsidian Mist will be an effective "assistant" to help you take the spotlight at every fun.'),
('Converse Jack Purcell Leather', 62, 21, 5, 5, 'Classic Converse Jack Purcell design with elegant, trendy All-White color tone, especially durable high-quality leather material for easy cleaning. Any combination will become easier when you have in your shoe cabinet an item like this!'),
('Converse Run Star Hike Keith Haring', 110, 11, 5, 5, 'The Run Star Hike design has a Black tone that highlights the funny images of Keith Haring’s eye-catching Botanical Art drawing style. In particular, impressing is the appearance of Keith Haring’s signature appearing on the tongue and also in the insole. The shoes promise to bring you a great experience on the bold serrated chunky soles and the interior is worth the money.'),

('Vans MN Skate Old Skool', 100, 30, 4, 3, 'The classic Old Skool model reappears in the Vans Skate Old Skool release with a series of groundbreaking innovations for the skate line. Reborn with a new name, the shoe not only impresses with the smallest details changed, but also makes a stir in the skaters village with its cutting-edge technology integrated in Duracap insoles, PopCush cushioning or high glue. su SickStick, providing maximum comfort and convenience for skate-players.'),
('Vans Old Skool White', 77, 15, 4, 3, 'Vans Old Skool Classic design full white elegant but no less personality gives you many outfit combinations. Soft and lightweight Canvas material on the upper gives you comfort on the go. The rubber sole of the skateboarding version of the shoe ensures durability and good grip.'),
('Vans Sk8-Hi', 80, 20, 4, 3, 'Vans SK8-Hi with high collar design above the ankle and retains characteristic wavy details on both sides of the shoe. Using a combination of both Canvas and soft suede materials helps the shoe form hug the foot more. Products for extremely stylish and trendy street style.'),
('Vans Slip On Checkerboard', 84, 26, 4, 3, 'Vans Slip-On Checkerboard Anaheim Factory with a familiar slip-on design combined with classic black-and-white checkered motifs creates outstanding accents. The interior of the shoe body is equipped with OrthoLite® cushioning with many ventilation holes to help keep feet comfortable.'),
('Vans UA Classic Slip-On New Varsity', 64, 23, 4, 3, 'Vans New Varsity was launched with a magical highlight of 3 main motifs such as skull and crossbones, stylized apple checkerboard and "Vans" brand motif that creates a strong impression at first sight. promises to be the best-item for young people who like thrills and are interested in horror details. In addition, the delicate Drizzle/Black color scheme gives the overall harmony of classic and warm beauty.'),

('Vans UA Classic Slip-On Paradise Floral', 66, 13, 4, 4, 'Vans Paradise Floral applies cold tones to temperate flowers and plants, with the exotic appeal of the elegance of cold flowers. No longer the colorful flowers like previous versions, this time Vans’ design focuses on lines, choosing each motif as well as focusing on visually stimulating color schemes.'),
('Vans UA Era Bandana', 88, 27, 4, 4, 'Inspired by impressive Bandana scarves, Vans Era Bandana shoes have won the hearts of young people through unique patterns, a combination of Paisley motifs and skull motifs arranged throughout the shoe body. The design also attracts attention with the new Tie Dye style background color scheme, bringing an irresistible attraction to make your outlook more beautiful and radiant.'),
('Vans UA Era Classic Sport', 64, 29, 4, 4, 'Creating a pleasant feeling at first sight, Vans Classic Sport Era possesses an extremely delicate color scheme, which is mixed between two gentle but equally youthful Drizzle & Ballad Blue colors to create a trendy look. personality. The dynamic, flexible Era design is made entirely of high-quality, smooth and soft Textile fabric that promises to bring you the best wearing experience.'),
('Vans UA Old Skool Color Theory Shale Green', 77, 19, 4, 4, 'It’s time to remove the duplication and come up with a new, simple yet fashionable design of Vans Color Theory Shale Green. Light, cool, trendy Shale Green monochrome color scheme for youthfulness and dynamic style, these new Vans models will be the item that orients you to integrate with the trending trend this year.'),
('Vans UA Old Skool Style 36 SE Bikes', 100, 12, 4, 4, 'Celebrating the years of accompanying BMX Riders on challenging races, Vans x SE Bikes has teamed up to launch shoes for mountain bike racing. The design is bold street sports with the names of iconic bicycles in the midsole, combined with the most comfortable and flexible structure, the shoe model promises to meet the strict requirements in movement to You go all out for a long, challenging day.'),

('AIR FORCE 1 LOW THE TEN', 4521, 7, 3, 6, 'The first basketball shoe with Air became a force that transcended its days on the hardwood. A groundbreaking performance shoe when it launched, the Air Force 1 just as quickly found an unshakeable place in sneaker culture. To this day, the classic white-on-white iteration remains the ultimate canvas for urban expression, and a defining icon of NYC and beyond.'),
('AIR JORDAN 1 THE TEN', 7481, 5, 3, 6, 'As part of The Ten Collection, Virgil Abloh introduced a unique, reconstructed Air Jordan I. His take on the icon was designed to evoke a DIY nature with a hand-cut, reconstructed look. Abloh wanted it to feel approachable, something that you can also create with the right tools at home.'),
('AIR MAX 90 THE TEN', 2672, 9, 3, 6, 'Poised for a new decade, the Tinker-Hatfield-designed Air Max 90 captured the phenomenon of visible air taking sneaker design to an all-new maximum. Celebrated by runners and sneaker lovers alike, this icon of sneaker culture offered more cushioning, more flexibility and more cultural connections, and found a special place in UK underground music scenes.'),
('AIR MAX 97 THE TEN', 1525, 8, 3, 6, 'For the first time, Air was in full view with the Air Max 97. As future-forward as the day it launched, the Silver Bullet continues to define the look of performance and sport style. With its unmissable reflection and sleek lines that ripple across the upper, the silhouette would also find a place within Italy’s cultural spectrum—from the catwalks of Milan to nightclubs and train yards across the country.'),
('AIR PRESTO x OFF-WHITE THE TEN', 1385, 6, 3, 6, 'Supplied by a premier sneaker marketplace dealing with unworn, already sold out, in demand rarities. Each product is rigorously inspected by experienced experts guaranteeing authenticity. Without a doubt one of the most coveted models in all of Virgil Abloh’s ultra-hyped OFF-WHITE x Nike “THE TEN” collection, the Air Presto is considered by many to be the best shoe of 2017'),

('AIR VAPORMAX X OFF-WHITE THE TEN', 1327, 3, 3, 6, 'Nike and Virgil Abloh’s Off-White extend their collaborative quest to reimagine Nike’s most iconic silhouettes. The ground-breaking Nike Air VaporMax X Off-White relaunches in black with a clean, transparent VaporMax Air-Sole unit, reflecting Virgil’s design ethos of simplicity and a raw material palette. Absence of colour brings forth the textures and design details of one of Nike’s most advanced silhouettes in history.'),
('BLAZER MID THE TEN', 4290, 5, 3, 6, 'As the first basketball shoe from Nike, the blazer featured the legendary Swoosh and dominated the hall floor from the start. Then in the mid-80s, ten years after his debut, he became an icon of skater culture. Its high ankle area and the continuous support of the foot made it the perfect shoe for the new, airy dynamic of skateboarding.'),
('CONVERSE CHUCK II x OFF-WHITE THE TEN', 1755, 12, 3, 6, 'Converse Chuck II shoes still keep their familiar design and shape as ever. The shoe structure is divided into 2 main parts very clearly. The rubber midsole is covered with a Tint-Sole layer to create a transparent effect, with the naked eye can clearly see the inside. Upper uses fancy, sturdy, thick and transparent materials.'),
('REACT HYPERDUNK THE TEN', 1880, 9, 3, 6, 'The Hyperdunk has always stood for outstanding performance. It all started with Kobe jumping over a Maserati. In the latest version, the new React technology from Nike ensures unprecedented responsiveness, which makes the game even faster.'),
('ZOOM FLY THE TEN', 1320, 12, 3, 6, 'The Nike Zoom Fly is the natural evolution of Nike’s origins, a constant mission to craft footwear that enables athletes to do the unthinkable. Carefully designed for a specially selected group of runners attempting to break the 2-hour marathon barrier, the Zoom Fly is a state-of-the-art response to the chase for peak human performance.')

insert into Images (Address, ProductID)
values 
('images/Adidas/4D RUN 1.0 SHOES/4D_Run_1.0_Shoes_White_FW1233_01_standard.jpg', 1), 
('images/Adidas/4D RUN 1.0 SHOES/4D_Run_1.0_Shoes_White_FW1233_02_standard.jpg', 1),
('images/Adidas/4D RUN 1.0 SHOES/4D_Run_1.0_Shoes_White_FW1233_03_standard.jpg', 1),
('images/Adidas/4D RUN 1.0 SHOES/4D_Run_1.0_Shoes_White_FW1233_04_standard.jpg', 1),
('images/Adidas/4D RUN 1.0 SHOES/4D_Run_1.0_Shoes_White_FW1233_05_standard.jpg', 1),
('images/Adidas/4D RUN 1.0 SHOES/4D_Run_1.0_Shoes_White_FW1233_06_standard.jpg', 1),

('images/Adidas/ALPHABOUNCE INSTINCT/514598.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514599.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514600.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514601.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514602.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514603.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514604.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514605.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514606.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514595.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514596.jpg', 2),
('images/Adidas/ALPHABOUNCE INSTINCT/514597.jpg', 2),

('images/Adidas/NMD_R1 SHOES/NMD_R1_Shoes_White_GX0999_01_standard.jpg', 3),
('images/Adidas/NMD_R1 SHOES/NMD_R1_Shoes_White_GX0999_02_standard.jpg', 3),
('images/Adidas/NMD_R1 SHOES/NMD_R1_Shoes_White_GX0999_03_standard.jpg', 3),
('images/Adidas/NMD_R1 SHOES/NMD_R1_Shoes_White_GX0999_04_standard.jpg', 3),
('images/Adidas/NMD_R1 SHOES/NMD_R1_Shoes_White_GX0999_05_standard.jpg', 3),
('images/Adidas/NMD_R1 SHOES/NMD_R1_Shoes_White_GX0999_06_standard.jpg', 3),

('images/Adidas/RELEASE adidas YEEZY BOOST 700 V2 TEPHRA/1(4).jpg', 4),
('images/Adidas/RELEASE adidas YEEZY BOOST 700 V2 TEPHRA/2(2).jpg', 4),
('images/Adidas/RELEASE adidas YEEZY BOOST 700 V2 TEPHRA/3(2).jpg', 4),
('images/Adidas/RELEASE adidas YEEZY BOOST 700 V2 TEPHRA/4.jpg', 4),
('images/Adidas/RELEASE adidas YEEZY BOOST 700 V2 TEPHRA/adidas-YEEZY-Boost-700-V2-Tephra.jpg', 4),

('images/Adidas/ULTRABOOST 4.0 DNA SHOES/Ultraboost_4.0_DNA_Shoes_White_FY9120_01_standard.jpg', 5),
('images/Adidas/ULTRABOOST 4.0 DNA SHOES/Ultraboost_4.0_DNA_Shoes_White_FY9120_02_standard.jpg', 5),
('images/Adidas/ULTRABOOST 4.0 DNA SHOES/Ultraboost_4.0_DNA_Shoes_White_FY9120_03_standard.jpg', 5),
('images/Adidas/ULTRABOOST 4.0 DNA SHOES/Ultraboost_4.0_DNA_Shoes_White_FY9120_04_standard.jpg', 5),
('images/Adidas/ULTRABOOST 4.0 DNA SHOES/Ultraboost_4.0_DNA_Shoes_White_FY9120_05_standard.jpg', 5),
('images/Adidas/ULTRABOOST 4.0 DNA SHOES/Ultraboost_4.0_DNA_Shoes_White_FY9120_06_standard.jpg', 5),

('images/Adidas/ULTRABOOST 20 ISS U.S. NATIONAL LAB/552406.jpg', 6),
('images/Adidas/ULTRABOOST 20 ISS U.S. NATIONAL LAB/552404.jpg', 6),
('images/Adidas/ULTRABOOST 20 ISS U.S. NATIONAL LAB/552798.jpg', 6),
('images/Adidas/ULTRABOOST 20 ISS U.S. NATIONAL LAB/552803.jpg', 6),
('images/Adidas/ULTRABOOST 20 ISS U.S. NATIONAL LAB/552402.jpg', 6),

('images/Adidas/ULTRABOOST 21 SHOES/Ultraboost_21_Shoes_White_FY0377_01_standard.jpg', 7),
('images/Adidas/ULTRABOOST 21 SHOES/Ultraboost_21_Shoes_White_FY0377_02_standard.jpg', 7),
('images/Adidas/ULTRABOOST 21 SHOES/Ultraboost_21_Shoes_White_FY0377_03_standard.jpg', 7),
('images/Adidas/ULTRABOOST 21 SHOES/Ultraboost_21_Shoes_White_FY0377_04_standard.jpg', 7),
('images/Adidas/ULTRABOOST 21 SHOES/Ultraboost_21_Shoes_White_FY0377_05_standard.jpg', 7),
('images/Adidas/ULTRABOOST 21 SHOES/Ultraboost_21_Shoes_White_FY0377_06_standard.jpg', 7),

('images/Adidas/YEEZY 500 SOFT VISION/550685.jpg', 8),
('images/Adidas/YEEZY 500 SOFT VISION/550686.jpg', 8),
('images/Adidas/YEEZY 500 SOFT VISION/550684.jpg', 8),
('images/Adidas/YEEZY 500 SOFT VISION/550687.jpg', 8),
('images/Adidas/YEEZY 500 SOFT VISION/550688.jpg', 8),

('images/Adidas/YEEZY BOOST 350 V2 CITRIN REFLECTIVE/548595.jpg', 9),
('images/Adidas/YEEZY BOOST 350 V2 CITRIN REFLECTIVE/548596.jpg', 9),
('images/Adidas/YEEZY BOOST 350 V2 CITRIN REFLECTIVE/548592.jpg', 9),
('images/Adidas/YEEZY BOOST 350 V2 CITRIN REFLECTIVE/548593.jpg', 9),
('images/Adidas/YEEZY BOOST 350 V2 CITRIN REFLECTIVE/548594.jpg', 9),

('images/Adidas/YEEZY BOOST 350 V2 ZEBRA/553962.jpg', 10),
('images/Adidas/YEEZY BOOST 350 V2 ZEBRA/553963.jpg', 10),
('images/Adidas/YEEZY BOOST 350 V2 ZEBRA/553959.jpg', 10),
('images/Adidas/YEEZY BOOST 350 V2 ZEBRA/553960.jpg', 10),
('images/Adidas/YEEZY BOOST 350 V2 ZEBRA/553961.jpg', 10),

('images/Nike/Air Force 1 Mid Jewel NYC Cool Grey/air-force-1-mid-jewel-nyc-cool-grey-release-date.jpg', 11),
('images/Nike/Air Force 1 Mid Jewel NYC Cool Grey/air-force-1-mid-jewel-nyc-cool-grey-release-date (2).jpg', 11),
('images/Nike/Air Force 1 Mid Jewel NYC Cool Grey/air-force-1-mid-jewel-nyc-cool-grey-release-date (1).jpg', 11),
('images/Nike/Air Force 1 Mid Jewel NYC Cool Grey/air-force-1-mid-jewel-nyc-cool-grey-release-date (3).jpg', 11),
('images/Nike/Air Force 1 Mid Jewel NYC Cool Grey/air-force-1-mid-jewel-nyc-cool-grey-release-date (4).jpg', 11),
('images/Nike/Air Force 1 Mid Jewel NYC Cool Grey/air-force-1-mid-jewel-nyc-cool-grey-release-date (5).jpg', 11),

('images/Nike/Air Jordan 4 Shimmer/women-s-air-jordan-4-shimmer-release-date.jpg', 12),
('images/Nike/Air Jordan 4 Shimmer/women-s-air-jordan-4-shimmer-release-date (1).jpg', 12),
('images/Nike/Air Jordan 4 Shimmer/women-s-air-jordan-4-shimmer-release-date (2).jpg', 12),
('images/Nike/Air Jordan 4 Shimmer/women-s-air-jordan-4-shimmer-release-date (3).jpg', 12),
('images/Nike/Air Jordan 4 Shimmer/women-s-air-jordan-4-shimmer-release-date (4).jpg', 12),
('images/Nike/Air Jordan 4 Shimmer/women-s-air-jordan-4-shimmer-release-date (5).jpg', 12),

('images/Nike/Dunk High Aluminium/women-s-dunk-high-aluminium-release-date.jpg', 13),
('images/Nike/Dunk High Aluminium/women-s-dunk-high-aluminium-release-date (1).jpg', 13),
('images/Nike/Dunk High Aluminium/women-s-dunk-high-aluminium-release-date (2).jpg', 13),
('images/Nike/Dunk High Aluminium/women-s-dunk-high-aluminium-release-date (3).jpg', 13),
('images/Nike/Dunk High Aluminium/women-s-dunk-high-aluminium-release-date (4).jpg', 13),
('images/Nike/Dunk High Aluminium/women-s-dunk-high-aluminium-release-date (5).jpg', 13),

('images/Nike/Dunk Low Next Nature Pale Coral/women-s-dunk-low-next-nature-pale-coral-release-date.jpg', 14),
('images/Nike/Dunk Low Next Nature Pale Coral/women-s-dunk-low-next-nature-pale-coral-release-date (1).jpg', 14),
('images/Nike/Dunk Low Next Nature Pale Coral/women-s-dunk-low-next-nature-pale-coral-release-date (2).jpg', 14),
('images/Nike/Dunk Low Next Nature Pale Coral/women-s-dunk-low-next-nature-pale-coral-release-date (3).jpg', 14),
('images/Nike/Dunk Low Next Nature Pale Coral/women-s-dunk-low-next-nature-pale-coral-release-date (4).jpg', 14),

('images/Nike/ISPA Flow 2020 SE Black/ispa-flow-2020-se-black-release-date.jpg', 15),
('images/Nike/ISPA Flow 2020 SE Black/ispa-flow-2020-se-black-release-date (1).jpg', 15),
('images/Nike/ISPA Flow 2020 SE Black/ispa-flow-2020-se-black-release-date (2).jpg', 15),
('images/Nike/ISPA Flow 2020 SE Black/ispa-flow-2020-se-black-release-date (3).jpg', 15),
('images/Nike/ISPA Flow 2020 SE Black/ispa-flow-2020-se-black-release-date (4).jpg', 15),
('images/Nike/ISPA Flow 2020 SE Black/ispa-flow-2020-se-black-release-date (5).jpg', 15),

('images/Nike/LeBron 18 Low x Mimi Plange Daughters/lebron-18-low-x-mimi-plange-daughters-release-date.jpg', 16),
('images/Nike/LeBron 18 Low x Mimi Plange Daughters/lebron-18-low-x-mimi-plange-daughters-release-date (1).jpg', 16),
('images/Nike/LeBron 18 Low x Mimi Plange Daughters/lebron-18-low-x-mimi-plange-daughters-release-date (2).jpg', 16),
('images/Nike/LeBron 18 Low x Mimi Plange Daughters/lebron-18-low-x-mimi-plange-daughters-release-date (3).jpg', 16),
('images/Nike/LeBron 18 Low x Mimi Plange Daughters/lebron-18-low-x-mimi-plange-daughters-release-date (4).jpg', 16),
('images/Nike/LeBron 18 Low x Mimi Plange Daughters/lebron-18-low-x-mimi-plange-daughters-release-date (5).jpg', 16),

('images/Nike/RELEASE MSCHF x INRI AIR MAX 97 CUSTOM/https-hypebeast-com-image-2019-10-mschf-inri-air-max-97-walk-on-water-custom-info-001.jpg', 17),
('images/Nike/RELEASE MSCHF x INRI AIR MAX 97 CUSTOM/https-hypebeast-com-image-2019-10-mschf-inri-air-max-97-walk-on-water-custom-info-002.jpg', 17),
('images/Nike/RELEASE MSCHF x INRI AIR MAX 97 CUSTOM/https-hypebeast-com-image-2019-10-mschf-inri-air-max-97-walk-on-water-custom-info-003.jpg', 17),
('images/Nike/RELEASE MSCHF x INRI AIR MAX 97 CUSTOM/https-hypebeast-com-image-2019-10-mschf-inri-air-max-97-walk-on-water-custom-info-004.jpg', 17),
('images/Nike/RELEASE MSCHF x INRI AIR MAX 97 CUSTOM/https-hypebeast-com-image-2019-10-mschf-inri-air-max-97-walk-on-water-custom-info-005.jpg', 17),
('images/Nike/RELEASE MSCHF x INRI AIR MAX 97 CUSTOM/https-hypebeast-com-image-2019-10-mschf-inri-air-max-97-walk-on-water-custom-info-006.jpg', 17),

('images/Nike/RELEASE NIKE AIR MAX 1 SKETCH TO SHELF/3(8).jpg', 18),
('images/Nike/RELEASE NIKE AIR MAX 1 SKETCH TO SHELF/4(6).jpg', 18),
('images/Nike/RELEASE NIKE AIR MAX 1 SKETCH TO SHELF/1(1).jpg', 18),
('images/Nike/RELEASE NIKE AIR MAX 1 SKETCH TO SHELF/2(8).jpg', 18),

('images/Nike/RELEASE NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS/C.jpg', 19),
('images/Nike/RELEASE NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS/E.jpg', 19),
('images/Nike/RELEASE NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS/B.jpg', 19),
('images/Nike/RELEASE NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS/D.jpg', 19),
('images/Nike/RELEASE NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS/F.jpg', 19),
('images/Nike/RELEASE NIKE SB AIR JORDAN 1 HIGH OG DEFIANT NYC TO PARIS/G.jpg', 19),

('images/Nike/SB Dunk High Gundam/sb-dunk-high-gundam-release-date.jpg', 20),
('images/Nike/SB Dunk High Gundam/sb-dunk-high-gundam-release-date (1).jpg', 20),
('images/Nike/SB Dunk High Gundam/sb-dunk-high-gundam-release-date (2).jpg', 20),
('images/Nike/SB Dunk High Gundam/sb-dunk-high-gundam-release-date (3).jpg', 20),
('images/Nike/SB Dunk High Gundam/sb-dunk-high-gundam-release-date (4).jpg', 20),
('images/Nike/SB Dunk High Gundam/sb-dunk-high-gundam-release-date (5).jpg', 20),

('images/Converse/Chuck Taylor All Star Classic/121184-DRAKE-650x650.jpg', 21),
('images/Converse/Chuck Taylor All Star Classic/121184-DRAKE1-650x650.jpg', 21),
('images/Converse/Chuck Taylor All Star Classic/121184-DRAKE2-650x650.jpg', 21),
('images/Converse/Chuck Taylor All Star Classic/121184-DRAKE3-650x650.jpg', 21),

('images/Converse/Chuck Taylor All Star Hoop Hunter/165915C-1-650x650.jpg', 22),
('images/Converse/Chuck Taylor All Star Hoop Hunter/165915C-DRAKE1-650x650.jpg', 22),
('images/Converse/Chuck Taylor All Star Hoop Hunter/165915C-DRAKE4-650x650.jpg', 22),
('images/Converse/Chuck Taylor All Star Hoop Hunter/165915C-DRAKE7-650x650.jpg', 22),

('images/Converse/Chuck Taylor All Star Mono Suede/561729-650x650.jpg', 23),
('images/Converse/Chuck Taylor All Star Mono Suede/561729C-DRAKE1-650x650.jpg', 23),
('images/Converse/Chuck Taylor All Star Mono Suede/561729C-DRAKE2-650x650.jpg', 23),
('images/Converse/Chuck Taylor All Star Mono Suede/561729C-DRAKE3-650x650.jpg', 23),

('images/Converse/Chuck Taylor All Star Wordmark/166232C-650x650.jpg', 24),
('images/Converse/Chuck Taylor All Star Wordmark/166232C-DRAKE1-650x650.jpg', 24),
('images/Converse/Chuck Taylor All Star Wordmark/166232C-DRAKE2-650x650.jpg', 24),
('images/Converse/Chuck Taylor All Star Wordmark/166232C-DRAKE3-650x650.jpg', 24),

('images/Converse/Converse All-Court Basketball/170252C-650x650.jpg', 25),
('images/Converse/Converse All-Court Basketball/170252-1-650x650.jpg', 25),
('images/Converse/Converse All-Court Basketball/170252-2-650x650.jpg', 25),
('images/Converse/Converse All-Court Basketball/170252-3-650x650.jpg', 25),

('images/Converse/Converse Chuck Taylor All Star CX Black Ice/169607C-650x650.jpg', 26),
('images/Converse/Converse Chuck Taylor All Star CX Black Ice/169607C-1-650x650.jpg', 26),
('images/Converse/Converse Chuck Taylor All Star CX Black Ice/169607C-2-650x650.jpg', 26),
('images/Converse/Converse Chuck Taylor All Star CX Black Ice/169607C-3-650x650.jpg', 26),

('images/Converse/Converse Chuck Taylor All Star Lift Canvas/560845C-650x650.jpg', 27),
('images/Converse/Converse Chuck Taylor All Star Lift Canvas/560845C-4-1-650x650.jpg', 27),
('images/Converse/Converse Chuck Taylor All Star Lift Canvas/560845C-5-1-650x650.jpg', 27),
('images/Converse/Converse Chuck Taylor All Star Lift Canvas/560845C-6-650x650.jpg', 27),

('images/Converse/Converse Chuck Taylor All Star Seasonal Color/170466C-650x650.jpg', 28),
('images/Converse/Converse Chuck Taylor All Star Seasonal Color/170466C-1-650x650.jpg', 28),
('images/Converse/Converse Chuck Taylor All Star Seasonal Color/170466C-2-650x650.jpg', 28),
('images/Converse/Converse Chuck Taylor All Star Seasonal Color/170466C-3-650x650.jpg', 28),

('images/Converse/Converse Jack Purcell Leather/164225C-650x650.jpg', 29),
('images/Converse/Converse Jack Purcell Leather/164225C-DRAKE1-650x650.jpg', 29),
('images/Converse/Converse Jack Purcell Leather/164225C-DRAKE2-650x650.jpg', 29),
('images/Converse/Converse Jack Purcell Leather/164225C-DRAKE3-650x650.jpg', 29),

('images/Converse/Converse Run Star Hike Keith Haring/171859V-650x650.jpg', 30),
('images/Converse/Converse Run Star Hike Keith Haring/171859V-1-650x650.jpg', 30),
('images/Converse/Converse Run Star Hike Keith Haring/171859V-2-650x650.jpg', 30),
('images/Converse/Converse Run Star Hike Keith Haring/171859V-3-650x650.jpg', 30),

('images/Vans/Vans MN Skate Old Skool/VN0A5FCBY28-650x650.jpg', 31),
('images/Vans/Vans MN Skate Old Skool/VN0A5FCBY28-1-650x650.jpg', 31),
('images/Vans/Vans MN Skate Old Skool/VN0A5FCBY28-2-650x650.jpg', 31),
('images/Vans/Vans MN Skate Old Skool/VN0A5FCBY28-3-650x650.jpg', 31),

('images/Vans/Vans Old Skool White/D3HW00-1-650x650.jpg', 32),
('images/Vans/Vans Old Skool White/VN000D3HW00-DRAKE1-650x650.jpg', 32),
('images/Vans/Vans Old Skool White/VN000D3HW00-DRAKE2-650x650.jpg', 32),
('images/Vans/Vans Old Skool White/VN000D3HW00-DRAKE3-650x650.jpg', 32),

('images/Vans/Vans Sk8-Hi/D5IB8C-650x650.jpg', 33),
('images/Vans/Vans Sk8-Hi/VN000D5IB8C-DRAKE1-650x650.jpg', 33),
('images/Vans/Vans Sk8-Hi/VN000D5IB8C-DRAKE2-650x650.jpg', 33),
('images/Vans/Vans Sk8-Hi/VN000D5IB8C-DRAKE3-650x650.jpg', 33),

('images/Vans/Vans Slip On Checkerboard/VN0A3JEXPU1 - Copy-650x650.jpg', 34),
('images/Vans/Vans Slip On Checkerboard/VN0A3JEXPU1-DRAKE1-650x650.jpg', 34),
('images/Vans/Vans Slip On Checkerboard/VN0A3JEXPU1-DRAKE2-650x650.jpg', 34),
('images/Vans/Vans Slip On Checkerboard/VN0A3JEXPU1-DRAKE3-650x650.jpg', 34),

('images/Vans/Vans UA Classic Slip-On New Varsity/VN0A33TB43L-650x650.jpg', 35),
('images/Vans/Vans UA Classic Slip-On New Varsity/VN0A33TB43L-1-650x650.jpg', 35),
('images/Vans/Vans UA Classic Slip-On New Varsity/VN0A33TB43L-2-650x650.jpg', 35),
('images/Vans/Vans UA Classic Slip-On New Varsity/VN0A33TB43L-3-650x650.jpg', 35),

('images/Vans/Vans UA Classic Slip-On Paradise Floral/VN0A33TB30R-650x650.jpg', 36),
('images/Vans/Vans UA Classic Slip-On Paradise Floral/VN0A33TB30R-1-650x650.jpg', 36),
('images/Vans/Vans UA Classic Slip-On Paradise Floral/VN0A33TB30R-2-650x650.jpg', 36),
('images/Vans/Vans UA Classic Slip-On Paradise Floral/VN0A33TB30R-3-650x650.jpg', 36),

('images/Vans/Vans UA Era Bandana/VN0A54F14FK-650x650.jpg', 37),
('images/Vans/Vans UA Era Bandana/VN0A54F14FK-1-650x650.jpg', 37),
('images/Vans/Vans UA Era Bandana/VN0A54F14FK-2-650x650.jpg', 37),
('images/Vans/Vans UA Era Bandana/VN0A54F14FK-3-650x650.jpg', 37),

('images/Vans/Vans UA Era Classic Sport/VN0A54F14FY-drake-1-650x650.jpg', 38),
('images/Vans/Vans UA Era Classic Sport/VN0A54F14FY-1-650x650.jpg', 38),
('images/Vans/Vans UA Era Classic Sport/VN0A54F14FY-2-650x650.jpg', 38),
('images/Vans/Vans UA Era Classic Sport/VN0A54F14FY-3-650x650.jpg', 38),

('images/Vans/Vans UA Old Skool Color Theory Shale Green/VN0A3WKT4G6-650x650.jpg', 39),
('images/Vans/Vans UA Old Skool Color Theory Shale Green/VN0A3WKT4G6-1-650x650.jpg', 39),
('images/Vans/Vans UA Old Skool Color Theory Shale Green/VN0A3WKT4G6-2-650x650.jpg', 39),
('images/Vans/Vans UA Old Skool Color Theory Shale Green/VN0A3WKT4G6-3-650x650.jpg', 39),

('images/Vans/Vans UA Old Skool Style 36 SE Bikes/VN0A54F64YT-650x650.jpg', 40),
('images/Vans/Vans UA Old Skool Style 36 SE Bikes/VN0A54F64YT-1-650x650.jpg', 40),
('images/Vans/Vans UA Old Skool Style 36 SE Bikes/VN0A54F64YT-2-650x650.jpg', 40),
('images/Vans/Vans UA Old Skool Style 36 SE Bikes/VN0A54F64YT-3-650x650.jpg', 40),

('images/Off-White/X Nike/AIR FORCE 1 LOW THE TEN/nike-the-ten-air-force-1-low-off-white-release-date.jpg', 41),
('images/Off-White/X Nike/AIR FORCE 1 LOW THE TEN/nike-the-ten-air-force-1-low-off-white-release-date (1).jpg', 41),
('images/Off-White/X Nike/AIR FORCE 1 LOW THE TEN/nike-the-ten-air-force-1-low-off-white-release-date (2).jpg', 41),
('images/Off-White/X Nike/AIR FORCE 1 LOW THE TEN/nike-the-ten-air-force-1-low-off-white-release-date (3).jpg', 41),
('images/Off-White/X Nike/AIR FORCE 1 LOW THE TEN/nike-the-ten-air-force-1-low-off-white-release-date (4).jpg', 41),
('images/Off-White/X Nike/AIR FORCE 1 LOW THE TEN/nike-the-ten-air-force-1-low-off-white-release-date (5).jpg', 41),

('images/Off-White/X Nike/AIR JORDAN 1 THE TEN/the-ten-air-jordan-1-off-white-release-date.jpg', 42),
('images/Off-White/X Nike/AIR JORDAN 1 THE TEN/the-ten-air-jordan-1-off-white-release-date (1).jpg', 42),
('images/Off-White/X Nike/AIR JORDAN 1 THE TEN/the-ten-air-jordan-1-off-white-release-date (2).jpg', 42),
('images/Off-White/X Nike/AIR JORDAN 1 THE TEN/the-ten-air-jordan-1-off-white-release-date (3).jpg', 42),
('images/Off-White/X Nike/AIR JORDAN 1 THE TEN/the-ten-air-jordan-1-off-white-release-date (4).jpg', 42),
('images/Off-White/X Nike/AIR JORDAN 1 THE TEN/the-ten-air-jordan-1-off-white-release-date (5).jpg', 42),

('images/Off-White/X Nike/AIR MAX 90 THE TEN/nike-the-ten-air-max-90-off-white-release-date.jpg', 43),
('images/Off-White/X Nike/AIR MAX 90 THE TEN/nike-the-ten-air-max-90-off-white-release-date (1).jpg', 43),
('images/Off-White/X Nike/AIR MAX 90 THE TEN/nike-the-ten-air-max-90-off-white-release-date (2).jpg', 43),
('images/Off-White/X Nike/AIR MAX 90 THE TEN/nike-the-ten-air-max-90-off-white-release-date (3).jpg', 43),
('images/Off-White/X Nike/AIR MAX 90 THE TEN/nike-the-ten-air-max-90-off-white-release-date (4).jpg', 43),
('images/Off-White/X Nike/AIR MAX 90 THE TEN/nike-the-ten-air-max-90-off-white-release-date (5).jpg', 43),

('images/Off-White/X Nike/AIR MAX 97 THE TEN/nike-the-ten-air-max-97-off-white-release-date.jpg', 44),
('images/Off-White/X Nike/AIR MAX 97 THE TEN/nike-the-ten-air-max-97-off-white-release-date (1).jpg', 44),
('images/Off-White/X Nike/AIR MAX 97 THE TEN/nike-the-ten-air-max-97-off-white-release-date (2).jpg', 44),
('images/Off-White/X Nike/AIR MAX 97 THE TEN/nike-the-ten-air-max-97-off-white-release-date (3).jpg', 44),
('images/Off-White/X Nike/AIR MAX 97 THE TEN/nike-the-ten-air-max-97-off-white-release-date (4).jpg', 44),
('images/Off-White/X Nike/AIR MAX 97 THE TEN/nike-the-ten-air-max-97-off-white-release-date (5).jpg', 44),

('images/Off-White/X Nike/AIR PRESTO x OFF-WHITE THE TEN/12960234_13486424_1000.png', 45),
('images/Off-White/X Nike/AIR PRESTO x OFF-WHITE THE TEN/12960234_13486425_1000.png', 45),
('images/Off-White/X Nike/AIR PRESTO x OFF-WHITE THE TEN/12960234_13486426_1000.png', 45),
('images/Off-White/X Nike/AIR PRESTO x OFF-WHITE THE TEN/12960234_13486427_1000.png', 45),
('images/Off-White/X Nike/AIR PRESTO x OFF-WHITE THE TEN/12960234_13486428_1000.png', 45),

('images/Off-White/X Nike/AIR VAPORMAX X OFF-WHITE THE TEN/nike-the-ten-air-vapormax-off-white-black-release-date.jpg', 46),
('images/Off-White/X Nike/AIR VAPORMAX X OFF-WHITE THE TEN/nike-the-ten-air-vapormax-off-white-black-release-date (1).jpg', 46),
('images/Off-White/X Nike/AIR VAPORMAX X OFF-WHITE THE TEN/nike-the-ten-air-vapormax-off-white-black-release-date (2).jpg', 46),
('images/Off-White/X Nike/AIR VAPORMAX X OFF-WHITE THE TEN/nike-the-ten-air-vapormax-off-white-black-release-date (3).jpg', 46),
('images/Off-White/X Nike/AIR VAPORMAX X OFF-WHITE THE TEN/nike-the-ten-air-vapormax-off-white-black-release-date (4).jpg', 46),
('images/Off-White/X Nike/AIR VAPORMAX X OFF-WHITE THE TEN/nike-the-ten-air-vapormax-off-white-black-release-date (5).jpg', 46),

('images/Off-White/X Nike/BLAZER MID THE TEN/nike-the-ten-sb-blazer-mid-off-white-release-date.jpg', 47),
('images/Off-White/X Nike/BLAZER MID THE TEN/nike-the-ten-sb-blazer-mid-off-white-release-date (1).jpg', 47),
('images/Off-White/X Nike/BLAZER MID THE TEN/nike-the-ten-sb-blazer-mid-off-white-release-date (2).jpg', 47),
('images/Off-White/X Nike/BLAZER MID THE TEN/nike-the-ten-sb-blazer-mid-off-white-release-date (3).jpg', 47),
('images/Off-White/X Nike/BLAZER MID THE TEN/nike-the-ten-sb-blazer-mid-off-white-release-date (4).jpg', 47),
('images/Off-White/X Nike/BLAZER MID THE TEN/nike-the-ten-sb-blazer-mid-off-white-release-date (5).jpg', 47),

('images/Off-White/X Nike/CONVERSE CHUCK II x OFF-WHITE THE TEN/giay_converse_chuckII_offwhite_01-475x428.jpg', 48),
('images/Off-White/X Nike/CONVERSE CHUCK II x OFF-WHITE THE TEN/giay_converse_chuckII_offwhite_02-475x428.jpg', 48),
('images/Off-White/X Nike/CONVERSE CHUCK II x OFF-WHITE THE TEN/giay_converse_chuckII_offwhite_03-475x428.jpg', 48),
('images/Off-White/X Nike/CONVERSE CHUCK II x OFF-WHITE THE TEN/giay_converse_chuckII_offwhite_04-475x428.jpg', 48),
('images/Off-White/X Nike/CONVERSE CHUCK II x OFF-WHITE THE TEN/giay_converse_chuckII_offwhite_05-475x428.jpg', 48),

('images/Off-White/X Nike/REACT HYPERDUNK THE TEN/nike-the-ten-react-hyperdunk-off-white-release-date.jpg', 49),
('images/Off-White/X Nike/REACT HYPERDUNK THE TEN/nike-the-ten-react-hyperdunk-off-white-release-date (1).jpg', 49),
('images/Off-White/X Nike/REACT HYPERDUNK THE TEN/nike-the-ten-react-hyperdunk-off-white-release-date (2).jpg', 49),
('images/Off-White/X Nike/REACT HYPERDUNK THE TEN/nike-the-ten-react-hyperdunk-off-white-release-date (3).jpg', 49),
('images/Off-White/X Nike/REACT HYPERDUNK THE TEN/nike-the-ten-react-hyperdunk-off-white-release-date (4).jpg', 49),
('images/Off-White/X Nike/REACT HYPERDUNK THE TEN/nike-the-ten-react-hyperdunk-off-white-release-date (5).jpg', 49),

('images/Off-White/X Nike/ZOOM FLY THE TEN/nike-the-ten-zoom-fly-off-white-release-date.jpg', 50),
('images/Off-White/X Nike/ZOOM FLY THE TEN/nike-the-ten-zoom-fly-off-white-release-date (1).jpg', 50),
('images/Off-White/X Nike/ZOOM FLY THE TEN/nike-the-ten-zoom-fly-off-white-release-date (2).jpg', 50),
('images/Off-White/X Nike/ZOOM FLY THE TEN/nike-the-ten-zoom-fly-off-white-release-date (3).jpg', 50),
('images/Off-White/X Nike/ZOOM FLY THE TEN/nike-the-ten-zoom-fly-off-white-release-date (4).jpg', 50),
('images/Off-White/X Nike/ZOOM FLY THE TEN/nike-the-ten-zoom-fly-off-white-release-date (5).jpg', 50)