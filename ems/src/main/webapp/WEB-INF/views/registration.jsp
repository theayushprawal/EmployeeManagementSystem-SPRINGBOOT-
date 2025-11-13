<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<h2>Register here......</h2>
	<form action="saveReg" method="post">
		<pre>
			First Name <input type="text" name="firstName"/>
			Last Name <input type="text" name="lastName"/>
			Email Id <input type="text" name="email"/>
			Mobile <input type="text" name="mobile"/>
			City <input type="text" name="city"/>
			State <input type="text" name="state"/>
			Pincode <input type="text" name="pinCode"/>
			Address Line <input type="text" name="addressLine"/>
			<input type="submit" value="save"/>
		</pre>
	</form>
	${msg}
</body>
</html>