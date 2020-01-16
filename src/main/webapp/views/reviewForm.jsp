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
	<h2>PassportApplicationFormReview</h2>
	<form:form action="submitReviewForm" method="POST" modelAttribute="passport">
		<form:hidden path="personId" />

		<h4><u>Person Details</u></h4>
		<table>
			<tr>
				<td>FirstName</td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td>LastName</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>DateOfBirth</td>
				<td><form:input path="dob" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td>AdhaarNo</td>
				<td><form:input path="adhaarNo" /></td>
			</tr>
		</table>
		<h4><u>Education details</u></h4>
		<table>
			<tr>
				<td>Highest Degree</td>
				<td><form:input path="highdegree" /></td>
			</tr>
			<tr>
				<td>University</td>
				<td><form:input path="university" /></td>
			</tr>
			<tr>
				<td>PassedOutYear</td>
				<td><form:input path="passedyear" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>