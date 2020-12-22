<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Abhineet Singh</h1>
	
	
	
	<%! public String show(){
		
			return "! mark is used to put into the global way";
		}
	%>
	
	
	<%
		String name = "Ramesh";
	
		out.println("My name is " + name);
	%>
	
	<%! int age=45; %>
	
	<span>My age</span><%=age %>
	
	<span>show function</span><%out.println(show()); %>
	


</body>
</html>