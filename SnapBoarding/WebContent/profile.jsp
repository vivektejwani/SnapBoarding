<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<!-- end: CSS -->
	

</head>

<body>
	
		
                 
                <div class="row-fluid sortable">		
						<div class="box span12">
							<div class="box-header" >
								<h2><i class="halflings-icon user"></i><span class="break"></span>User Profile</h2>
								
						    </div>
						    
						</div>	
				</div>
	            <div class="box-content">
						<form method="post" action="empupdateprofpage.htm">
							<table class="table table-striped table-bordered bootstrap-datatable datatable">
						     <thead>
							  <tr>
								  <th>First Name</th>
								  <th>Last Name</th>
								  <th>Email</th>
								  <th>Designation</th>
							  </tr>
						     </thead>   
						     <tbody>
								<tr>
									<td class="center"><c:out value="${currentEmp.firstName}"></c:out></td>
									<td class="center"><c:out value="${currentEmp.lastName}"></c:out></td>
									<td class="center"><c:out value="${currentEmp.email}"></c:out></td>
									<td class="center"><c:out value="${currentEmp.designation}"></c:out></td>
									
								</tr>
								<tr>
									<td colspan="4">
										<button type="submit" class="btn btn-primary">Update Profile</button>
									</td>
								</tr>	
							 </tbody>
							</table>
						</form>
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
