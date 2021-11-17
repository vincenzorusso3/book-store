<%@ page import="Model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Aggiungi libro</title>
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
	var isbn = document.form.isbn.value;
	var titolo = document.form.title.value;
	var descrizione = document.form.description.value;
	var prezzo = document.form.price.value;
	var path = document.form.image.value;
	var ex_num = /^[0-9\.\,]+$/;
	var anno = document.form.year.value;

	
	
	if (isbn == null || isbn == "") {
		alert("Inserire isbn");
		return false;
	} else if (titolo == null || titolo == "") {
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


	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1><%=getServletContext().getAttribute("azienda")%></h1>
		<p><%=getServletContext().getAttribute("slogan")%></p>
	</div>

<%@ include file="navbar.jsp" %>

	<div class="container">
		<div class="row">

			<center>
				<h2>Inserimento Libro</h2>
			</center>
			<form name="form" action="ServletAddBook" method="post"
				onsubmit="return validate()">
				<table align="center">
					<tr>
						<td>Titolo</td>
						<td><input type="text" name="title" /></td>
					</tr>
					
					<tr>
						<td>Isbn</td>
						<td><input type="text" name="isbn" /></td>
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
						<td><input type="submit" value="Aggiungi"></input><input
							type="reset" value="Reset"></input></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

	<%@ include file="footer.jsp" %>

</body>
</html>
