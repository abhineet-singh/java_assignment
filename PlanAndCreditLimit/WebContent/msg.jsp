<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Details</title>
</head>
<body>

<div>
	<c:if test="${isPaymentSuccessful == 1}">
		<h2>Your Payment Is Successful, New Credit Limit Is := <c:out value="${creditLimit }"></c:out></h2>
	</c:if>
	
	<c:if test="${isPaymentSuccessful == 0}">
		<h2>Insufficient Balance, Your Credit Limit Is := <c:out value="${creditLimit }"></c:out></h2>
	</c:if>
	
	<c:if test="${isPaymentSuccessful == -1}">
		<h2>Invalid User</h2>
	</c:if>
</div>

</body>
</html>