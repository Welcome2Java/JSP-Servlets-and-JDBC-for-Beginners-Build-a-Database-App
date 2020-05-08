<%@ page import="java.util.*" %>
<html>
	<head><title>Confirmation</title></head>

	
<body>
	<%
		//reading the form data and setting the cookie	

		//read form data
		String [] favFormatList = request.getParameterValues("favoriteFormat");
	
		String favFormat = favFormatList[0];
	
		//create a cookie
		Cookie theCookie = new Cookie("myApp.favoriteFormat", favFormat);
		
		//set the lifespan of the cookie
		theCookie.setMaxAge(60*60*24*365);
		
		//send the cookie to the browser
		response.addCookie(theCookie);
		
	%>
	Thanks! We set your format to:  ${param.favoriteFormat}
	<br></br>
	
	<a href="personalized-format-type-homepage.jsp">Return to Home-page.</a>

</body>

</html>