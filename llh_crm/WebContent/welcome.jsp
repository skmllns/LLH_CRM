<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='style.css'>
<title>Insert title here</title>
</head>
<body>
<%
    String message = " ";
    Object get_message = request.getAttribute("message");
    if (get_message != null)
    {
        message = get_message.toString();
    }

%>
<font color= "blue"><%=message %></font>
<h2> Instructions </h2>

<ul>
	<li>Add</li>
		<ul>
			<li>Main constituent</li>
			<ul>
				<li> Click "Add" option under "Constituent" heading </li>
				<li> Add information </li>
			</ul>
		</ul>
		<ul>
			<li> Sub-category (member, staff, etc.)</li>
			<ul>
				<li> Click "Add" under appropriate heading </li>
				<li> Choose relevant constituent </li>
				<li> Add information </li>
			</ul>
		</ul>
	<li>View</li>
		<ul>
			<li> Click "View" under appropriate heading </li>
		</ul>
	
<!-- 	<li>Edit</li>
		<ul>
			<li> Click "Edit" under appropriate heading </li>
			<li> Select relevant constituent </li>
			<li> Edit and save information </li>
		</ul> -->
</ul>

</body>
</html>