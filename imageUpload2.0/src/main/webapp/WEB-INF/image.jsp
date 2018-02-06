<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="x-ua-compatible" content="ie=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/src/css/font-awesome.min.css">
		<link rel="stylesheet" href="/src/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="/src/css/bootstrap.css">
		<link rel="stylesheet" href="/src/css/style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="/js/main.js"></script>
	</head>
<body>
			<div class="modal-body">
			<form:form method="post" action="/create" enctype="multipart/form-data" modelAttribute="image">
			<div class="form-group">
				<label class="text-secondary">Post:</label>
				<form:textarea path="post" name="post" class="form-control"  rows="3" placeholder="Post goes here"></form:textarea>
			</div>
			
			<div class="form-group">
				<label for="file" class="text-secondary">Only image:(Optional)</label>
				<input type="file" name="file" class="form-control">
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" modal-dismiss="modal">Close</button>
				<input type="submit" class="btn btn-primary" value="Post"/>
			</div>
			</form:form>
			</div>
			
			<c:forEach items="${images}" var="image">
						<p>"${image.post}</p>
						<p>${image.getPicture()}</p>
 						<img src="/images/${image.getPicture()}" width="50" height="50"/>
			</c:forEach>




</body>