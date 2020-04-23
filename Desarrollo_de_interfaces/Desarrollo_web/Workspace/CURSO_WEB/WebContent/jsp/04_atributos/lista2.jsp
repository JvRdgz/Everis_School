<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<input value="${nombre}" />
<br>

<c:forEach items="${alumnos}" var="alumno">
	${alumno.nombre} 
	${alumno.apellidos}
	<c:out value="${alumno.telefono}"/>
	<br>
</c:forEach>

</body>
</html>