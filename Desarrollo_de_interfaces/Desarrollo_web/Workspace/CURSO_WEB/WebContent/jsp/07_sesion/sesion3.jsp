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
String mensaje2 = (String) session.getAttribute("nombre");// (String) request.getSession().getAttribute("nombre");
%>

sesion3: <%= mensaje2 %>
<br>
<br>
<a href="<%=request.getContextPath()%>/cerrarsesion">cerrar</a>

</body>
</html>