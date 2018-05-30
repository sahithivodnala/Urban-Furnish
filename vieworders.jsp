<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<head>
<title>URBAN FURNISH</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Trendy Designs web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web Designs" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!--// Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Bootstrap-Core-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css"
	media="all" />
<!-- Owl-Carousel-CSS -->
<!-- pop-up-box -->
<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //pop-up-box -->
<!-- For-Gallery-CSS -->
<link href="css/viewbox.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //For-Gallery-CSS -->
<!-- //css files -->
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Roboto+Condensed:300,300i,400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
	rel="stylesheet">
<!-- //web-fonts -->
</head>
<body>
	<div class="main-agile" id="home">
		<!-- header -->
		<div class="header">
			<div class="container">

				<div class="col-md-4 w3l_header_center">
					<div class="logo">
						<h1>
							<a class="navbar-brand" href="index.html"><span>URBAN
									FURNISH</span></a>
						</h1>
					</div>
				</div>
				<div class="col-md-4 w3l_header_right w3l-r">


					<ul>
						<li><a href="product.html">Uploading a Product</a></li>
						
						
						<li><a href="index.html">Logout</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>


<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "urban_furnish";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Blob image = null;
byte[ ] imgData = null ;
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong>Order List</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="60" border="3">
<tr>

</tr>
<tr bgcolor="black">
<td><font size="5" color="white">firstname</font></td>
<td><font size="5" color="white">lastname  </font></td>
<td><font size="5" color="white">email  </font></td>
<td><font size="5" color="white">image </font></td>
</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM image";
resultSet = statement.executeQuery(sql);

while(resultSet.next()){
	image = resultSet.getBlob(1);
	imgData = image.getBytes(1,(int)image.length());
	PrintWriter ot = response.getWriter();
	ot.println(imgData);
	


%>


<tr bgcolor="white">
<td><font size="5" color="black"><%=resultSet.getString("firstname") %></font></td>
<td><font size="5" color="black"><%=resultSet.getString("lastname") %></font></td>
<td><font size="5" color="black"><%=resultSet.getString("email") %></font></td>
<td><font size="5" color="black"><%=resultSet.getBlob("image")%></font></td>



</tr>

<% 
}
}
 catch (Exception e) {
e.printStackTrace();
}
%>
</table>




		<script>
			// Get the modal
			var modal = document.getElementById('id01');

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";

				}
			}
		</script>
</body>




<!-- js-scripts -->
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<!-- Necessary-JavaScript-File-For-Bootstrap -->
<!-- //js -->
<!-- Baneer-js -->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			pager : false,
			nav : true,
			speed : 1000,
			namespace : "callbacks",
			before : function() {
				$('.events').append("<li>before event fired.</li>");
			},
			after : function() {
				$('.events').append("<li>after event fired.</li>");
			}
		});
	});
</script>
<!-- //Baneer-js -->
<!-- Popup-js -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});

	});
</script>
<!-- //Popup-js -->
<!-- Owl-Carousel-JavaScript -->
<script src="js/owl.carousel.js"></script>
<script>
	$(document).ready(function() {
		$("#owl-demo").owlCarousel({
			items : 3,
			lazyLoad : true,
			autoPlay : true,
			pagination : true,
		});
	});
</script>
<!-- //Owl-Carousel-JavaScript -->
<!-- For-Gallery-js -->
<script src="js/jquery.viewbox.min.js"></script>
<script>
	$(function() {

		$('.thumbnail').viewbox();
		$('.thumbnail-2').viewbox();

		(function() {
			var vb = $('.popup-link').viewbox();
			$('.popup-open-button').click(function() {
				vb.trigger('viewbox.open');
			});
			$('.close-button').click(function() {
				vb.trigger('viewbox.close');
			});
		})();

		(function() {
			var vb = $('.popup-steps').viewbox({
				navButtons : false
			});

			$('.steps-button').click(function() {
				vb.trigger('viewbox.open', [ 0 ]);
			});

			$('.next-button').click(function() {
				vb.trigger('viewbox.open', [ 1 ]);
			});
			$('.prev-button').click(function() {
				vb.trigger('viewbox.open', [ 0 ]);
			});
			$('.ok-button').click(function() {
				vb.trigger('viewbox.close');
			});
		})();

	});
</script>
<!-- //For-Gallery-js -->
<!-- Flexslider-js for-testimonials -->
<script type="text/javascript">
	$(window).load(function() {
		$("#flexiselDemo1").flexisel({
			visibleItems : 1,
			animationSpeed : 1000,
			autoPlay : false,
			autoPlaySpeed : 3000,
			pauseOnHover : true,
			enableResponsiveBreakpoints : true,
			responsiveBreakpoints : {
				portrait : {
					changePoint : 480,
					visibleItems : 1
				},
				landscape : {
					changePoint : 640,
					visibleItems : 1
				},
				tablet : {
					changePoint : 768,
					visibleItems : 1
				}
			}
		});

	});
</script>
<script type="text/javascript" src="js/jquery.flexisel.js"></script>
<!-- //Flexslider-js for-testimonials -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- //js-scripts -->
</body>
</html>