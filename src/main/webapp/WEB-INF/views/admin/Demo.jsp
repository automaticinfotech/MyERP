<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Management</title>
</head>
<body>
<h1>${message}</h1>
<form:form action="create" method="post" commandName="userMasterDto">
	Login ID: <form:input path=""/>
	password: <form:input path=""/>
	E-mail: <form:input path=""/>
	Is Active: <form:checkbox path="isActive" value="isActive"/>
	Is Admin: <form:checkbox path="roles" value="isAdministrator"/>
	

<table>
	<tr>
		<th>Menu Name</th>
		<th>Create</th>
		<th>Read</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	<c:forEach items="${menuMasterList}" var="currentObject">
	<tr>
		<td><label>${currentObject.getMenuName()}</label></td> 
		<td><form:checkbox path="roles" value="${currentObject.getMenuName()}isCreate"/></td>
		<td><form:checkbox path="roles" value="${currentObject.getMenuName()}isSelect"/></td>
		<td><form:checkbox path="roles" value="${currentObject.getMenuName()}isUpdate"/></td>
		<td><form:checkbox path="roles" value="${currentObject.getMenuName()}isDelete"/></td>
	</tr>
	</c:forEach>
</table>
<input type="submit" value="Create User">
</form:form>
</body>
</html>