<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="curso.servlets04.atributos.Alumno" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Alumno> listado_alumnos = (ArrayList<Alumno>) request.getAttribute("alumnos");
String nombre = (String) request.getAttribute("nombre");

if(listado_alumnos!=null) {
	for(int i=0; i<listado_alumnos.size(); i++) {
%>

	<%= listado_alumnos.get(i).getNombre() %> <%=listado_alumnos.get(i).getApellidos()%>
<br>

<%	
	}
}
%>

<%= nombre %> 
<%--
<%
ArrayList<Alumno> listado_alumnos2 = (ArrayList<Alumno>) request.getAttribute("alumnos");

if(listado_alumnos2!=null) {
	for(int i=0; i<listado_alumnos2.size(); i++) {

		out.println(listado_alumnos2.get(i).getNombre());
		out.println(listado_alumnos2.get(i).getApellidos());
	}
}
%>
--%>
</body>
</html>