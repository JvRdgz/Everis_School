<html>
<head>
    <%@include file="cabecera.jsp" %>
</head>

<body>

<h1>Ejemplo de expresiones JSP</h1>

<%
String cadena = request.getParameter("nombre");

%>
<ul>
	<li>Fecha actual: <%=new java.util.Date()%></li>
	<li>Nombre del host: <%=request.getRemoteHost()%></li>
	<li>ID de la sesi�n: <%=session.getId()%></li>
	<li>El par�metro es: <%= cadena %></li>
</ul>
    

    <%@include file="pie.jsp" %>

</body>
</html>
