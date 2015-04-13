<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="crm_style.css">
<title>Add Staff</title>
</head>
<body>
<h2> Add staff </h2>

<form action = "AddConstituent" id="add_staff">
	<!-- how to do staff code? -->
	<input name="ao_interest" type="text" placeholder="Area of interest">
	<input name="skill" type="text" placeholder="Skill"> <!-- how to do multiple skills? -->		
	<input name="date_active" type="text" placeholder="Date active">
	<!-- staff code & title -->
	
	<input type=submit value="Submit">
</form>
</body>
</html>