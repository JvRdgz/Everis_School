<html>
<head>
</head>

<body>
<%
String nombre = "manolo";
System.out.println("adios "+nombre);

%>
Hola <%= nombre %> <%=request.getParameter("apellido")%>

</body>
</html>
