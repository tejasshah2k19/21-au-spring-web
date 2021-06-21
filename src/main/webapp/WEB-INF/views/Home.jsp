<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Home</h1>

	<%-- FirstName :  ${user.firstName}<br>
	Email : ${user.email }<Br>
	Password : ${user.password }<Br>
	Gender: ${user.gender }<br>
	Course : ${user.course }<br>
	Phone : ${user.phone }<br>
	 --%>
	
	<a href="newproduct">New Product</a> | <a href="listproducts">List Products</a> |
	<a href="addproductimage">Add Product Image</a>
	
	<br>
	<br>
	${msg }
</body>


</html>