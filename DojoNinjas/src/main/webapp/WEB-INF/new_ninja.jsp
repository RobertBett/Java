<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Ninja</title>
</head>
<body>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<form:label path="dojo">Dojo:
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="dojo"></form:errors>
		</form:label>
		
		<form:label path="firstName">First Name:
			<form:input path="firstName"></form:input>
			<form:errors path="firstName"></form:errors>	
		</form:label>
		
		<form:label path="lastName">Last Name:
			<form:input path="lastName"></form:input>
			<form:errors path="lastName"></form:errors>	
		</form:label>
		
		<form:label path="age">Age:
			<form:input type="number" path="age"></form:input>
			<form:errors path="age"></form:errors>	
		</form:label>
		
		<input type="submit" value="Create"></input>
	</form:form>
</body>
</html>