<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<script type="text/javascript">
	
</script>
<head>
<!-- start: CSS -->
<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->

</head>

<body>

	<div class="row-fluid">
		<div class="box span12">

			<div class="box-header">
				<h2>
					<i class="halflings-icon bullhorn"></i><span class="break"></span>Recent
					Posts
				</h2>
				<div class="box-icon">
					<a href="#" class="btn-minimize"><i
						class="halflings-icon chevron-up"></i></a>
				</div>
			</div>
			<div class="box-content alerts">
				<c:forEach var="i" items="${messages}">
					<div class="alert alert-block ">

						<form:form action="deletepost.htm" modelAttribute="${i}">
							<!-- Add Model Attribute -->

							<button type="submit" class="close" data-dismiss="alert">×</button>
						</form:form>
						<h4 class="alert-heading">${i.message.subject}</h4>
						<h6 class="alert-heading">${i.group.groupName}</h6>
						<h6 class="alert-heading">${i.message.msgTime}</h6>
						<p>${i.message.msg}</p>

					</div>
				</c:forEach>
			</div>
			<div class="pagination pagination-centered">
				<ul>
					<c:if test="${currentPage != 1}">
						<li><a href="hrallposts.htm?currentPage=${currentPage - 1}">Prev</a></li>
					</c:if>

					<c:forEach begin="1" end="${noOfPages}" var="i">
						<c:choose>
							<c:when test="${currentPage eq i}">
								<li class="active"><a href="#">{i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="hrallposts.htm?currentPage=${i}">${i}</a></li>
								<!-- send request to the controller-->
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${currentPage lt noOfPages}">
						<li><a href="hrallposts.htm?currentPage=${currentPage + 1}">Next</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<!--/span-->
	</div>
	<!--/row-->

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
