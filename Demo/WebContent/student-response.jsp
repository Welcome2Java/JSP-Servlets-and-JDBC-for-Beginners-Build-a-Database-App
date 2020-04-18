
<html>
	<head><title>Student Confirmation Title</title></head>
	
	<body>
		The student is confirmed: <%= request.getParameter("firstName") %> ${param.lastName}
		<br/><br/>
		The student's country is: ${param.Country}
		<br/><br/>
		The student's gender is: ${param.Gender}
		<br/><br/>
		The student's favorite programming language is: ${param.favoriteLanguage}
		<br/><br/>
		
		The student has the education experience of: 
		<ul>
			<%
				String [] education = request.getParameterValues("education");
					
					if(education != null){
						for (String edu : education) {
							out.println("<li>" + edu + "</li>");
						}
					} else{
							out.println("<li>"+ "No higher education" +"</li>");
					}
			%>
		</ul>
		

	</body>
</html>