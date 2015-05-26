<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String which_table = request.getParameter("add_type");
String jsp_include = "/ListConstituent?" + which_table;
System.out.println(jsp_include);
%>
<jsp:include page="<%=jsp_include %>" ></jsp:include>
</body>
</html>