<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><% out.print(session.getAttribute("questionNumber")); %>
<form action="direct" method="get">
<input type="text" name="input1"/>
<input type="text" name="input2"/>
<button type="submit">assign</button>
</form>

</body>
</html>