<!DOCTYPE html>
<html lang="en">
<head>
  <title>Chi siamo</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .fakeimg {
      height: 200px;
      background: #aaa;
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
  	<h2>Chi siamo</h2>
  	<p>
  	Siamo un'azienda attiva sul territorio dal 1992, abbiamo sempre lavorato con serietà per i nostri clienti, il nostro catalogo possiede libri per tutti i gusti.
  	Offriamo prezzi competitivi a livello di grandi multinazionali in aggiunta a un servizio di assistenza all' acquisto e che ci ha reso vincenti per 26 anni.
  	</p>


	</div>

</div>

<%@ include file="footer.jsp" %>


</body>
</html>
