<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Register here..</h2>
	<form action="updateReg" method="post">
		<pre>
		    <input type="hidden" name="id" value="${employee.id}"/>
			First Name <input type="text" name="firstName" value="${employee.firstName}"/>
			Last Name <input type="text" name="lastName" value="${employee.lastName}"/>
			Email Id <input type="text" name="email" value="${employee.email}"/>
			Mobile <input type="text" name="mobile" value="${employee.mobile}"/>
			<input type="submit" value="update"/>
		</pre>
	</form>
</body>
</html>