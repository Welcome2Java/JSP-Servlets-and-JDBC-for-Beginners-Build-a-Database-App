<html>	
	<head></head>
<body>
	<h3>Favorite MTG format</h3>
	
	<!-- read the cookie -->
	<%
		String favType = "Standard";
	
		Cookie[] theCookies = request.getCookies();
		if(theCookies != null){
			for(Cookie tmp: theCookies){
				if("myApp.favoriteFormat".equals(tmp.getName())){
					favType = tmp.getValue();
				}
			}
		}
	
	%>
	
	<h4>New Cards for <%=favType %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>		
		</ul>
	
	
	<h4>Latest News Report for <%=favType %></h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>		
		</ul>
		
	
	<h4>Hottest decks to play in this <%=favType %> </h4>
		<ul>
			<li>blah blah blah</li>
			<li>blah blah blah</li>		
		</ul>
	
	<hr>
	<a href="personalized-format-type.html">Personalize this page</a>
</body>




</html>


