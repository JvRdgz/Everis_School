<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
</head>
<body>

	<form action="../../form" method="get">
		<input type="text" name="nombre" placeholder="Introduce tu usuario">
		<input type="password" name="pass" placeholder="Introduce tu contraseña">
		<input type="hidden" name="oculto" value="mi valor" />
		<input type="submit" name="boton" value="Enviar por GET">
	</form>
	<br>
	<form action="<%=request.getContextPath()%>/form" method="post">
		<input type="text" name="nombre" value="Introduce tu usuario">
		<input type="password" name="pass" placeholder="Introduce tu contraseña">
		<input type="hidden" name="oculto" value="mi valor" />
		<input type="submit" name="boton" value="Enviar por POST">
	</form>

</body>
</html>