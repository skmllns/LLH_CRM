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
				<ul>
					<li><a href="add_constituent.jsp" target="welcome">Add</a></li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.constituent">
						<input type=submit id="button_link" value="View">
					</form>
				</ul>
			</li>
			
			<li>Member
				<ul>
					<li><a href="add_member.jsp" target="iframe1">Add</a></li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.member">
						<input type=submit id="button_link" value="View">
					</form>
				</ul>
			</li>
			
			<li>Staff
				<ul>
					<li><a href="add_staff.jsp" target="iframe1">Add</a></li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.staff">
						<input type=submit  id="button_link" value="View">
					</form>
				</ul>
			</li>
			
			<li>Board Member
				<ul>
					<li><a href="add_board.jsp" target="iframe1">Add</a></li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.board">
						<input type=submit id="button_link"value="View">
					</form>
				</ul>
			</li>
			
			<li>Donor
				<ul>
					<li><a href="add_donor.jsp" target="iframe1">Add</a></li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.donor">
						<input type=submit id="button_link" value="View">
					</form>
				</ul>
			</li>
			
			
			<li>Agency
				<ul>
					<li><a href="add_agency.jsp" target="iframe1">Add</a></li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.partner">
						<input type=submit id="button_link" value="View" >
					</form>
				</ul>
			</li>
			
			<li>
				<a href="search.jsp" target="welcome">Search</a>
			</li>
			
		</ul>
	</nav>


</body>
</html>