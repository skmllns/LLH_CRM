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
		<select name="const_type">
			<option value="person">Person</option>
			<option value="organization">Organization</option>
		</select>
		<input name = "address" type = "text" placeholder = "Address">
		<input name = "city" type = "text" placeholder = "City">
		<select name="state">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="DC">District Of Columbia</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH">Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select>
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