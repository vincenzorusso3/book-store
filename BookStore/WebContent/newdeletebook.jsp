<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page import="Model.*"%>
<%		 
/*ArrayList<UserBean> utenti=(ArrayList<UserBean>)request.getAttribute("utenti");
System.out.println("\n\nsono nel jsp\n\n");
*/
BookBeanDAO bbd=new BookBeanDAO();
ArrayList<BookBean> libri=new ArrayList<>();
	libri=bbd.doRetrieveAll();
request.setAttribute("libri",libri );


/*ArrayList<UserBean> utenti=(ArrayList<UserBean>)request.getAttribute("utenti");
System.out.println(utenti);*/
	 %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Cancella libro</title>
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
			<h2>Seleziona libro da eliminare</h2>

			<form action="ServletDeleteBook" >
				<select name="book" >

					<% 
			
					
					
  	if(!(libri.isEmpty())){
  		
  	for (BookBean lb : libri)
		
	 { %>
					<option value="<%=lb.getIsbn()%>"><%=lb.getTitle()+" "+lb.getIsbn() %>
					</option>

					<%}
  						}else{%>
					<option>value="non ci sono libri"</option>

					<%} %>
				</select> <br> <br> <input type="submit">
			</form>
		</div>
	</div>

	<%@ include file="footer.jsp" %>

</body>
</html>
