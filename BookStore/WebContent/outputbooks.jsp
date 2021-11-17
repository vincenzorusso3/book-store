<%@ page language="java" import="Model.*, java.util.ArrayList" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int i=0;
	BookBean b=new BookBean ();
	BookBeanDAO bd=new BookBeanDAO ();
	ArrayList <BookBean> bs=bd.doRetrieveAll();
	while (i<bs.size ())
	{
		b=bs.get (i);
%>
		<img src=<%= "images/"+b.getImage () %>><br>
		<%= b.getTitle () %><br>
		<%= b.getAuthor () %><br>
		<%= b.getPrice () %>
<%
		i++;
	}	
%>