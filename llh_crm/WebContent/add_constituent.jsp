<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Constituent</title>
</head>
<body>
<h2> Add constituent </h2>
	<form action = "AddConstituent" target="welcome" id="add_const">
		<input name = "first_name" type = "text" placeholder = "First Name">
		<input name = "last_name" type = "text" placeholder = "Last Name">
		<input name = "const_type" type = "text" placeholder = "Constituent Type"> <!--  change to drop down -->
		<input name = "address" type = "text" placeholder = "Address">
		<input name = "city" type = "text" placeholder = "City">
		<input name = "state" type = "text" placeholder = "State"> <!--  change to drop down -->
		<input name = "zip_code" type = "text" placeholder = "Zip Code">
		<input name = "country" type = "text" placeholder = "Country"> <!--  change to drop down -->
		<input name = "neighborhood" type = "text" placeholder = "Neighborhood (if Louisville)">   <!--  change to drop down --> 
		<input name = "email" type="text" placeholder="Email address">
		<input name = "phone_num" type = "text" placeholder = "Phone Number"> <!--  standardize this-->
		<input name = "refer_method" type = "text" placeholder = "Referral Method"> <!--  change to drop down -->
		<br>
		<textarea rows="4" cols="50" name="comments" form="add_const" placeholder = "Comments"></textarea>
		<br>
		<br>
		<input type=submit value="Submit">
	</form>
</body>
</html>