<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	String siteName = request.getParameter("siteName");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Include Tag Example2</h1>
	<jsp:include page="includeTagTop2.jsp">
		<jsp:param name="siteName" value="JSPStudy.co.kr"/>
		<jsp:param name="name" value="김준일"/>
	</jsp:include>
	include ActionTag의 Body입니다.<br>
	<b><%=siteName %></b>
	<hr/>
</body>
</html>