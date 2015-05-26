<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Vendor</title>
</head>
<body>
<h2> Add vendor </h2>
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

<form action = "AddVendor" id="add_vendor">
	<input type = "hidden" name="member_id" value=<%=message %>>
	<input name="vendor_type" type="text" placeholder="Vendor type"> <!-- drop down -->
	<input name="vendor_product" type="text" placeholder="Vendor product">

	<input type=submit value="Submit">
</form>

</body>
</html>