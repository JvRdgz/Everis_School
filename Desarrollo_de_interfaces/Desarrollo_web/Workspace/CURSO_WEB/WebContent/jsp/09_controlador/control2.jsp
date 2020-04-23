<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control 2</title>
</head>
<body>


<form action="<%=request.getContextPath()%>/controlador" method="get">
	<!-- Operando 1: <input name="operando1" type="text">-->

	<br>
	Usuario: <input name="user" type="text" value="">
	<br>
	<input type="hidden" name="origen" value="control2.jsp" />
	<input name="entrar" value="Entrar" type="submit">
	<input name="limpiar" value="Limpiar" type="reset">

</form>

</body>
</html>