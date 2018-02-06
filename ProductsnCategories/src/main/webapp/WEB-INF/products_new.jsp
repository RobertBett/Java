<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>

	<form:form action="/products/new" method="post" modelAttribute="product">
		<form:label path="name">Name:
			<form:input path="name"></form:input>
			<form:errors path="name"></form:errors>		
		</form:label>

		<form:label path="description">Description:
			<form:input path="description"></form:input>
			<form:errors path="description"></form:errors>		
		</form:label>

		<form:label path="price">Price:
			<form:input type="number" path="price"></form:input>
			<form:errors path="price"></form:errors>		
		</form:label>
		

		<input type="submit" value="Create"></input>
	</form:form>
</body>
</html>