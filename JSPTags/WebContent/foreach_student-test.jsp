<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*,com.tagDemo.Student"%>

<%
	//just create some sample data
	List<Student> data = new ArrayList<>();
	data.add(new Student("John", "Doe", false));
	data.add(new Student("Max", "Johnson", false));
	data.add(new Student("Mary", "Public", true));

	pageContext.setAttribute("myStudents", data);
%>

<html>
<body>

	<table border="1">

		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Gold Customer</th>
		</tr>

		<c:forEach var="tempStudent" items="${myStudents}">

			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>
					<!-- showing c:choose tag -->
					<c:choose>
						<c:when test="${tempStudent.goldCustomer}">
							Special Discount
						</c:when>
	
						<c:otherwise>
							No Discount. Showing with c:choose tag
						</c:otherwise>
					</c:choose>
				
				<!-- showing c:if tag -->
				<!--  	<c:if test = "${tempStudent.goldCustomer}">
						Special Discount
					</c:if>	
					<c:if test = "${not tempStudent.goldCustomer}">
						No Discount
					</c:if>		-->		
				</td>
			</tr>
		</c:forEach>
<!-- 
		<c:forEach items="${cookie}" var="currentCookie">

			 Reading Cookies with JSTL 
    		Cookie name as map entry key: ${currentCookie.key} <br />
   			Cookie object as map entry value: ${currentCookie.value} <br />
  			Name property of Cookie object: ${currentCookie.value.name} <br />
		    Value property of Cookie object: ${currentCookie.value.value} <br />
		</c:forEach>  -->
	</table>

</body>
</html>