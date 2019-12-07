<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="admin" method="post">
		<input type="hidden" name="source" value="courseadd">
		<div id="courseregister">
			<button type="submit" class="btn btn-primary btn-block">Register course</button>
		</div>
	</form>
	<form action="admin" method="post">
		<input type="hidden" name="source" value="studentadd">
		<div id="coursesview">
			<button type="submit" class="btn btn-primary btn-block">Register Students</button>
		</div>
	</form>
	<hr />
</body>
</html>