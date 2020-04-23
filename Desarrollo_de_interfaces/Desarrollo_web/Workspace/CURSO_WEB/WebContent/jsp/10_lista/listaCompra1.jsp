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
<form action="listaCompra1.jsp" method="get">
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
<h1>Lista compra</h1>
<%
/*
ArrayList<String> listaElementos=(ArrayList<String>)session.getAttribute("misElementos");

if(listaElementos == null){
	listaElementos = new ArrayList<String>();
	session.setAttribute("misElementos", listaElementos);
}
*/
String[] elementos = request.getParameterValues("articulos");

/*
if(elementos != null){
	for(String el : elementos){
// 		out.println("<li>" + el + "</li>");
		listaElementos.add(el);
	}
}
*/
if(elementos != null){
for(String el : elementos){
		out.println("<li>" + el + "</li>");
}
}
//elementos = null;
%>

</body>
</html>