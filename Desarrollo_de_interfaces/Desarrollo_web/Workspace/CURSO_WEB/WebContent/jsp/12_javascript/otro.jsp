<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Pregunta</title>
	
	<%
	String nombre = (String) request.getAttribute("nombre");
	%>
	
	<script type="text/javascript">
		function responder() {
			var respuesta = document.getElementById('respuesta');
			var resultado = document.getElementById('resultado');
			
			if(respuesta.value==="<%= nombre %>")
				resultado.innerHTML = "Correcto";
			else {
				resultado.innerHTML = "NO es correcto";
			}
		}
	</script>
</head>
<body>

	<input type="text" id="respuesta" placeholder="responda aquí">
	<button type="button" onclick="responder()">consultar</button>

	<div id="resultado"></div>

</body>
</html>