<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>View Registrations</h2>
	
	<table>
		<tr>
			<th>
				First name
			</th>
			<th>
				Last name
			</th>
			<th>
				Email
			</th>
			<th>
				Mobile
			</th>
			<th>
				Delete
			</th>
			<th>
				Update
			</th>
			
		</tr>
		
		<c:forEach var="emp" items="${employees}">
		<tr>
			<td>
				${emp.firstName}
			</td>
			<td>
				${emp.lastName}
			</td>
			<td>
				${emp.email}
			</td>
			<td>
				${emp.mobile}
			</td>
			<td>
				<a href="deleteEmployee?id=${emp.id}">delete</a>
			</td>
			<td>
				<a href="getEmployee?id=${emp.id}">update</a>
			</td>
			
		</tr>
		
		</c:forEach>
		
	
	</table>
</body>
</html>