<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Passport Dashboard</h1>
	<font size="5" color="green">${successMsg}</font>
	<font size="5" color="red">${errorMsg}</font><br>
	Your Passport Number::<b>${passportNum}</b><br>
	Thank You!!!
</body>
</html>