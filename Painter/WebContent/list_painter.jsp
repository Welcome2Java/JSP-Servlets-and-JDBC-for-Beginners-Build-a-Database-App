<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title><h1>Strawberry Shortcake</h1></title>
</head>
	
<body background = "Painter MasterPiece.jpg">>
<h1>Strawberry Shortcake</h1>

	
	<input type="button" value="Add Card" 
				   onclick="window.location.href='add-card-form.jsp'; return false;"
				   class="add-card-button">
	<table border="1" cellpadding="10" bordercolor="Black">

		<tr style="background-color: white;">
			<th>Name</th>
			<th>Type</th>
			<th>Quantity</th>
			<th>Cost</th>
			<th>Set</th>
			<th>Action</th>
		</tr>
		
		<c:forEach var="tempPainter" items="${painter_List}">
		
		<c:url var="tempLink" value="PainterServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="painterID" value="${tempPainter.id}"/>
		</c:url>
		<c:url var="deleteLink" value="PainterServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="painterID" value="${tempPainter.id}"/>
		</c:url>
		
			<tr style="background-color: white;">
				<td><b>${tempPainter.name}</b></td>
				<td><b>${tempPainter.type}</b></td>
				<td><b>${tempPainter.quantity}</b></td>
				<td><b>${tempPainter.cost}</b></td>
				<td><b>${tempPainter.cardSet}</b></td>
				<td><a href="${tempLink}">Update</a> | <a  href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this row?')))return false">Delete</a></td>
			</tr>
		</c:forEach>
				

	</table>
		
</body>