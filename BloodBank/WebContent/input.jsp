<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Provide Details</title>
</head>
<body>

<section>
	<form action="donor" method="post">
		<label for="">User name</label>
		<input type="text" name="name"/><br>
		
		<label for="">Age</label>
		<input type="text" name="age"/><br>
		
		<label for="">Gender</label>
		<input type="text" name="gender"/><br>
		
		<label for="">Blood group</label>
		<input type="text" name="bloodGroup"/><br>
		
		<label for="">Phone Number</label>
		<input type="text" name="phoneNumber"/><br>
		
		<label for="">Email</label>
		<input type="text" name="email"/><br>
		
		<label for="">Date of Birth</label>
		<input type="date" name="dateOfBirth"/><br>

		
		<input type="submit" value="Add" />
	</form>
	
	<p>
	<c:if test="${rowAdded > 0}">
		<h3>Rows Added : </h3><c:out value="${rowAdded}"></c:out>
	</c:if>
	</p>
</section>	
	
	
</body>
</html>