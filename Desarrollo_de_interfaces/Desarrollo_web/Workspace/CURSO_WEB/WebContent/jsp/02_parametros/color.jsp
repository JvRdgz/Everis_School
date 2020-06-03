<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Scriptlets JSP</title>
	<%
		String bgColor = request.getParameter("bgColor");
		boolean hayColor = false;
		if (bgColor!=null) 
			hayColor=true; 
		else {
			//hayColor=false;
			bgColor="WHITE";
		}
	%>
</head>
<body BGCOLOR="<%=bgColor%>">
<H1>Ejemplo de scriptlets JSP</H1>
<%
	if (hayColor) 
		out.println("<b>Se ha utilizado el color</b>: " + bgColor);
	else
		out.println("Se ha utilizado el color por defecto: WHITE");
%>

<%
	if (hayColor) {
%>
		<b>Se ha utilizado el color</b>: <%=bgColor%>
<%	
	}
	else {
%>
		Se ha utilizado el color por defecto: <%=bgColor%>
<%	
	}
%>
</body>
</html>