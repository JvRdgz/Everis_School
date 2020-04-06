<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRYING SOME BACKGROUND COLOR SHIT WITH JSP</title>
</head>
	<%
		String bgColor = request.getParameter("bgColor");
		boolean isBgColor = false;
		
		if (bgColor != null)
			isBgColor = true;
		else
			// There is no color ==> isBgColor = false;
			bgColor = "White";
	%>
<body BGCOLOR="<%=bgColor%>">
	<%
		if (isBgColor)
			out.println("Color: " + bgColor + " has been used.");
		else
			out.println("No color has been used, so white color has been put it as default.");
	%>
</body>
</html>