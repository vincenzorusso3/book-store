<%@ page import="Model.*"%>

<!DOCTYPE html>
<html>
<head>
<title>OUTPUT</title>
</head>
<body>
	<h1>OUTPUT</h1>
	<% 
    		UserBean user = (UserBean) request.getAttribute("userBean");
    		CounterBean count = (CounterBean) request.getAttribute("countBean");
    %>

	<h2>
		Ciao
		<%= user.getNome()%>
		<%= user.getCognome()%>
	</h2>
	<br />
	<br /> In questa applicazione ci sono stati i seguenti 
	accessi:
	<br /> A livello di questa SERVLET (solo ServletLogin):
	<%= count.getServletCount() %>
	<br /> A livello di SESSIONE:
	<%= count.getSessionCount() %>
	<br /> A livello di APPLICAZIONE (sia ServletLogin che ServletLogout):
	<%= count.getApplicationCount() %>
	<br />
	<h3>
		<a href='index.html'>Accedi di nuovo alla pagina</a> o <a
			href='ServletLogout'>Logout</a>
	</h3>
	
	<%@ include file="footer.jsp" %>
	
	
</body>
</html>