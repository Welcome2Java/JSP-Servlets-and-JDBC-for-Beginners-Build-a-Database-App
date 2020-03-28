<!--Where is JSP Procced? 
	JSP is processed on the server
		The results of the java code
			The time on the server is %=new Date() %
		is included in the HTML that is then returned to browser. 
		
		So the flow is this. 
		Browser
		html request
		JSP
			HTML code
			Java code
			HtML code
		html result
		Browser

	Where to place the jsp file? 
		Goes in the WebContent folder
		Must have the .jsp extentsion.   -->



<html>
<body>
	<h3>Hello World of Java</h3>
	<!--create new data object-->

	The time on the server is
	<%=new java.util.Date() %>
	<!-- output included in HTML page -->
</body>

</html>