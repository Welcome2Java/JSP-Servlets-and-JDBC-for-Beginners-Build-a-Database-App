<%@ page import="java.util.*"%>
<html>
<body>
	<!-- Step 1 create html form-->
	<form action="todo-demo.jsp">
		Add new item: <input type="text" name="theItem" /> <input
			type="submit" value="Submit" />
	</form>

	<!-- Step 2 add new item to the list -->
	<%
		//get the to do items from the sessions
		List<String> items = (List<String>) session.getAttribute("myToDoList");
		//if the to do items doesn't exist then create a new one
		if (items == null) {
			items = new ArrayList<String>();
			session.setAttribute("myToDoList", items); //adds list to the session
		}
		// see if there is form data to add
		String theItem = request.getParameter("theItem");
		if (theItem != null) {
			items.add(theItem);
		}
	%>
	<!-- Step 3 display all items for the list in this session -->
	<br> To Do List Items
	</br>
	<ol>
		<!-- ordered list -->
		<%
			for (String temp : items) {
				out.println("<li>" + temp + "</li>");
			}
		%>
	</ol>
</body>
</html>