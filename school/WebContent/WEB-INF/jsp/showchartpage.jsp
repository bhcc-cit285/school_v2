<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Cart</title>
		<link rel="stylesheet" href="">
	</head>
	<body>
		<form action="cart" method="post">
			<input type="hidden" name="source" value="remove">
			<input type="hidden" name="student" value="${student}">
			<input type="hidden" name="courses" value="${courses}">
			<input type="hidden" name="cart" value="${cart}">
			<div id="clear">
				<button type="submit" class="btn btn-primary btn-block">Clear cart</button>
			</div>
		</form>
		<form action="cart" method="post">
			<input type="hidden" name="source" value="">
			<div id = "button">
				<button type="submit" class="btn btn-primary btn-block">Back to courses list</button>
			</div>
		</form>
		<hr />
		<!-- Display Students -->
		<div id="studentslist" class="studentslist_format">
			<c:forEach items="${coursescart}" var="course">
				<br />
 				${course.getCourseDescription()}
 				<form action="cart" method="post">
					<input type="hidden" name="source" value="remove">
					<input type="hidden" name="student" value="${student}">
					<input type="hidden" name="course" value="${course}">
					<input type="hidden" name="courses" value="${courses}">
					<div id = "button">
						<button type="submit" class="btn btn-primary btn-block">remove</button>
					</div>
				</form>
			</c:forEach>
		</div>
	</body>
</html>