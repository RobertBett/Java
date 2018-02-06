<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<form action="/logout" method="get">
			<input type="submit" value="logout">
		</form>
	
		<h1>Welcome <c:if test="${user.isAdmin()}"> "Regular Admin"</c:if>, <c:out value="${user.firstName}" /> </h1>
				<form:form method="post" action="/subs/new" modelAttribute="sub">
				<form:label path="name"> Name:
					<form:input path="name"></form:input>
					<form:errors path="name"></form:errors>
				</form:label>
				
				<form:label path="cost"> Cost:
					<form:input type="number" path="cost"></form:input>
				</form:label>
				
				<input type= "submit" value="Create Subscription">
		</form:form>
	</body>
</html>