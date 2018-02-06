<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    
<!DOCTYPE HTML>
<html>
<head>
	<title>Dashboard</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">
		<form id="logoutForm" method="POST" action="/logout">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<br>
			<input id="logout" class="btn btn-link" type="submit" value="Logout" />
		</form>
		<form:form method="post" action="/subs/${sub.id}/join" modelAttribute="sub">
		<form:label path="">Package:
			<form:select path="name">
				<c:forEach items="${subs}" var="subz">
					<form:option value="${subz.id}">${subz.name}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="name"></form:errors>
		</form:label>
		<input type= "submit" value="Signup">
		</form:form>
		
	
	</div>
</body>
</html>