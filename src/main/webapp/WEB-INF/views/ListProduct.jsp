<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<a href="newproduct">New Product</a> |<br>
	<h2>List Products</h2>
	<table border="1">
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Price</th>
			<th>Action</th>
			
		</tr>

		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.productId }</td>
				<td>${p.productName }</td>
				<td>${p.price }</td>
				<td><a href="deleteproduct/${p.productId }"> Delete</a> | 
				<a href="editproduct/${p.productId}"> Edit</a>|
				<a href="addproductimage">Add Image</a>
				
				</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>