<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<body>
<div class="addGroup">
<form:form modelAttribute="group" action="addgroup.htm">
	<form:label path="">Enter Group name</form:label>
	<form:input path="groupName" type="text"/>
	<br><br>
	<button type="submit" class="btn btn-primary">Create Group</button>
</form:form>
</div>
</body>
</html>