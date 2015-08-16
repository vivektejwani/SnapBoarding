<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<body>
<div class="delgroup">
<form:form modelAttribute="group" action="deletegroup.htm">
	<form:label path="">Enter Group id</form:label>
	<form:input path="groupId" type="text"/>
	<br><br>
	<button type="submit" class="btn btn-primary">Delete</button>
</form:form>
</div>
</body>
</html>