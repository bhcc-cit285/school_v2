<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register course</title>
</head>
<body>
	<form action="admin" method="post">
		<input type="hidden" name="source" value="addcourse">
		
		<input type="text" class="" id="" name="courseid" placeholder="Course Id">
		<br />
		<input type="text" class="" id="" name="coursecode" placeholder="Course code">
		<br />
		<input type="text" class="" id="" name="coursetitle" placeholder="Title">
		<br />
		<input type="text" class="" id="" name="coursedescription" placeholder="Description">
		<br />
		<br />
		<div id="getcourses">
			<button type="submit" class="btn btn-primary btn-block">Register course</button>
		</div>
	</form>
</body>
</html>