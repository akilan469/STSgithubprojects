<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
You are now logged in ${name}!!!

<table>
<tr>
<td><a href="registerEmployee">Register Employee</a></td> 
<td><a href="showEmployee">Show Employee</a></td>
<td><a href="deleteEmployee">Delete Employee</a></td>
<td><a href="updateEmployee">Update Employee</a></td>
<td><a href="listEmployee">Show all Employee</a></td>
</tr>
</table>
<c:if test="${not empty reg }">

<h1>Registration Form</h1>
<form:form modelAttribute="employee" action="employeeRegister" method="post">
ID:<form:input path="id"/><form:errors path="id"/><br>

Name:<form:input path="name"/><form:errors path="name"></form:errors><br>

Salary:<form:input path="salary"/><form:errors path="salary"></form:errors><br>

Desg:<form:select path="desg" items="${list}">

</form:select>

<form:errors path="desg"></form:errors><br>

<input type="submit" value="SUBMIT">
</form:form>
</c:if>

<c:if test="${not empty success}">
!!!!!!!!!!!!     SUCCESS      !!!!!!!!!!<br>
<table>
<tr><td>ID</td><td>Name</td><td>Salary</td><td>Designation</td></tr>
<tr><td>${emp.id}</td><td> ${emp.name}</td><td> ${emp.salary}</td><td> ${emp.desg}</td></tr>

</table>
</c:if>

<c:if test="${not empty searchForm }">
<h1>SEARCH THE EMPLOYEE</h1>
<form action="searchEmployee">
ENTER EMPLOYEE ID
<input type="text" name="id">
<input type="submit" value="submit">
</c:if>
</body>
</html>