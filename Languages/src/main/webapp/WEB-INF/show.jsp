<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>Show Language</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	
	<body>
		<a href="/languages"><h2>Dashboard</h2></a>
	
		<h2> <c:out value="${language.name}"/> </h2>
		<h2> <c:out value="${language.creator}"/> </h2>
		<h2> <c:out value="${language.version}"/> </h2>
		<h2><a href="/languages/edit/${id}">Edit</a></h2>
		<h2><a href="/languages/delete/${id}">Delete</a></h2>
	</body>
</html>