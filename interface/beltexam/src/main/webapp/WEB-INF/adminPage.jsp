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
	<header>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout!" />
	</form>
	<h1>Admin Dashboard</h1>
	</header>

	<div class="top_section">
		<h3>Customers</h3>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Next Due Date</th>
				<th>Amoutn Due</th>
				<th>Package Type</th>
			</tr>

			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.firstName} ${customer.lastName}</td>
					<td>${customer.updatedAt}</td>
					<td>$${customer.product.cost}</td>
					<td>${customer.product.name}</td>
				</tr>
				
			</c:forEach>
		</table>
	</div>
	<!-- closing top -->

	<div class="middle_section">
		<h3>Packages</h3>
		<table border=1>
			<tr>
				<th>Name</th>
				<th>Package Cost</th>
				<th>Availabe</th>
				<th>USers</th>
				<th>Action</th>
			</tr>

			<c:forEach var="product" items="${products}">
				<tr>
					<td><c:out value="${product.name}" /></td>
					<td>$<c:out value="${product.cost}" /></td>
					<c:choose>
						    <c:when test="${product.isActivate() == true}">
						      <td>available</td>
						    </c:when>    
						    <c:otherwise>
						    	<td>unavailable</td>
						    </c:otherwise>
						</c:choose>
					<td>${product.getCounter()}</td>
					<td>
						<c:choose>
						    <c:when test="${product.isActivate() == true}">
						       <a href="/activation/${product.id}">deactivate</a>
						    </c:when>    
						    <c:otherwise>
						    	<a href="/activation/${product.id}">activate</a>
						    </c:otherwise>
						</c:choose>
						
						<c:if test = "${product.getCounter() < 1}">
							<a href="/delete/product/${product.id}">delete</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="middle_right">
		<form action="/create/package" method="POST">
			<label>Package Name:</label><input type="text" name="packageName"/>
			<label>Cost:</label><input type="text" name="cost"/>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
			<input type="submit" value="Create new Package" />
		</form>
	</div>

</body>
</html>