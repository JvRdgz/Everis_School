<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="clases.Calculo"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="../css/calculadora_style_sheet.css">
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
				placeholder="Introduce segundo operando"> <br> <input id="boton-calcular"
				name="Calcular" value="Calcular" type="submit"> <input id="boton-limpiar"
				name="limpiar" value="Limpiar" type="reset"> <br> <input
				id="result-final" size="25" disabled="disabled" name="resultado"
				type="number" value="<%=result%>">
		</form>
	</div>
</body>
</html>