<%@ page language="java" import="Model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
  <title>Bootstrap Website Example</title>
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
  
  <nav class="navbar navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="newhome.jsp">BookStore</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="newhome.jsp">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menù <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="newhome.jsp">Homepage</a></li>
            <li><a href="chisiamo.jsp">Chi siamo</a></li>
            <li><a href="dovesiamo.jsp">Dove siamo</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" action="ServletSearchBook">
      	<div class="input-group">
        	<input type="text" class="form-control" placeholder="Search" name="title">
        	<div class="input-group-btn">
          		<button class="btn btn-default" type="submit">
            		<i class="glyphicon glyphicon-search"></i>
          		</button>
        	</div>
      	</div>
      </form>
      <ul class="nav navbar-nav navbar-right">
 		<%	
 			UserBean ub=(UserBean) session.getAttribute ("userBean");
    		if (ub==null) {	
		%>
    			<li><a href="newregisterjquery.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
       		 	<li><a href="newlogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		<%	} else {	%>
		
			<%if(ub.isAdmin()==0){ %>	
				<li><a href="newoutput.jsp"><span class="glyphicon glyphicon-user"></span> <%= ub.getNome() %></a></li>
			<%}else	{ %>
				<li><a href="newadminpanel.jsp"><span class="glyphicon glyphicon-user"></span> <%= ub.getNome() %></a></li>
			<%} %>


      			<li><a href="ServletLogout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		
		
		<%	}	%>
      </ul>
    </div>
  </div>
</nav>
  
  </body>
</html>   


