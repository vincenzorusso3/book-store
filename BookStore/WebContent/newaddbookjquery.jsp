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
$(document).ready(function(){
	$(".error").hide();

	$('#f1').submit(function() {
		 var res = true;
		 // here I am checking for textFields, password fields, and any 
		 // drop down you may have in the form
		 $("#f1").find( 'input[type!="submit"]' ).each(function () {
			if ( ! validate($(this).attr('id'))) { 
				$(this).addClass('er').next().show();
				res = false;
			}
			else if($(this).hasClass("er"))
				$(this).removeClass('er').next().hide();
		});
		return res; // returning false will prevent the form from submitting.
	});
});

function validate(fieldId) {

	if (fieldId=="title")
        return validateName();
	if (fieldId=="username")
        return validateUsername();
	if (fieldId=="name")
        return validateName();
	if (fieldId=="surname")
        return validateName();
	if (fieldId=="address")
        return validateName();
	if (fieldId=="password")
        return validateUsername();
	if (fieldId=="conpassword")
            return validateUsername();
	if (fieldId=="card")
        return validateCard();
}

function validateName(){
	var letters = /^[ a-zA-Z]+$/;
	if(document.getElementById("name").value.match(letters))
		return true;
	else{
		document.getElementById("name").focus();
		return false;
	}
}

function validateCard(){
	var letters = /^[ 0-9]+$/;
	if(document.getElementById("card").value.match(letters))
		return true;
	else{
		document.getElementById("card").focus();
		return false;
	}
}


function validateUsername()
{
	var letters = /^[0-9a-zA-Z]+$/;
	if(document.getElementById("username").value.match(letters))
		return true;
	else{
		document.getElementById("username").focus();
		return false;
	}
}

function validateEmail()
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/;
    if(document.getElementById("email").value.match(mailformat))
    	return true;
    else{
		document.getElementById("email").focus();
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
			<form name="form" id="f1" action="ServletAddBook" method="post"
				onsubmit="return validate()">
				<table align="center">
					<tr>
						<td>titolo</td>
						<td><input type="text" name="title" id="title" /></td>
					</tr>
					
					<tr>
						<td>Isbn</td>
						<td><input type="text" name="isbn" id="isbn" /></td>
					</tr>
					
					<tr>
						<td>Descrizione</td>
						<td><input type="text" name="description" id="description"  /></td>
					</tr>
					<tr>
						<td>Prezzo</td>
						<td><input type="text" name="price" id="price" /></td>
					</tr>
					
					<tr>
						<td>Anno</td>
						<td><input type="text" name="year" id="year" /></td>
					</tr>
					<tr>
						<td>Categoria</td>
						<td><input type="text" name="category" id="category" /></td>
					</tr>
					
					<tr>
						<td>Autore</td>
						<td><input type="text" name="author"  id="author"/></td>
					</tr>
					<tr>
						<td>Editore</td>
						<td><input type="text" name="publisher" id="publisher" /></td>
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
