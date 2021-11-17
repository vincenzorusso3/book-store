<%@ page import="Model.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Libreria Salernitana</title>
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
<%		getServletContext().setAttribute("azienda", "book store salerno");
getServletContext().setAttribute("slogan", "libri per tutti i gusti");
 String failSearch=(String) request.getAttribute("errMessage");
 %>

<div class="jumbotron text-center" style="margin-bottom:0">
  <h1><%=getServletContext().getAttribute("azienda") %></h1>
  <p><%=getServletContext().getAttribute("slogan") %></p> 
</div>

<%@ include file="navbar.jsp" %>

<div class="container">
  <div class="row">
  
  <h1>homepage</h1>
  <%if(failSearch!=null)  { %>
  <p>Libro non trovato.</p>
  
  <%} %>
<%@ include file="newoutputbooks.jsp" %>
  
  
  </div>
</div>


<%@ include file="footer.jsp" %>


</body>
</html>
