<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언문 -->
	<%!
		int data = 50;
	%>
	<!-- 스크립트릿 -->
	<%
		out.println("Value of the variable is " + data);
	%>
</body>
</html>