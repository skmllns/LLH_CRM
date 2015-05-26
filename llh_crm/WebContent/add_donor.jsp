<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Donor</title>
</head>
<body>
<h2> Add donor </h2>
<%
    String message = " ";
    Object get_message = request.getAttribute("member_id");
    if (get_message != null)
    {
    	System.out.println("message not null!");
        message = get_message.toString();
    }
    else
    {
    	System.out.println("message was null");
    }

%>
<form action = "AddDonor" id="add_donor">
	<input type = "hidden" name="member_id" value=<%=message %>>
	<input name="fund" type="text" placeholder="Fund">
	<select name="don_type">
			<option value="monetary">Monetary</option>
			<option value="in-kind">In-kind</option>
		</select>
	<input name="don_amt" type="text" placeholder="Donation amount"> <!-- standardize this -->
	<input name="don_date" type="text" placeholder="Donation date"> <!-- standardize this -->

	<input type=submit value="Submit">
</form>
</body>
</html>