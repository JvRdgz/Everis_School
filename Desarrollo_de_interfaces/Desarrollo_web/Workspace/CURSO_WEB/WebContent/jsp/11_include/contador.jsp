<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%!
private int cont=0;
private Date fecha= new Date();
private String host="<I>Sin acceso previo</I>";
%>
<p>Esta página ha sido accedida <b><%= ++cont%></b> veces desde que
se inició el servidor.</p>
<p>El último acceso ha sido desde: <b><%=host%></b> con fecha
<b><%=fecha%></b></p>
<%
host=request.getRemoteHost();
fecha=new Date();
%>

</body>
</html>