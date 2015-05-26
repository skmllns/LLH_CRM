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
					<li>
						<form action="list_constituent.jsp" target="welcome">
							<input type="hidden" name="add_type" value="member">
							<input type=submit id="button_link" value="Add">
						</form>
					</li>
					<li>
						<form action="view_constituent.jsp" target="welcome">
							<input type="hidden" name="view" value="skmull02.member">
							<input type=submit id="button_link" value="View">
						</form>
					</li>
				</ul>
			</li>
			z
			<li>Staff
				<ul>
					<li>
						<form action="list_constituent.jsp" target="welcome">
							<input type="hidden" name="add_type" value="staff">
							<input type=submit id="button_link" value="Add">
						</form>
					</li>
					<li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.staff">
						<input type=submit  id="button_link" value="View">
					</form>
					</li>
				</ul>
			</li>
			
			<li>Board Member
				<ul>
					<li>
						<form action="list_constituent.jsp" target="welcome">
							<input type="hidden" name="add_type" value="board">
							<input type=submit id="button_link" value="Add">
						</form>
					</li>
					<li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.board">
						<input type=submit id="button_link"value="View">
					</form>
					</li>
				</ul>
			</li>
			
			<li>Donor
				<ul>
					<li>
						<form action="list_constituent.jsp" target="welcome">
							<input type="hidden" name="add_type" value="donor">
							<input type=submit id="button_link" value="Add">
						</form>
					</li>
					<li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.donor">
						<input type=submit id="button_link" value="View">
					</form>
					</li>
				</ul>
			</li>
			
			
			<li>Agency
				<ul>
					<li>
						<form action="list_constituent.jsp" target="welcome">
							<input type="hidden" name="add_type" value="agency">
							<input type=submit id="button_link" value="Add">
						</form>
					</li>
					<li>
					<form action="view_constituent.jsp" target="welcome">
						<input type="hidden" name="view" value="skmull02.partner">
						<input type=submit id="button_link" value="View" >
					</form>
					</li>
				</ul>
			</li>
			
			<li>
				<a href="search.jsp" target="welcome">Search</a>
			</li>
			
		</ul>
	</nav>


</body>
</html>