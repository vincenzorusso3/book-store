<!DOCTYPE html>
<html>
<head>
<title>EXCEPTION</title>
</head>
<body>
	<h1>EXCEPTION</h1>

	OOPS!! Qualcosa è andato storto
	<br />
	<br /> 
	<% Exception e = (Exception) request.getAttribute("exception");%>
	<%= e.toString()%>

	<a href='index.html'>HOME</a>
</body>
</html>