<html>
	<head><title>Confirmation</title></head>

	<%
		//reading the form data and setting the cookie	
	
		//read form data
		String favLang = request.getParameter("favoriteLanguage");
	
		//create a cookie
		Cookie theCookie = new Cookie("myApp.favoriteLanguage", favLang);
		
		//set the lifespan of the cookie
		theCookie.setMaxAge(60*60*24*365);
		
		//send the cookie to the browser
		response.addCookie(theCookie);
	%>
<body>

	Thanks! We set your lanugage to:  ${param.favoriteLanguage}
	<br></br>
	
	<a href="cookies-homepage.jsp">Return to Homepage.</a>

</body>

</html>