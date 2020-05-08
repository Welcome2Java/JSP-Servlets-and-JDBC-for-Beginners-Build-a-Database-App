<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title><h1>Aluren</h1></title>
</head>
	
<body background = "Aluren.jpg">>
<h1>Aluren</h1>

	
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
		
		<c:forEach var="tempAluren" items="${aluren_list}">
		
		<c:url var="tempLink" value="AlurenServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="AlurenID" value="${tempAluren.id}"/>
		</c:url>
		<c:url var="deleteLink" value="PainterServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="painterID" value="${tempAluren.id}"/>
		</c:url>
		
			<tr style="background-color: white;">
				<td><b>${tempAluren.name}</b></td>
				<td><b>${tempAluren.type}</b></td>
				<td><b>${tempAluren.quantity}</b></td>
				<td><b>${tempAluren.cost}</b></td>
				<td><b>${tempAluren.cardSet}</b></td>
				<td><a href="${tempAluren}">Update</a> | <a  href="${tempAluren}" onclick="if(!(confirm('Are you sure you want to delete this row?')))return false">Delete</a></td>
			</tr>
		</c:forEach>
				

	</table>
	
	<p>
			<a href="NicFitServlet"><b>Nic Fit</b></a>
	</p>
	
	<p>
			<a href="PainterServlet"><b>Painter</b></a>
	</p>
		
</body>