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
	margin-top: 40px;
}

form {
	margin: 0 auto;
	text-align: center;
	border-radius: 30px;
	border: 4px solid #94b7ff;
	width: 550px;
	height: 550px;
}

.centrar-form {
	margin: 100px auto;
	float: none;
}

#user {
	padding: 10px;
	margin: 80px;
	border-radius: 10px;
	border-color: #94b7ff;
	color: #ffffff;
	background-color: #4664a0;
	font-family: Arial, Helvetica, sans-serif;
	font-style: italic;
}

#password {
	padding: 10px;
	margin: 53px;
	border-radius: 10px;
	border-color: #94b7ff;
	font-family: Arial, Helvetica, sans-serif;
	font-style: italic;
	color: #ffffff;
	background-color: #4664a0;
}

#boton-login {
	margin: 100px;
	font-family: Arial, Helvetica, sans-serif;
	color: #003aad;
}
</style>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<p style="color: white; margin-left: 20px;">El nombre de usuario:
		Javier</p>
	<br>
	<p style="color: white; margin-left: 20px;">Contraseña: 1234</p>
	<%
String usuario = (String) request.getSession().getAttribute("nombre");
String contrasena = (String) request.getSession().getAttribute("contrasena");
%>
	<h1>DII_P2_Javier_Rodriguez_Montero</h1>
	<div class="centrar-form">
		<form action="<%=request.getContextPath()%>/ServletLogin"
			method="post">
			<input id="user" size="25" name="nombre" type="text"
				placeholder="Introduce nombre de usuario"> <br> <input
				id="password" size="25" name="contrasena" type="password"
				placeholder="Introduce contraseña"> <br> <input
				id="boton-login" name="login" value="Iniciar sesion" type="submit">
		</form>
	</div>
</body>
</html>