<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String siteName = request.getParameter("siteName");
	String name = request.getParameter("name");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	include Action의 Top입니다.<br>
	<%=siteName %><br>
	<%=name %><br>
</body>
</html>