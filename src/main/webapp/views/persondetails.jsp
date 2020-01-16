<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<h2>Person Details</h2>
	<img src="indian-passport.jpg">
	<body background="indian-passport.jpg">
	<form:form action="submitForm" method="POST" modelAttribute="person">
		<form:hidden path="personId" />
		<table align="center" border="2" rules="all" width="600" height="300">
			<tr>
				<td>FirstName</td>
				<td><form:input path="fname" />
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lname" />
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" />
			</tr>
			<tr>
				<td>DateOfBirth</td>
				<td><form:input type="date" path="dob" pattern="dd-mm-yyyy" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<%-- <form:input path="gender"/> --%> <form:radiobutton
						path="gender" value="m" />Male &nbsp;&nbsp; <form:radiobutton
						path="gender" value="f" />Female
				</td>
			</tr>
			<tr>
				<td>AdhaarNo</td>
				<td><form:input path="adhaarNo" />
			</tr>
		</table>
		<input align="center" type="submit" value="Submit'" />
	</form:form>
</body>
</html>