<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Languages</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<c:forEach items="${errs}" var="err">
			<h2><c:out value="${err.getDefaultMessage()}"/></h2>
		</c:forEach>
	
		<table>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			
			<c:forEach items="${languages}" var="language" varStatus="loop">
				<tr>
					<td><a href="languages/show/${loop.index}"><c:out value="${language.name}"></c:out></a></td>
					<td><c:out value="${language.creator}"></c:out></td>
					<td><c:out value="${language.version}"></c:out></td>
					<td><a href="languages/delete/${loop.index}">Delete</a> <a href="languages/edit/${loop.index}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	
		<form:form action="languages/new" method="post" modelAttribute="language">
			<form:label path="name">Name
				<form:errors path="name"/>
				<form:input path="name"/>
			</form:label>
			
			<form:label path="creator">Creator
				<form:errors path="creator"/>
				<form:input path="creator"/>
			</form:label>
			
			<form:label path="version">Version
				<form:errors path="version"/>
				<form:input path="version"/>
			</form:label>
			
			<input type="submit"></input>
		</form:form>
	</body>
</html>