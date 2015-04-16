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
					<li><a href="add_constituent.jsp" target="main_page">Add</a></li>
					<form action="ViewConstituent" target="main_page" method="post">
						<input type="hidden" name="view" value="skmull02.constituent">
						<input type=submit value="View">
					</form>
				</ul>
			</li>
			
			<li>Member
				<ul class="sub">
					<li><a href="add_member.jsp" target="iframe1">Add</a></li>
					<form action="ViewConstituent"  method="post">
						<input type="hidden" name="view" value="skmull02.member">
						<input type=submit value="View">
					</form>
				</ul>
			</li>
			
			<li>Staff
				<ul class="sub">
					<li><a href="add_staff.jsp" target="iframe1">Add</a></li>
					<form action="ViewConstituent"  method="post">
						<input type="hidden" name="view" value="skmull02.staff">
						<input type=submit value="View">
					</form>
				</ul>
			</li>
			
			<li>Board Member
				<ul class="sub">
					<li><a href="add_board.jsp" target="iframe1">Add</a></li>
					<form action="ViewConstituent"  method="post">
						<input type="hidden" name="view" value="skmull02.board">
						<input type=submit value="View">
					</form>
				</ul>
			</li>
			
			<li>Donor
				<ul class="sub">
					<li><a href="add_donor.jsp" target="iframe1">Add</a></li>
					<form action="ViewConstituent"  method="post">
						<input type="hidden" name="view" value="skmull02.donor">
						<input type=submit value="View">
					</form>
				</ul>
			</li>
			
			
			<li>Agency
				<ul class="sub">
					<li><a href="add_agency.jsp" target="iframe1">Add</a></li>
					<form action="ViewConstituent"  method="post">
						<input type="hidden" name="view" value="skmull02.partner">
						<input type=submit id="button_link" value="View" >
					</form>
				</ul>
			</li>
			
			<li>
				<a href="search.jsp" target="iframe1">Search</a>
			</li>
			
		</ul>
	</nav>
	


</body>
</html>