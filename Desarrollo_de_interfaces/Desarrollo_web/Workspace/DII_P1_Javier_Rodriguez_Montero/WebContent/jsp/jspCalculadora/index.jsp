<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="clases.Calculo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CALCULADORA</title>
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
		<form action="<%=request.getContextPath()%>/calculadora" method="post">
			<input name="operando1" type="number" placeholder="Introduce primer operando">
			<select name="operacion">
			<!-- <option value="${item.key}" ${item.key == selectedDept ? 'selected="selected"' : ''}>${item.value}</option> -->
				<option value="1" selected>+</option>
				<option value="2">-</option>
				<option value="3">*</option>
				<option value="4">/</option>
			</select>
			<input name="operando2" type="number" placeholder="Introduce segundo operando">
			<input name="Calcular" value="Calcular" type="submit">
			<input name="limpiar" value="Limpiar" type="reset">
		</form>
			<br>
			<input disabled="disabled" name="resultado" type="number" value="<%= result %>">
	</body>
</html>