<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Counter</title>
</head>
<body>
	<h2>You have visited <a href="/">http://localhost:8080/ </a><c:out value="${count}"/> time(s).</h2>
	<h2><a href="/">Test another visit?</a></h2>
	<h2><a href="/reset">Reset Visits</a></h2>
	<h2><a href="/countertwo">Double Views</a></h2>
</body>
</html>