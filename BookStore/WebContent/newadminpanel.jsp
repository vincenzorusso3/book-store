<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="Model.*"%>
<%		 
/*ArrayList<UserBean> utenti=(ArrayList<UserBean>)request.getAttribute("utenti");
System.out.println("\n\nsono nel jsp\n\n");
*/
UserBeanDAO ubd=new UserBeanDAO();
ArrayList<UserBean> utenti=new ArrayList<>();
	utenti=ubd.doRetrieveAll();
request.setAttribute("utenti",utenti );


/*ArrayList<UserBean> utenti=(ArrayList<UserBean>)request.getAttribute("utenti");
System.out.println(utenti);*/
	 %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Pannello amministratore</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
</head>
<body>

<%		getServletContext().setAttribute("azienda", "book store salerno");
getServletContext().setAttribute("slogan", "libri per tutti i gusti");
 %>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1><%=getServletContext().getAttribute("azienda") %></h1>
		<p><%=getServletContext().getAttribute("slogan") %></p>
	</div>
<%@ include file="navbar.jsp" %>

	<div class="container">
		<div class="row">
			<h1>Buongiorno Amministratore</h1>
			
			<h3>Modifica utenti</h3>
			<ul>
			<li><a href="newdeleteuser.jsp"> Cancella utente</a> </li>
			<li><a href="newupdateuser.jsp">Modificare dati utente</a></li>			
			</ul>  
			<br>
			
			<h3>Modifica libri</h3>
			<ul>
			<li><a href="newaddbook.jsp">Inserisci libro</a></li>
			<li><a href="newdeletebook.jsp">Cancella libro</a></li>
			<li><a href="newupdatebook.jsp">Modifica libro</a></li>
			
			</ul>
			<br>
			
			<a href='ServletLogout' style="padding-left:5em">Logout</a>
		</div>
	</div>

	<%@ include file="footer.jsp" %>

</body>
</html>
