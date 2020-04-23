<%@ page language='java' contentType='text/html; charset=iso-8859-1'%>
<%@ page import='java.util.Date' %>

<html>
  <head>
    <title>Hola Mundo</title>
  </head>
  <body>
  <%
  String mensaje = "hola";
  
  %>
  <%-- Esto es un comentario JSP --%>
  <!-- Esto es un comentario HTML -->
    <p>Hola Mundo</p>
    <p>La hora del servidor es <%= new Date() %></p>
  </body>
</html>