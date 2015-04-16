<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Board Member</title>
</head>
<body>
<h2> Add board member </h2>

<form action = "AddConstituent" id="add_board">
	<input name="board_pos" type="text" placeholder="Board position">
	<input name="pos_start_date" type="text" placeholder="Position start date"> <!-- standardize this -->
	
	<input type=submit value="Submit">
</form>
		
</body>
</html>