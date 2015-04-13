<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="crm_style.css">
<title>Add Donor</title>
</head>
<body>
<h2> Add donor </h2>

<form action = "AddConstituent" id="add_donor">
	<input name="fund" type="text" placeholder="Fund">
	<input name="don_type" type="text" placeholder="Donation type"> <!-- drop down -->
	<input name="don_amt" type="text" placeholder="Donation amount"> <!-- standardize this -->
	<input name="don_date" type="text" placeholder="Donation date"> <!-- standardize this -->

	<input type=submit value="Submit">
</form>
</body>
</html>