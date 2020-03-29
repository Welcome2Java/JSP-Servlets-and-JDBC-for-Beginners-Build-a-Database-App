<!-- This is like classes. We are calling for predefined methods and using it. -->



<html>
	<body>
		<h3>JSP BUILT IN OJBECTS<h3/>
	
		Request user agent: <%= request.getHeader("User-Agent") %>
		<!-- tells what operating system the user is on -->
		<br/><br/>
		
		Language user is using: <%= request.getLocale() %>
		<!-- tells what language ths user is using on their system. -->
	</body>
</html>