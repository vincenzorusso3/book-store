<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="Model.*, java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="bookstyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Il tuo carrello</title>
</head>
<body>

<%
	CartBean cart=(CartBean)session.getAttribute("cart");
	ArrayList <OrderBean> orders=new ArrayList<>();
	
	if(cart!=null){
	
	orders=cart.getOrders();
	BookBeanDAO bbd=new BookBeanDAO();
	BookBean bb=new BookBean();
	double tot=0;

%>
<div>

<table style="width:100%">
  <tr>
    <th>Titolo</th>
    <th>Quantità</th>
    <th>Prezzo</th>
    <th>Totale</th>
    
  </tr>


	<% 
	for (OrderBean ob : orders) {
		bb=bbd.doRetrieveByKey(ob.getLibro());
		tot+=bb.getPrice()*ob.getQuantita();
	  	%>
	  	
	  	 <tr>
    <td><%=bb.getTitle()%></td>
    <td><%=ob.getQuantita()%></td>
    <td><%=bb.getPrice()%></td>
  </tr>

			<%} %>
			
			 <tr>
    <td></td>
     <td></td>
     <td></td>
     
     <%double finalTot = Math.round(tot * 100.0) / 100.0 ; %>
    
    <td><%=finalTot%></td>
    
    <%} %>
  </tr>
			
			</table>
		</div>
		


</body>
</html>