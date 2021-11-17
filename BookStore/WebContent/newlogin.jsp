<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
      height: 200px;
      background: #aaa;
  }
  </style>
</head>
<body>


<div class="jumbotron text-center" style="margin-bottom:0">
  <h1><%=getServletContext().getAttribute("azienda") %></h1>
  <p><%=getServletContext().getAttribute("slogan") %></p> 
</div>

<%@ include file="navbar.jsp" %>


<div class="container">
  <div class="row">
  
  <% Boolean bad = (Boolean) request.getAttribute("denied");%> 
	<% if (bad != null) { %>
		<h1>Errore login</h1>
		<h3>Controlla le tue credenziali </h3>
	<% } else %>
		<h1>Login</h1>
		
	<form method="post" action="index.html">
		<input type="text" name="usr" value="" placeholder="Username" required />
		<input type="password" name="psw" value="" placeholder="Password"
			required /> <input type="submit" value="Login" />
	</form>
  </div>
</div>

<%@ include file="footer.jsp" %>


</body>
</html>
