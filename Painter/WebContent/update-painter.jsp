<!DOCTYPE html>
<html>

<head>
	<title>Update Card</title>

</head>

<body>

		<h2>Painter</h2>

		<h3>Update Card</h3>
		
		<form action="PainterServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="painterID" value="${The_Painter.id}" />
			
			<table border="1">
					<tbody>
						<tr>
							<td><label><b>Name</b></label></td>
							<td><input type="text" name="name" value="${The_Painter.name}"/></td>
						</tr>
						<tr>
							<td><label>Type</label></td>
							<td><input type="text" name="type" value="${The_Painter.type}"/></td>
						</tr>
						<tr>
							<td><label>Quantity</label></td>
							<td><input type="text" name="quantity" value="${The_Painter.quantity}"/></td>
						</tr>
						<tr>
							<td><label>Cost</label></td>
							<td><input type="number" name="cost" value="${The_Painter.cost}"/></td>
						</tr>
						<tr>
							<td><label>Set</label></td>
							<td><input type="text" name="cardSet" value="${The_Painter.cardSet}"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" name="Save" class="save"/></td>
						</tr>
					</tbody>
				</table> 
		</form>
		

		
		<p>
			<a href="PainterServlet">Back to List</a>
		</p>
</body>

</html>
