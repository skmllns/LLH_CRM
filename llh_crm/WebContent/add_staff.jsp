<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Staff</title>
</head>
<body>
<h2> Add staff </h2>
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
<form action = "AddStaff" id="add_staff">
	<input type = "hidden" name="member_id" value=<%=message %>>
	<input name="ao_interest" type="text" placeholder="Area of interest">
	<input name="skill" type="text" placeholder="Skill"> <!-- how to do multiple skills? -->		
	<input name ="title" type="text" placeholder="Title">
	<input name="date_active" type="text" placeholder="Date active">
	<input name="staff_code" type="text" placeholder="Staff Code">
	
	<input type=submit value="Submit">
</form>
</body>
</html>