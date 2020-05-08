<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.tagDemo.Student"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
	<body>
		<c:set var="data" value="testing value" />
		 
		 
		 <b>Length of the string ${data}</b>: ${fn:length(data)}
		<br/><br/>
		
		Upper-case version of the String <b>${data}</b>: ${fn:toUpperCase(data)}
		<br/><br/>
		
		Does the string <b>${data}</b> start with <b>tes</b>?: ${fn:startsWith(data, "tes")}
		
		
		<h3>Split Demo</h3>
		<c:set var="citiesArrayString" value="HongKong,Tokyo,Chicago,London,Paris"/>
		<c:set var="citiesArray" value="${fn:split(citiesArrayString, ',')}" />
		
		<c:forEach var="tempCity" items="${citiesArray}" >
			${tempCity} <br/>
		</c:forEach>
		
		<br></br>
		<c:set var="fun" value="${fn:join(citiesArray, '*')}" />

		Result of joining: ${fun}
	
</body>
</html>