<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<body>
<div class="addPost">
<label>Write post here:</label>
<form:form modelAttribute="message" action="addmessage.htm">
							
							<form:textarea autofocus="autofocus" path="msg" cols="50" rows="10" /> 
							<br><br>
							<button type="submit" class="btn btn-primary">Post</button>
											 
</form:form>   
</div>
</body>
</html>
