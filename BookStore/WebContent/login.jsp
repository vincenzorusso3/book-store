<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>

	<% Boolean bad = (Boolean) request.getAttribute("denied");%> 
	<% if (bad != null) { %>
		<h1>ACCESS DENIED</h1>
		<h3>Please insert the correct login data </h3>
	<% } else %>
		<h1>Login</h1>
		
	<form method="post" action="index.html">
		<input type="text" name="usr" value="" placeholder="Username" required />
		<input type="password" name="psw" value="" placeholder="Password"
			required /> <input type="submit" value="Login" />
	</form>
</body>
</html>