<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title><h1>Strawberry Shortcake</h1></title>
</head>
	
<body background = "Painter MasterPiece.jpg">>
<h1>Strawberry Shortcake</h1>

	<div style="position:absolute;top:10px;right:10px; z-index:999" >
	<input type="button" value="Add Card" 
				   onclick="window.location.href='add-card-form.jsp'; return false;"
				   class="add-card-button">
	</div>
	<table border="1" cellpadding="10" bordercolor="Black">

		<tr style="background-color: white;">
			<th>Name</th>
			<th>Type</th>
			<th>Quantity</th>
			<th>Cost</th>
			<th>Description</th>
			<th>Set</th>
		</tr>
		
		<c:forEach var="tempPainter" items="${painter_List}">
			<tr style="background-color: white;">
				<td><b>${tempPainter.name}</b></td>
				<td><b>${tempPainter.type}</b></td>
				<td><b>${tempPainter.quantity}</b></td>
				<td><b>${tempPainter.cost}</b></td>
				<td><b>${tempPainter.desciption}</b></td>
				<td><b>${tempPainter.set}</b></td>
			</tr>
		</c:forEach>
				

	</table>
		
</body>