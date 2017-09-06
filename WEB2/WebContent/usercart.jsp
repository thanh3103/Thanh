<%@page import="entities.Item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Cart!</h1>
	<%ArrayList<Item> cart = (ArrayList<Item>)request.getAttribute("list"); %>
	<form action="CartServlet" method = "post">
	<table border = "1">
	<tr>
		<td>MaSP</td>
		<td>TenSP</td>
		<td>HinhSP</td>
		<td>Gia</td>
		<td>SoLuong</td>
		<td>Total</td>
		<td>Action</td>
	</tr>
	<c:forEach var="i" items="<%=cart %>">
	<tr>
		<td>${i.sanpham.masp }</td>
		<td>${i.sanpham.tensp }</td>
		<td><img src="Images/${i.sanpham.hinh }" height="80px" width="60px"/></td>
		<td>${i.sanpham.gia }</td>
		<td>${i.soluong }</td>
		<td>${i.sanpham.gia * i.soluong }</td>
		<td><a href="CartServlet?action=delete&masp=${i.sanpham.masp }">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	<p><b>Total : <%=request.getAttribute("totalcart") %></b></p>
	<a href="index.jsp"	>Tiep tuc mua</a>
	<a href="CartServlet?action=removeall">Xoa gio hang</a>
	<input type = "submit" value="Mua hang">
	</form>
</body>
</html>