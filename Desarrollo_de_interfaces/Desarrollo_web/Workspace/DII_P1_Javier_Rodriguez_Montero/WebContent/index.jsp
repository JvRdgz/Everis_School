<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="clases.Calculo"%>
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

#op1 {
	padding: 10px;
	margin: 53px;
	border-radius: 10px;
	border-color: #94b7ff;
	color: #ffffff;
	background-color: #4664a0;
	font-family: Arial, Helvetica, sans-serif;
	font-style: italic;
}

#operador {
	padding: 5px;
	margin: auto;
	color: #003aad;
}

#op2 {
	padding: 10px;
	margin: 53px;
	border-radius: 10px;
	border-color: #94b7ff;
	font-family: Arial, Helvetica, sans-serif;
	font-style: italic;
	color: #ffffff;
	background-color: #4664a0;
}

#boton-calcular {
	font-family: Arial, Helvetica, sans-serif;
	color: #003aad;
}

#boton-limpiar {
	font-family: Arial, Helvetica, sans-serif;
	color: #003aad;
}

#result-final {
	padding: 10px;
	margin: 53px;
	border-radius: 10px;
	border-color: #94b7ff;
	font-family: Arial, Helvetica, sans-serif;
	font-style: normal;
	color: #ffffff;
	background-color: #4664a0;
}
</style>
<!-- <link rel="stylesheet" type="text/css"
	href="../css/calculadora_style_sheet.css"> -->
<meta charset="UTF-8">
<title>Calculadora</title>
</head>
<body>
	<%
		/*
	String operando1 = (String)request.getAttribute("operando1");
	if(operando1==null) {
	operando1 = "";
	}
	String operacion = (String)request.getAttribute("operacion");
	if(operacion==null) {
	operacion = "";
	}
	String operando2 = (String)request.getAttribute("operando2");
	if(operando2==null) {
	operando2 = "";
	}
	*/
	String result = (String) request.getAttribute("resultado");
	%>
	<h1>DII_P1_Javier_Rodriguez_Montero</h1>
	<div class="centrar-form">
		<form action="<%=request.getContextPath()%>/calculadora" method="post">
			<input id="op1" size="25" name="operando1" type="number"
				placeholder="Introduce primer operando"> <br> <select
				id="operador" name="operacion">
				<!-- <option value="${item.key}" ${item.key == selectedDept ? 'selected="selected"' : ''}>${item.value}</option> -->
				<option value="1" selected>+</option>
				<option value="2">-</option>
				<option value="3">*</option>
				<option value="4">/</option>
			</select> <br> <input id="op2" size="25" name="operando2" type="number"
				placeholder="Introduce segundo operando"> <br> <input
				id="boton-calcular" name="Calcular" value="Calcular" type="submit">
			<input id="boton-limpiar" name="limpiar" value="Limpiar" type="reset">
			<br> <input id="result-final" size="25" disabled="disabled"
				name="resultado" type="number" value="<%=result%>">
		</form>
	</div>
</body>
</html>