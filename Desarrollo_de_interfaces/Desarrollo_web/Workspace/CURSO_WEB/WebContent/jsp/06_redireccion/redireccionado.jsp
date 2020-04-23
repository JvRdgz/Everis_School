<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redireccion</title>
</head>
<body>

<% 
String mensaje = null; //(String) request.getAttribute("servletMsg");
//session.setAttribute("servletMsg", null);

try {
	mensaje = (String) request.getAttribute("servletMsg");
	
// 	if(mensaje==null) {
// 		mensaje = "";
// 	}
	//session.setAttribute("servletMsg", null);
	System.out.println("jsp:" + mensaje);
} catch(Exception e){
	//Imprime en pantalla el error que se ocasione 
	System.out.println(e.getMessage());
}
%>

Redireccionado otro: <%=mensaje %>

</body>
</html>