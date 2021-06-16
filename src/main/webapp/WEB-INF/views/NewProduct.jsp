<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>


	<c:if test="${product.productId == 0 }">
		<c:set var="url" value="saveproduct"></c:set>
		<c:set var="btnValue" value="SaveProduct"></c:set>
		<c:set var="title" value="New Product"></c:set>
	</c:if>

	<c:if test="${product.productId != 0 }">
		<c:set var="url" value="../updateproduct"></c:set>
		<c:set var="btnValue" value="UpdateProduct"></c:set>
		<c:set var="title" value="Edit Product"></c:set>
	</c:if>

	<h2>${title }</h2>

	<s:form action="${url}" modelAttribute="product" method="post">
	
	ProductName :
	<s:input path="productName" />
		<s:errors path="productName"></s:errors>
		<br>
		<br> ProductPrice :
	<s:input path="price" />
		<s:errors path="price"></s:errors>
		<br>
		<br>

		<input type="submit" value="${btnValue}">

	</s:form>
</body>
</html>