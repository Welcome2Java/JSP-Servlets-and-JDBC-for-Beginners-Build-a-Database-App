<!-- reference to the tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<c:set var="stuff" value="<%= new java.util.Date() %>" />
		Time on the Server is ${stuff} 
		
	</body>
</html>