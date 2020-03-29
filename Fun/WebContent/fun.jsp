<%@page import="FunAndPractice.FunAndPractice"%>
<html>
<body>
	<jsp:include page="header.jsp"/>

	<h2 align="center"><% out.println("This for practice"); %></h2>
	<h3 align="center"><%=FunAndPractice.printStatements("We are practicing JSP concepts") %></h3>
	<h4 align="center">This is not for best practice but for concept learning only.</h4>
	<h5 align="center"><%= statement("should not be writing code in a JSP file") %> </h5>
	
	
	<%!
		String statement(String input){
		return input.toUpperCase();
		}
	%>
	how do i align strings in a body without using headers???????



	<jsp:include page="footer.jsp"/>
</body>
</html>