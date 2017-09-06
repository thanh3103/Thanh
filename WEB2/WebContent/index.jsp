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
	<table border = "1">
		<tr>
			<th>Madm</th>
			<th>Masp</th>
			<th>Tensp</th>
			<th>Gia</th>
			<th>Hinh</th>
			<th>Action</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<% ProductModel promodel = new ProductModel(); %>
		<c:forEach var="p" items="<%=promodel.getList() %>">
		<tr>
			<td>${p.madm }</td>
			<td>${p.masp }</td>
			<td>${p.tensp }</td>
			<td>${p.gia }</td>
			<td><img src="Images/${p.hinh }" style="width:120px;height:150px;"></td>
			<td><a href="CartServlet?action=add&masp=${p.masp }">Add Cart</a></td>
			<td><c:url var="varupdate" value="update.jsp">
					<c:param name="madm" value="${p.madm }"/>
					<c:param name="masp" value="${p.masp }"/>
					<c:param name="tensp" value="${p.tensp }"/>
					<c:param name="giasp" value="${p.gia }"/>
					<c:param name="hinhsp" value="${p.hinh }"/>
				</c:url>
				<a href="${varupdate }">Update</a>
			</td>	
			<td><a href="test.jsp?madm=${p.madm }">Test</a>
		</tr>
		</c:forEach>
	</table>
</body>
</html>