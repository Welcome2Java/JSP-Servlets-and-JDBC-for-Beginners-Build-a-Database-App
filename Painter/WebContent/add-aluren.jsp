<!DOCTYPE html>
<html>

	<head>
		<title>Add Card</title>
		
	</head>

	<body>
			<form action="AlurenServlet" method="GET">
				<input type="hidden" name="command" value="ADD_ALuren" />
				
				<table border="1">
					<tbody>
						<tr>
							<td><label><b>NameAluren</b></label></td>
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
							<td><input type="text" name="cost"/></td>
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