<html>
<head><title></title></head>
<body>
	<h3>Training Portal</h3>
	
	
	<!-- read the favorite programming language cookie -->
	<%
		//the default .. if there are no cookies
		String favLang = "Java";
	
	//find our favorite language cookie
	Cookie[] theCookies = request.getCookies();
	if(theCookies != null){
		for(Cookie temp : theCookies){
			if("myApp.favoriteLanguage".equals(temp.getName())){
				favLang = temp.getValue();
			}
		}
	}
	%>
	
	
	<!--  now show a personalized page.... use "favLange" variable -->
	
	
	<!-- show new books for this language -->
	<h4>New Books for <%=favLang %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>		
		</ul>
	
	
	<h4>Latest News Report for <%=favLang %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>		
		</ul>
		
	
	<h4>Hot Jobs for <%=favLang %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>		
		</ul>
	
	<hr>
	<a href="cookies-personalized-form.html">Personalize this page</a>
	
	
	
	
</body>


</html>