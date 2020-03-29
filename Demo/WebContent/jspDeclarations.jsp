<!-- 
	jsp declaration allows you to declare a method in the JSP page and call it from the same page
	Syntax is < ! //some lines of code %> 

	Best Practices. 
		limit number of declarations
		avoid dumping thousands of lines of code
		refractor this into a java class. MVC


 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	
	<h1>Making use of JSP declaration</h1>
	
	<h2>Calling method inside jsp file</h2>
	<%! String makeItLower(String data){
		return data.toLowerCase();
		}
	%>
	
	<%!
		double addition(double x, double y){
		return x+y;
	}
	%>
	Lower case "Hello World": <%= makeItLower("HELLO WORLD") %>
	<br/>
	Adding two values together: <%= addition(4,5) %>

	</body>
</html>