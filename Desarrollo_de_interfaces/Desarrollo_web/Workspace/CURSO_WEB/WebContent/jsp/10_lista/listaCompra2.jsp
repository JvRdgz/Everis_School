<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="login" method="POST"> -->
<!--    <input type="text" name="user" value="usuario" /> -->
<!--    <input type="password" name="password" value="contraseña" /> -->
<!--    <input type="submit" value="Enviar" /> -->
<!-- </form> -->

<br>
<form action="<%=request.getContextPath()%>/ListaCompra" method="post">
	<label>
		<input type="checkbox" name="articulos" value="leche" >leche
	
	</label><br>
	<label>
		<input type="checkbox" name="articulos" value="agua">agua
	
	</label><br>
	<label>
		<input type="checkbox" name="articulos" value="pan">pan
	
	</label><br>
	<input type="submit" name="boton" id="boton" value="enviar">
</form>
<br>
<a href="<%=request.getContextPath()%>/limpiar">limpiar</a>
<br>
<h1>Lista compra</h1>
<%
ArrayList<String> listaElementos=(ArrayList<String>)session.getAttribute("misElementos");

if(listaElementos != null){
	for(String el : listaElementos){
		out.println("<li>" + el + "</li>");
	}
	//listaElementos = new ArrayList<String>();
	//session.setAttribute("misElementos", listaElementos);
}




%>

</body>
</html>