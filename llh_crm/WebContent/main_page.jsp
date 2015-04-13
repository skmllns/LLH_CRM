<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<head>
<title>LLH CRM System</title>
<link rel='stylesheet' type='text/css' href='style.css'>
</head>
<body>

	<h1>Welcome to the LLH CRM System!</h1>

	<nav>
		<ul>
			<li>Constituent
				<ul class="sub">
					<li><a href="add_constituent.jsp" target="iframe1">Add</a></li>
					<li><a href="ViewConstituent?view=constituent">View</a></li>
				</ul>
			</li>
			
			<li>Member
				<ul class="sub">
					<li>Add</li>
					<li><a href="ViewConstituent?view=member">View</a></li>
				</ul>
			</li>
			
			<li>Staff
				<ul class="sub">
					<li>Add</li>
					<li><a href="ViewConstituent?view=staff">View</a></li>
				</ul>
			</li>
			
			<li>Board Member
				<ul class="sub">
					<li>Add</li>
					<li><a href="ViewConstituent?view=board">View</a></li>
				</ul>
			</li>
			
			<li>Donor
				<ul class="sub">
					<li>Add</li>
					<li><a href="ViewConstituent?view=donor">View</a></li>
				</ul>
			</li>
			
			
			<li>Agency
				<ul class="sub">
					<li>Add</li>
					<li><a href="ViewConstituent?view=agency">View</a></li>
				</ul>
			</li>
			
			<li>
				<a href="search.jsp" target="iframe1">Search</a>
			</li>
			
		</ul>
	</nav>
	
  	
  	<div align="bottom">
		<iframe id="iframe1" name="iframe1" src="welcome.jsp" frameBorder="0" width=100%>
		</iframe>
	</div>

</body>
</html>