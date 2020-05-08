<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
	<title><h1>Nic Fit</h1></title>
</head>
	
<body background = "exploer.png">>
<h1>Nic Fit</h1>

	
	<input type="button" value="Add Card" 
				   onclick="window.location.href='add-nicfit.jsp'; return false;"
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
		
		<c:forEach var="tempNicFit" items="${nicfit_list}">
		
		<c:url var="tempLink" value="NicFitServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="NicFitID" value="${tempNicFit.id}"/>
		</c:url>
		<c:url var="deleteLink" value="NicFitServlet">
						<c:param name="command" value="DELETE"/>
						<c:param name="NicFitID" value="${tempNicFit.id}"/>
		</c:url>
		
			<tr style="background-color: white;">
				<td><b>${tempNicFit.name}</b></td>
				<td><b>${tempNicFit.type}</b></td>
				<td><b>${tempNicFit.quantity}</b></td>
				<td><b>${tempNicFit.cost}</b></td>
				<td><b>${tempNicFit.cardSet}</b></td>
				<td><a href="${tempNicFit}">Update</a> | <a  href="${tempNicFit}" onclick="if(!(confirm('Are you sure you want to delete this row?')))return false">Delete</a></td>
			</tr>
		</c:forEach>
				

	</table>

	<p>
			<a href="AlurenServlet"><b>Aluren</b></a>
	</p>
	<p>
			<a href="PainterServlet"><b>Painter</b></a>
	</p>
	<p>
	<a href="HomePage.html">Home</a>
	</p>

	
		
</body>