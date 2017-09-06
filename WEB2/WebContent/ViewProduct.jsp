<%@page import="entities.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ProductModel"%>
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
	<table border="1">
	<tr>
		<td>Ma sp</td>
		<td>Ten sp</td>
		<td>Gia sp</td>
		<td>Hinh sp</td>
		<td>Ma danh muc</td>
	</tr>
	<%ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("listsp"); %>
	<c:forEach var="p" items="<%=list %>">
	<tr>
		<td>${p.masp }</td>
		<td>${p.tensp }</td>
		<td>${p.gia }</td>
		<td><img src="Images/${p.hinh }" style="width:120px;height:150px;"></td>
		<td>${p.madm }</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>