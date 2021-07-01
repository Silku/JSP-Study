<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8"); //post 방식이기 때문에
	String name = "코리아 아이티 아카데미";
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Include Tag Example1</h1>
		<!-- 액션:form에서 submit이 되었을때 발생하는 동작 -->
		<jsp:include page="includeTagTop1.jsp"></jsp:include>
		IncludeTag의 body입니다.
</body>
</html>