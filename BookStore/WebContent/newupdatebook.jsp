<%@ page import="Model.*"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Inserisci libro</title>
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

<script>
function validate() {
	var titolo = document.form.title.value;
	var descrizione = document.form.description.value;
	var prezzo = document.form.price.value;
	var path = document.form.image.value;
	var ex_num = /^[0-9\.\,]+$/;
	var anno = document.form.year.value;

	
	
	
	if (titolo == null || titolo == "") {
		alert("Inserire titolo");
		return false;
	} else if (descrizione == null || descrizione == "") {
		alert("Inserire descrizione");
		return false;
	} else if (prezzo == null || prezzo == "") {
		alert("Inserire prezzo");
		return false;
	}	else if (path == null || path == "") {
		alert("Inserire path file immagine");
		return false;
	} else if (anno == null || anno == "") {
		alert("Inserire anno");
		return false;
	}	else if (!anno.match(ex_num)) {
		alert("Anno non è un numero");
		return false;
	}	else if (!prezzo.match(ex_num)) {
		alert("Prezzo non è un numero");
		return false;
	}	
	
	
}



</script>

</head>
<body>

<%BookBeanDAO bbd=new BookBeanDAO();
ArrayList<BookBean> libri=new ArrayList<>();
	libri=bbd.doRetrieveAll();
request.setAttribute("libri",libri );
String err=(String)request.getAttribute("errMessage");
%>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1><%=getServletContext().getAttribute("azienda")%></h1>
		<p><%=getServletContext().getAttribute("slogan")%></p>
	</div>

<%@ include file="navbar.jsp" %>


	<div class="container">
		<div class="row">
		
		
				<h2>Modifica Libro</h2>
				<%if(err!=null){%>
					L'anno o il prezzo non sono numeri
					
				<% } %>
			</center>
			<form name="form" action="ServletUpdateBook" method="post"
				onsubmit="return validate()">
				

				
				<table align="center">
				
				<tr>	<td>Scegli libro da modificare:</td>
						<td>
										<select name="book">
								<% 					
					
  	if(!(libri.isEmpty())){
  		
  	for (BookBean lb : libri)
		
  	 { %>
		<option value="<%=lb.getIsbn()%>"><%=lb.getTitle()+" "+lb.getIsbn()%>
		</option>

		<%}
			}else{%>
		<option>value="non ci sono libri"</option>

		<%} %>	
		</select>
						
						</td>
						
					</tr>
					
					<tr>
						<td>titolo</td>
						<td><input type="text" name="title" /></td>
					</tr>
					
				
					<tr>
						<td>Descrizione</td>
						<td><input type="text" name="description" /></td>
					</tr>
					<tr>
						<td>Prezzo</td>
						<td><input type="text" name="price" /></td>
					</tr>
					
					<tr>
						<td>Anno</td>
						<td><input type="text" name="year" /></td>
					</tr>
					
					<tr>
						<td>Categoria</td>
						<td><input type="text" name="category" /></td>
					</tr>
					
					<tr>
						<td>Autore</td>
						<td><input type="text" name="author" /></td>
					</tr>
					<tr>
						<td>Editore</td>
						<td><input type="text" name="publisher" /></td>
					</tr>
					
					<tr>
						<td>Pathname immagine</td>
						<td><input type="text" name="image" /></td>
					</tr>
					
					<tr>
						<!--  <td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>-->
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Aggiorna libro"></input><input
							type="reset" value="Reset"></input></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

<%@ include file="footer.jsp" %>


</body>
</html>
