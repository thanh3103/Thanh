<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert</h1>
	<form action="ProductServlet?action=insert" method="post">
	<table>
		<tr>
			<td>Madm</td>
			<td><input type = "text" name = "txtmadm"></td>
		</tr>
		<tr>
			<td>Masp</td>
			<td><input type = "text" name = "txtmasp"></td>
		</tr>
		<tr>
			<td>Tensp</td>
			<td><input type = "text" name = "txttensp"></td>
		</tr>
		<tr>
			<td>Giasp</td>
			<td><input type = "text" name = "txtgiasp"></td>
		</tr>
		<tr>
			<td>Hinhsp</td>
			<td>
				<a href = "uploadimage.jsp">Chon hinh</a>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type = "submit" value = "Insert"></td>
		</tr>
		
	</table>
	</form>
</body>
</html>