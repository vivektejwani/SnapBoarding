<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<body>
<div class="removeEmpGrp">
<form:form modelAttribute="employeegrp" action="removegroup.htm">
	<form:label path="">Enter Group Id</form:label>
	<form:input path="group.groupId" type="text"/>
	<br><br>
	<form:label path="">Enter Employee Id</form:label>
	<form:input path="employee.empId" type="text"/>
	<br><br>
	<button type="submit" class="btn btn-primary">Remove</button>
</form:form>
</div>
</body>
</html>