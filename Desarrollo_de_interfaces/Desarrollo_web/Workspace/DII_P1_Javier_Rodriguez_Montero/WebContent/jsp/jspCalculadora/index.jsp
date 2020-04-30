<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CALCULADORA</title>
	</head>
	<body>
		<%
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
		String result = (String) request.getAttribute("result");
		if(result==null) {
			result="";
		}
		%>
		<form action="<%=request.getContextPath()%>/calcular" method="get">
			Operando1:<input name="operando1" type="text" value="<%= operando1 %>">
			<select name="operacion">
			<!-- <option value="${item.key}" ${item.key == selectedDept ? 'selected="selected"' : ''}>${item.value}</option> -->
				<option value="1" selected>+</option>
				<option value="2">-</option>
				<option value="3">*</option>
				<option value="4">/</option>
			</select>
			Operando2:<input name="operando2" type="text" value="<%= operando2 %>">
			<input name="Calcular" value="Calcular" type="submit">
			<input name="limpiar" value="Limpiar" type="reset">
		</form>
			<br>
			Result:<input name="Resultado" type="text" value="<%= result %>">
	</body>
</html>