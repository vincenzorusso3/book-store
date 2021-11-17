<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="Model.*, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bookstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Libri</title>
</head>
<body>

<%
	BookBeanDAO ubd=new BookBeanDAO();
	ArrayList<BookBean> bd=new ArrayList<BookBean>();
	bd=ubd.doRetrieveAll();
	String path="newoutputbook.jsp?isbn=";
	String isbn="";
%>


<div class="flex">
 
  <!-- Rest of items... -->

	<% 
	for (BookBean b : bd) {
		isbn=b.getIsbn();
	  	%>
	 <section>
	 
	 <a href=<%=path+isbn%>>
    <img src=<%= "images/"+b.getImage () %> alt="description" />
</a>
    <h2><%=b.getTitle()%></h2>
    <p><%=b.getDescription()%></p>
       <br> €<%=b.getPrice()%> <br>
              <br> <%=b.getIsbn()%> <br>
       
  </section>
	  	
				
			<%} %>
			
			
		</div>
		


</body>
</html>