<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Signup</h3>

	<s:form method="post" action="saveuser"  modelAttribute="user" >
		<label> FirstName </label> <s:input   path="firstName"
			size="15" /> 
			<s:errors path="firstName"></s:errors>
			<br> <br> <label> Course : </label> 
			

			<select
			name="course">
			<option value="Course">Course</option>
			<option value="BCA">BCA</option>
			<option value="BBA">BBA</option>
			<option value="B.Tech">B.Tech</option>
			<option value="MBA">MBA</option>
			<option value="MCA">MCA</option>
			<option value="M.Tech">M.Tech</option>
		</select> <br> <br> <label> Gender : </label><br> 
		
		
		<s:radiobutton path="gender" value="male"/> Male <br> 
<s:radiobutton path="gender" value="female"/> Female <br>
			<s:errors path="gender"></s:errors>
			 <br><br>
			 <label> Phone : </label> <input type="text"
			name="phone" size="10" /> <br> <br> Address <br>
		<textarea cols="80" rows="5" name="address">  
</textarea>


		<br> <br> Email: <s:input path="email" /> <s:errors path="email"></s:errors>
		<br> <br> <br> Password: <input type="Password"
			id="pass" name="password"> <br> <br> <br>
		Age :<s:input path="age"/><s:errors path="age"></s:errors>
			<br><br><BR>
		<input type="submit" value="Submit" />
	</s:form>
</body>
</html>