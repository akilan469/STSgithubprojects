<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>A
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Desg</th>
			<th>Salary</th>
		</tr>
		<c:forEach items="${empList}" var="e">
			<tr>
				<td><c:out value="${e.id}"></c:out></td>
				<td><c:out value="${e.name}"></c:out></td>
				<td><c:out value="${e.desg}"></c:out></td>
				<td><c:out value="${e.salary}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>