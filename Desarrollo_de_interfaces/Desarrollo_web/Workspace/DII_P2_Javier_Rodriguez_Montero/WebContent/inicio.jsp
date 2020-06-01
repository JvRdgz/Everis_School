<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: #252525;
	padding: 0px;
	margin: 0px;
	border: none;
	width: 100%;
}

h1 {
	color: #94b7ff;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	font-style: normal;
	margin-top: 100px;
}

.centrar-user {
	display: flex;
	align-items: center;
	justify-content: center;
}

#user {
	text-align: center;
	padding: 10px;
	margin: 53px;
	border-radius: 10px;
	border-color: #94b7ff;
	color: #ffffff;
	background-color: #4664a0;
	font-family: Arial, Helvetica, sans-serif;
	font-style: normal;
}

.centrar-boton {
	display: flex;
	align-items: center;
	justify-content: center;
}

#cerrar {
	text-align: center;
	padding: 10px;
	margin: 53px;
	border-radius: 10px;
	border-color: #94b7ff;
	color: #ffffff;
	background-color: #4664a0;
	font-family: Arial, Helvetica, sans-serif;
	font-style: normal;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
String nombre = (String) session.getAttribute("nombre");
%>
	<h1>DII_P2_Javier_Rodriguez_Montero</h1>
	<div class="centrar-user">
		<input id="user" size="25" disabled="disabled" name="nombre"
			type="text" value="<%=nombre%>">
	</div>
	<br>
	<div class="centrar-boton">
		<a id="cerrar"
			href="<%=request.getContextPath()%>/ServletCerrarSesion">Cerrar
			sesion</a>
	</div>
</body>
</html>