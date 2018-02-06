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
		<button><a href="/logout">Logout!</a></button>

		<h1>Welcome! ${currentUser.firstName}</h1>
		
		<div><h3>FirstName:</h3> <p>${currentUser.firstName}</p></div>
		<div><h3>LastName:</h3> <p>${currentUser.lastName}</p></div>
		<div><h3>Email:</h3> <p>${currentUser.email}</p></div>
		<div><h3>Sign up date:</h3> <p>${currentUser.createdAt}</p></div>
		<div><h3>Last Signed in:</h3> <p>${currentUser.updatedAt}</p></div>

	</body>
</html>