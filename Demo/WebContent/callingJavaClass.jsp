<!-- 
	When using jsp it is best not use alot of java code. 
	it is better to use a separate java class or MVC

-->

<!-- importing the name of the package and class -->
<%@page import="jspDemoTraining.CallingMethodFromJsp"%>
<html>
	<body>
		<h1>Calling a method from a Java Class</h1>
		<!-- jsp expression calling a method -->
		<%=CallingMethodFromJsp.makeItLower("FUN FUN FUN") %>
	</body>
</html>