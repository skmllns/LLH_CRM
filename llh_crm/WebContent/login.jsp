<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="crm_style.css">
<title>Login Page</title>
</head>
<body>
<h1> Welcome to the LLH CRM System!</h1>
<br>
<h2> Please enter your login information below.</h2>
<br>
<form action = "UserValidation">
<table cellspacing = "6">
	<tr>
		<td>User name: </td>
		<td><input name = "user_name" type = "text"></td>
	</tr>
	<tr>
		<td>Password: </td>
		<td><input name = "password" type = "password"> </td>
	</tr>
	<tr>
		<td></td>
		<td><input type = "submit" value = "Login"></td>
	</tr>	


</table>

</form>
<%
    String message = " ";
    Object get_message = request.getAttribute("message");
    if (get_message != null)
    {
        message = get_message.toString();
    }

%>
<font color= "red"><%=message %></font>



</body>
</html>