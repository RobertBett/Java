<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h1> Welcome to Dojoscriptions <c:out value="${currentUser.firstName}"></c:out></h1>
	<p>Please choose a subscription and start date</p>
	

	<form  action="/signup/product" method="POST">
		<p>
	    <input type="number" name="duedate" min="1" max="31"/>
		</p>
		
		<div>
		
		<select  name="product_id">
			<c:forEach var="product" items="${products}">
			<option value="${product.id}" value="">${product.name} ($${product.cost})</option>
			</c:forEach>
			</select>
		</select>
		
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
		<input type="submit" value="Sign Up" />
	</form>

</body>
</html>