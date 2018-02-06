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
		<h2><a href="/languages/delete/${id}">Delete</a></h2>
		<h2><a href="/languages">Dashboard</a></h2>
	
		<form:form action="/languages/update/${id}" method="post" modelAttribute="language">
			<form:label path="name">Name
				<form:errors path="name"/>
				<form:input path="name" value="${language.name}"/>
			</form:label>
			
			<form:label path="creator">Creator
				<form:errors path="creator"/>
				<form:input path="creator" value="${language.creator}"/>
			</form:label>
			
			<form:label path="version">Version
				<form:errors path="version"/>
				<form:input path="version" value="${language.version}"/>
			</form:label>
			
			<input type="submit"></input>
		</form:form>
	</body>
</html>