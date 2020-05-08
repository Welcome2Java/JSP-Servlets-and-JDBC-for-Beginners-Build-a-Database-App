<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
		//sample data
		String[] cities = {"Seoul", "Chicago", "Columbus"};
		pageContext.setAttribute("myCities", cities);

%>

<html>
<body>
	<c:forEach var="temp" items="${myCities}">
			${temp} <br/>
	
	</c:forEach>
	

</body>
</html>