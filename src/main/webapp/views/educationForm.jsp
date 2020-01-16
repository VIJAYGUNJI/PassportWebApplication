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
	<h2>Education Details Form</h2>
	<form:form action="submitEduForm" method="POST"  modelAttribute="education">
		<form:hidden path="personId" />
		<table>
			<tr>
				<td>HighestDegree</td>
				<td><form:select path="highdegree">
						<form:option value="">--select degree--</form:option>
						<form:options items="${degrees}" />
					</form:select></td>
			</tr>
			<tr>
				<td>University</td>
				<td><form:select path="university">
						<form:option value="">--select Universities</form:option>
						<form:options items="${universities}" />
					</form:select></td>
			</tr>
			<tr>
				<td>PassedOutYear</td>
				<td><form:select path="passedyear">
						<form:option value="">--select passed out year</form:option>
						<form:options items="${years}" />
					</form:select></td>
			</tr>
			<tr>
				<td><a href="/getPersonDataById?personId=${education.personId}">Previous</a></td>
				<td><input type="submit" value="Next"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>