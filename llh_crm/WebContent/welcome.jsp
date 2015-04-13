<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>


<%
String message = "";
Object get_message = request.getAttribute("result");
if (get_message != null)
{
    message = get_message.toString();
}

%>
<font color= "blue"><%=message %></font>
<br>
<br>
<br>
<h2>Instructions</h2>

<ul>
	<li>Choose a task from menu bar</li>
		<ul>
			<li>Edit</li>
				<ul>
					<li>Search for constituent by last name</li>
					<li>Select appropriate constituent</li>
					<li>Edit as necessary</li>
				</ul>
			<li>Add</li>
				<ul>
					<li>Enter new constituent information</li>
				</ul>
		</ul>
</ul>
			
</body>
</html>


 
 