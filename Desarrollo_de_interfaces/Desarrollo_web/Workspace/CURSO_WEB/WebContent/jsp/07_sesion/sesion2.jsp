<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String mensaje = (String) request.getSession().getAttribute("nombre");
%>

sesion2: <%= mensaje %>
<br>
<br>
<a href="sesion3.jsp">enlace</a>

</body>
</html>