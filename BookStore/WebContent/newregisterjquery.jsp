<%@ page import="Model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Registrati</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

input.er {
	border-style: solid;
	border-color: red;
}

.error{
	color: red;
}



.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>

<script src="scripts/jquery.js"></script>

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

	if (fieldId=="email")
        return validateEmail();
	if (fieldId=="username")
        return validateUsername();
	if (fieldId=="name")
        return validateName();
	if (fieldId=="surname")
        return validateSurname();
	if (fieldId=="address")
        return validateAddress();
	if (fieldId=="password")
        return validatePassword();
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

function validateSurname(){
	var letters = /^[ a-zA-Z]+$/;
	if(document.getElementById("surname").value.match(letters))
		return true;
	else{
		document.getElementById("surname").focus();
		return false;
	}
}

function validateAddress(){
	var letters = /^[ \sa-zA-Z0-9\,]+$/;
	if(document.getElementById("address").value.match(letters))
		return true;
	else{
		document.getElementById("address").focus();
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

function validatePassword()
{
	var letters = /^[0-9a-zA-Z]+$/;
	if(document.getElementById("password").value.match(letters))
		return true;
	else{
		document.getElementById("password").focus();
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

	

	
	
	function showComuni() {
		  var xhttp= new XMLHttpRequest();
		  xhttp.onreadystatechange=function () {
		    if (xhttp.readyState==4 && xhttp.status==200) {
		      document.getElementById("demo").innerHTML=xhttp.responseText;
		    }
		  };
		  var select=document.getElementById ("select").value;
		  xhttp.open("get","ProvinceServlet?provinces=" + select,true);
		  xhttp.send();
		}
</script>

</head>
<body>


	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1><%=getServletContext().getAttribute("azienda")%></h1>
		<p><%=getServletContext().getAttribute("slogan")%></p>
	</div>

	<%@ include file="navbar.jsp"%>


	<div class="container">
		<div class="row">

			<center>
				<h2>Registrazione Cliente</h2>
			</center>
			<form name="form" id="f1" action="ServletRegister" method="post"
				onsubmit="return validate()">
				<table align="center">
					<tr>
						<td>Nome</td>
						<td><input type="text" name="nome" id="name" /> <span class="error">Il nome puo contenere solo caratteri alfanumerici</span></td>
					</tr>
					<tr>
						<td>Cognome</td>
						<td><input type="text" name="cognome" id="surname" /> <span class="error">Il cognome puo contenere solo caratteri alfanumerici</span></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" id="email" /> <span class="error">L'email deve essere in un formato valido</span></td>
					</tr>
					<tr>
						<td>Indirizzo</td>
						<td><input type="text" name="address" id="address" /><span class="error">L'indirizzo deve essere in un formato valido</span></td>
					</tr>
					<tr>
						<td>Carta di credito</td>
						<td><input type="text" name="card" id="card" /><span class="error">La carta di credito deve essere in un formato valido</span></td>
					</tr>
					<tr>
						<td>Username</td>
						<td><input type="text" name="username" id="username"/><span class="error">L'username puo contenere solo caratteri alfanumerici</span></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" id="password" /> <span class="error">La password deve essere in un formato valido</span></td>
					</tr>
					

					<tr>
						<!--  <td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>-->
					</tr>


					<tr>
						<td>Provincia</td>
						<td><select id="select" name="provinces"
							onchange="showComuni()">
								<option value="salerno">Salerno</option>
								<option value="napoli">Napoli</option>
								<option value="avellino">Avellino</option>
						</select> <span id="demo"></span></td>
					</tr>


					<tr>
						<td></td>
						<td><input type="submit" value="Register"></input></td>
					</tr>


				</table>
			</form>

		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>
