<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculadora</title>
</head>
<body>

<% 

String mensaje = (String) request.getAttribute("result");

%>

<input name="resultado" type="text" value="<%= mensaje %>">

<%= mensaje %>

</body>
</html>