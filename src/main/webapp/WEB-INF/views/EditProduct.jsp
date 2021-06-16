<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
	<h2>Edit New Product</h2>

	<s:form action="../updateproduct" modelAttribute="product" method="post">
	
		ProductName : <s:input path="productName"/><s:errors path="productName"></s:errors><br><br>
		
		ProductPrice :<s:input path="price"/><s:errors path="price"></s:errors><br><br>
		
		<s:hidden path="productId"/>
		<input type="submit" value="UpdateProduct">
	
	</s:form>
</body>
</html>