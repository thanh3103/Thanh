<%@page import="entities.Danhmuc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DanhmucModel"%>
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
	<table>
	<tr>
		<td>Ma danh muc</td>
		<td>Ten danh muc</td>
		<td>Deleted</td>
	</tr>
	<%DanhmucModel dmmodel = new DanhmucModel(); %>
	<c:forEach var="p" items="<%=dmmodel.getList() %>">
	<tr>
		<td>${p.madm }</td>
		<td>${p.tendm }</td>
		<td>${p.deleted }</td>
		<td><a href = "DanhmucServlet?action=view&madm=${p.madm }">View</a></td>
		<td><a href="DanhmucServlet?action=delete&madm=${p.madm }">Delete</a></td>
	</tr>
	</c:forEach>
	<tr>
		<td><a href="insertDM.jsp">Insert</a></td>
	</tr>
	</table>
</body>
</html>