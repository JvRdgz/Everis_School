<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculadora</title>
</head>
<body>

<% 
String operando1 = (String)request.getAttribute("operando1");
if(operando1==null) {
	operando1 = "";
}

String operando2 = (String)request.getAttribute("operando2");
if(operando2==null) {
	operando2 = "";
}
String mensaje = (String) request.getAttribute("result");
if(mensaje==null) {
	mensaje="";
}

%>

<form action="<%=request.getContextPath()%>/calcular" method="get">
	<!-- 
	Operando 1: <input name="operando1" type="text">
	-->
	Operando 1: <input name="operando1" type="text" value="<%= operando1 %>">

	<select name="operacion">
		<option value="1" selected>+</option>
		<option value="2">-</option>
		<option value="3">*</option>
		<option value="4">/</option>
	</select>
	
	Operando 2: <input name="operando2" type="text" value="<%= operando2 %>">
	
	<input name="calcular" value="Calcular" type="submit">
	<input name="limpiar" value="Limpiar" type="reset">

</form>

<br>
<input name="resultado" type="text" value="<%= mensaje %>" disabled="disabled">

</body>
</html>