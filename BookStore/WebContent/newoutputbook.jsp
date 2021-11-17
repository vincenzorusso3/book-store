<%@ page language="java" import="Model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%String isbn=(String)request.getParameter("isbn");
	UserBean user=(UserBean) session.getAttribute("userBean");
if(isbn==null){
	 isbn=(String)request.getAttribute("isbn");
}
BookBean b=new BookBean();
BookBeanDAO bbd=new BookBeanDAO();
b=bbd.doRetrieveByKey(isbn);
CartBean sessCart=(CartBean)session.getAttribute("cart");
OrderBean currOrder=new OrderBean();
currOrder.setLibro(b.getIsbn());
if(user!=null){
currOrder.setUtente(user.getUsr());
}

%>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Libro</title>
<style>

.flexcontainer {
   display: flex;
}


.row {
   display: flex;
   flex-direction: row;
}

.col-sm{
   display: flex;
   flex-direction: column;
}

.description{
	font-size: 2vw;
}

.pad {

    padding: 2vw;
}

.feat{
			font-size: 2vw;
	    font-weight: bold;
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
<div class="col-sm">

<img src=<%= "images/"+b.getImage () %>><br>

</div>


<div class="col-sm pad" >


<div class="description">
<span class="feat">Titolo</span> <%=b.getTitle() %><br>
<span class="feat">Autore</span> <%=b.getAuthor() %><br>
<span class="feat">Editore</span> <%=b.getPublisher() %><br>
<span class="feat">Anno</span> <%=b.getYear() %><br>
<span class="feat">Categoria</span> <%= b.getCategory() %><br>
<span class="feat">Isbn</span> <%=b.getIsbn() %><br>
<span class="feat">Prezzo</span> €<%=b.getPrice() %><br>
<span class="feat">Descrizione</span> <%=b.getDescription() %><br>
</div>

<%
	if(user!=null){
%>
<form action="ServletAddToCart" class="description">
  <input type="hidden" name="isbn" value=<%=b.getIsbn()%>>
  <input type="hidden" name="user" value=<%=user.getUsr()%>>
  <span class="feat"> Quantità:</span> <input type="text" name="quantity"><br>
<input type="submit" value="Acquista"/>
</form>
<%
	int res=0;
	res=currOrder.contained(sessCart);
	if( currOrder.contained(sessCart)>=0)
	{
%>
<form action="ServletRemoveFromCart" class="description">
  <input type="hidden" name="isbn" value=<%=b.getIsbn()%>>
  <input type="hidden" name="user" value=<%=user.getUsr()%>>
<input type="submit" value="Rimuovi"/>
</form>

<%	} //chiude if curr order
	
}//chiude if user null

%>

<% if(user!=null){%>
<a href='newoutput.jsp' class="description">Torna al tuo profilo</a> 
<%} %>


</div>

</div>


</div>



<%@ include file="footer.jsp" %>


</body>
</html>