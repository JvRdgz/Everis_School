<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!</h1>
	<p>
		<a href="<%=request.getContextPath()%>MiPrimerServlet?nombre=Javier&apellido=Rodriguez&edad=22">This is a reference</a>
	</p>
</body>
</html>