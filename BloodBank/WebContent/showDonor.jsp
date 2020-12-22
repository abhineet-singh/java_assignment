<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Donor</title>
</head>
<body>

	<table>
		<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Blood Group</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Date of Birth</th>
		</tr>
		</thead>

		<tbody>
			<c:forEach items="${donorList}" var="donor">
			<tr>
				<td>${donor.getName()}</td>
				<td>${donor.getAge()}</td>
				<td>${donor.getGender()}</td>
				<td>${donor.getBloodGroup()}</td>
				<td>${donor.getPhoneNumber()}</td>
				<td>${donor.getEmail()}</td>
				<td>${donor.getDateOfBirth()}</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>

</body>
</html>