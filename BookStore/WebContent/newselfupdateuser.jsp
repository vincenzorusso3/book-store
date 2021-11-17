<%@ page import="Model.*"%>
<%
	String u=(String)request.getParameter("oldUser");

%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Aggiorna profilo</title>
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
	var fullname = document.form.nome.value;
	var email = document.form.email.value;
	var username = document.form.username.value;
	var password = document.form.password.value;
	var address = document.form.address.value;
	var card = document.form.card.value;
	var conpassword = document.form.conpassword.value;
	
	
	if (fullname == null || fullname == "") {
		alert("Inserire nome");
		return false;
	} else if (email == null || email == "") {
		alert("Inserire e-mail");
		return false;
	} else if (password == null || password == "") {
		alert("Inserire password");
		return false;
	}else if (password != conpassword) {
		alert("Le password non corrispondono");
		return false;
	}
		else if (adress == null || address == "") {
		alert("Inserire indirizzo");
		return false;
	} else if (card == null || card == "") {
		alert("Inserire carta di credito");
		return false;
	} else if (password.length < 6) {
		alert("La password deve essere più lunga di 6");
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

<%@ include file="navbar.jsp" %>


	<div class="container">
		<div class="row">

			<center>
				<h2>Modifica i tuoi dati</h2>
			</center>
			<form name="form" action="ServletSelfUserUpdate" method="post"
				onsubmit="return validate()">
				<table align="center">
					<tr>
						<td>Nome</td>
						<td><input type="text" name="nome"  /></td>
					</tr>
					<tr>
						<td>Cognome</td>
						<td><input type="text" name="cognome" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Indirizzo</td>
						<td><input type="text" name="address"  /></td>
					</tr>
					<tr>
						<td>Carta di credito</td>
						<td><input type="text" name="card" /></td>
					</tr>
				
					<tr>
						<td>Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td>Confirm Password</td>
						<td><input type="password" name="conpassword" /></td>
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
						<td><input type="submit" value="Aggiorna dati"></input><input
							type="reset" value="Reset"></input></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

<%@ include file="footer.jsp" %>

</body>
</html>
