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
	<h1>Update</h1>
	<form action="ProductServlet?action=update" method="post">
		<table>
			<tr>
				<td>Madm</td>
				<td>
				<%ArrayList list = new DanhmucModel().getList(); %>
				<select name="madm">
						<c:forEach var="dm" items="<%=list%>">
							<option value="${dm.madm }"
								${dm.madm == param.madm ? 'selected':''}>${dm.tendm }</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td>Masp</td>
				<td><input type="text" name="txtmasp"
					value="<%=request.getParameter("masp")%>"></td>
			</tr>
			<tr>
				<td>Tensp</td>
				<td><input type="text" name="txttensp"
					value="<%=request.getParameter("tensp")%>"></td>
			</tr>
			<tr>
				<td>Giasp</td>
				<td><input type="text" name="txtgiasp"
					value="<%=request.getParameter("giasp")%>"></td>
			</tr>
			<tr>
				<td>Hinhsp</td>
				<td><a href="uploadimageupdate.jsp">Chon hinh</a></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			</tr>

		</table>
	</form>
</body>
</html>