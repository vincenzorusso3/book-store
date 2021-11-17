<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page import="Model.*"%>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>Il tuo profilo</title>
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
	<% 
    		UserBean user = (UserBean) request.getSession().getAttribute("userBean");
    		CounterBean count = (CounterBean) request.getAttribute("countBean");
    %>

	<h2>
		Ciao
		<%if(user!=null){ %>
		<%= user.getNome()%>
		<%= user.getCognome()%>
	</h2>
	<br />
	<h2>I libri nel tuo carrello:</h2>
	<%@ include file="viewcart.jsp" %>
	
	
	<h3>
		<a href='index.html'>Accedi di nuovo alla pagina</a> o <a
			href='ServletLogout'>Logout</a><br>
			<a href='newselfupdateuser.jsp'>Aggiorna profilo</a><br>
			<form action="ServletSelfUserDelete">
			 	<input type="hidden" name="user" value=<%=user.getUsr()%>>
 				<input type="submit" value="Elimina il tuo account">
			</form>
			
					<%} %>
			
	</h3>
  </div>
</div>

<%@ include file="footer.jsp" %>

</body>
</html>
