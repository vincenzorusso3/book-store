<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrati</title>

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
		} else if (username == null || username == "") {
			alert("Inserire nome utente");
			return false;
		} else if (adress == null || address == "") {
			alert("Inserire indirizzo");
			return false;
		} else if (card == null || card == "") {
			alert("Inserire carta di credito");
			return false;
		} else if (password.length < 6) {
			alert("La password deve essere più lunga di 6");
			return false;
		} else if (password != conpassword) {
			alert("Le password non corrispondono");
			return false;
		}
	}
</script>
</head>
<body>

	<center>
		<h2>Registrazione Cliente</h2>
	</center>
	<form name="form" action="RegisterServlet" method="post"
		onsubmit="return validate()">
		<table align="center">
			<tr>
				<td>Nome</td>
				<td><input type="text" name="nome" /></td>
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
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Carta di credito</td>
				<td><input type="text" name="card" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
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
				<td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></input><input
					type="reset" value="Reset"></input></td>
			</tr>
		</table>
	</form>

<%@ include file="footer.jsp" %>

</body>
</html>