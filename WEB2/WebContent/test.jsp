<%@page import="model.DanhmucModel"%>
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
	<form enctype="multipart/form-data" action="ProductServlet?action=upload" method="post">
	<%ArrayList list = new DanhmucModel().getList(); %>
	<select name="madm">
		<c:forEach var="dm" items="<%=list %>">
			<option value="${dm.madm }" ${dm.madm == param.madm ? 'selected':''} >${dm.tendm }</option>
		</c:forEach>
	</select>
	<input type = "file" name="file">
	<input type = "submit">
	</form>
</body>
</html>