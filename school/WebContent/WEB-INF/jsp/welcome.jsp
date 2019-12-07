<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Welcome</title>
		<link rel="stylesheet" href="WEB-INF/css/welcome.css">
	</head>
	<body>
		<form action="school" method="post">
			<input type="hidden" name="source" value="admin">
			<div id="getcourses">
				<button type="submit" class="btn btn-primary btn-block">Admin</button>
			</div>
		</form>
		<form action="school" method="post">
			<input type="hidden" name="source" value="student">
			<div id="getcourses">
				<button type="submit" class="btn btn-primary btn-block">Student</button>
			</div>
		</form>
		<hr />
	</body>
</html>