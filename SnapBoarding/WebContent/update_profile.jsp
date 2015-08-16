<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html lang="en">
<head>
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	
</head>

<body>
				
		<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon edit"></i><span class="break"></span>Profile</h2>
					</div>
					<div class="box-content">
					    <!-- need to send the details to the controller, update and redirect to the main page-->
						<form:form class="form-horizontal"  method="POST" name="reg_form" modelAttribute="currentEmp" action="updateEmpProfile.htm">
							<fieldset>
							 
								<div class="control-group">
								  <label class="control-label" for="focusedInput">First Name</label>
								  <div class="controls">
								  	<form:input class="input-xlarge focused" path="firstName" id="focusedInput" type="text" value="${sessionScope.user.firstName}"/>
								  </div>
							    </div>
							
							   <div class="control-group">
								<label class="control-label">Last Name</label>
								<div class="controls">
								  <form:input path="lastName" id="Email" type="text" value="${sessionScope.user.lastName}"/>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label">Email</label>
								<div class="controls">
								  <form:input path="email" id="Email" type="text" value="${sessionScope.user.email}"/>
								</div>
							  </div>
							  <div class="control-group">
								<label class="control-label">Designation</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input">Software Engineer</span>
								  <form:input path="designation" id="Designation" type="hidden" value="${sessionScope.user.designation}"/>
								  <form:input path="empId" id="empId" type="hidden" value="${sessionScope.user.empId}"/>
								  <form:input path="password" id="password" type="hidden" value="${sessionScope.user.password}"/>
								</div>
							  </div>
							  
							  <div class="form-actions">
								<button type="submit" class="btn btn-primary">Update</button>								
							  </div>
							</fieldset>
						</form:form>
					</div>
				</div><!--/span-->

			</div><!--/row-->
    

	
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
