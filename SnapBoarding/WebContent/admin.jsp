<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

	<meta charset="utf-8">
	<title>Admin Page</title>

	<link rel="stylesheet" href="css/demo.css">
	<link rel="stylesheet" href="css/header-login-signup.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>

</head>
<body>

<header class="header-login-signup">

	<div class="header-limiter">

		<h1><a href="#">Company<span>logo</span></a></h1>

		<ul>
			<li>Admin</li>
			<li><a href="logout.htm">Logout</a></li>
		</ul>

	</div>

</header>

<div id='cssmenu'>
<ul>
   <li><a href="preAddHR.htm"><span>Add HR</span></a></li>
   <li><a href="preAddEmployee.htm"><span>Add Employee</span></a></li>
   <li><a href="preRemoveEmployee.htm"><span>Remove Employee</span></a></li>
</ul>
</div>

<div class="content">
<h1>Welcome Admin...</h1>  
</div>
<footer class="footer">
	<p><span>@Copyright 2015</span></p>

</footer>
</body>
</html>
