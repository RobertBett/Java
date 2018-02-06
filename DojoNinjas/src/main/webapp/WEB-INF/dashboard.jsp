<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<h1>Information</h1>
	<button><a href="/dojos/new">Create Dojo</a></button>
	<button><a href="/ninjas/new">Create Dojo</a></button>
	<table>
		<tr>
			<th><h2>Dojo Name</h2></th>
			<th><h2>Ninja Count</h2></th>
		</tr>
		
		<c:forEach items="${dojos}" var="dojo">
			<tr>
				<td><h3><c:out value="${dojo.name}"/></h3></td>
				<td><h3><c:out value="${dojo.countNinjas()}"/></h3></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>