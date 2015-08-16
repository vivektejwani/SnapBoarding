<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	

	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->
	
	<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	
		
		
		
</head>

<body>
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="empmainpage.htm"><span>EMPLOYEE PORTAL</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i><c:out value="${sessionScope.user.firstName}"></c:out>  <!-- ADDDDDDDDDD -->
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>Account Settings</span>
								</li>
								<li><a href="logout.htm"><i class="halflings-icon off"></i> Logout</a></li>  <!-- Invalidate! -->
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<!-- start: Header -->
	
    <div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="empmainpage.htm"><span class="hidden-tablet">Dashboard</span></a></li>	
						<li><a href="empprofpage.htm"><span class="hidden-tablet"> Profile </span></a></li>
						<li><a href="#"><span class="hidden-tablet"> Groups   </span><span class="label label-important"> 3 </span></a></li> <!-- Number of groups -->
						<c:forEach var="i" items="${sessionScope.user.groupList}">  <!-- User groups -->
							<!-- forward the  request to the server appending the group id as a parameter-->
							<li><a href="empmsgfromgrp.htm?grpId=${i.groupId }"><i class="icon-file-alt"></i><span class="hidden-tablet"><c:out value="${i.groupName}"></c:out></span></a></li>  <!-- send id as param to servlet to see messages -->
						</c:forEach> 
							
					</ul>
				</div>
			</div>
			<!-- end: Main Menu 
			
			<!-- start: Content -->
			<div id="content" class="span10">
				<!-- this ul can be removed if not required-->
				<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="empallposts.htm">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#"><!-- Add the name of the selected tab --></a></li>
			    </ul>
                <c:choose>
					<c:when test="${opt eq 'profile' }">  <!-- parameter to identify 'profile'  -->
								<jsp:include page="profile.jsp">
								<jsp:param value="" name=""/>
								</jsp:include>
					</c:when>	
					<c:when test="${opt eq 'update_profile' }">  <!-- parameter to identify 'update_profile'  -->
								<jsp:include page="update_profile.jsp">
								<jsp:param value="" name=""/>
								</jsp:include>
					</c:when>
					<c:when test="${opt eq 'all' }">  <!-- parameter to identify 'display all the posts/dashboard'   DEFAULT  -->
								<jsp:include page="all_posts.jsp">
								<jsp:param value="" name=""/>
								</jsp:include>
					</c:when>
					<c:when test="${opt eq 'group' }">  <!-- parameter to display posts from specific groups  -->
								<jsp:include page="group_posts.jsp">
								<jsp:param value="" name=""/>
								</jsp:include>
					</c:when>
				</c:choose>	
			</div><!--/#content.span10-->
		</div><!--/fluid-row-->
	
		
			<footer>

				<p>
					<span style="text-align:left;float:left">&copy; 2015</span>
					
				</p>

			</footer>
	</div>
	
	<!-- start: JavaScript-->

		<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="js/jquery.ui.touch-punch.js"></script>
	
		<script src="js/modernizr.js"></script>
	
		<script src="js/bootstrap.min.js"></script>
	
		<script src="js/jquery.cookie.js"></script>
	
		<script src='js/fullcalendar.min.js'></script>
	
		<script src='js/jquery.dataTables.min.js'></script>

		<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	
		<script src="js/jquery.chosen.min.js"></script>
	
		<script src="js/jquery.uniform.min.js"></script>
		
		<script src="js/jquery.cleditor.min.js"></script>
	
		<script src="js/jquery.noty.js"></script>
	
		<script src="js/jquery.elfinder.min.js"></script>
	
		<script src="js/jquery.raty.min.js"></script>
	
		<script src="js/jquery.iphone.toggle.js"></script>
	
		<script src="js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="js/jquery.gritter.min.js"></script>
	
		<script src="js/jquery.imagesloaded.js"></script>
	
		<script src="js/jquery.masonry.min.js"></script>
	
		<script src="js/jquery.knob.modified.js"></script>
	
		<script src="js/jquery.sparkline.min.js"></script>
	
		<script src="js/counter.js"></script>
	
		<script src="js/retina.js"></script>

		<script src="js/custom.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>

    