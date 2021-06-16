<%@ page language="java" isELIgnored="false" isErrorPage="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<!-- 500 org.springframework.dao.EmptyResultDataAccessException
 -->

 
..............     

<%
	String e1 ="incorrect";

%>
<c:if test="<%=exception.getMessage().toString().toUpperCase().contains(e1.toUpperCase()) %>">
	Invalid Data Access
</c:if>


</body>
</html>