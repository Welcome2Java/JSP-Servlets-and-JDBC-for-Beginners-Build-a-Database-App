<!DOCTYPE html>
<html>

	<head>
		<title>Add Card</title>
		
	</head>

	<body>
			<form action="PainterServlet" method="GET">
				<input type="hidden" name="command" value="ADD" />
				
				<table border="1">
					<tbody>
						<tr>
							<td><label><b>Name</b></label></td>
							<td><input type="text" name="name"/></td>
						</tr>
						<tr>
							<td><label>Type</label></td>
							<td><input type="text" name="type"/></td>
						</tr>
						<tr>
							<td><label>Quantity</label></td>
							<td><input type="text" name="quantity"/></td>
						</tr>
						<tr>
							<td><label>Cost</label></td>
							<td><input type="number" name="cost"/></td>
						</tr>
						<tr>
							<td><label>Set</label></td>
							<td><input type="text" name="cardSet"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" name="Save" class="save"/></td>
						</tr>
					</tbody>
				</table> 
		 
		 	</form>
	</body>
</html>