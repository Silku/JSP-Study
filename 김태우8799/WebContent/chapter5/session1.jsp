<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
    <%
    	request.setCharacterEncoding("UTF-8");
    	
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	
    	session.setAttribute("idKey", id);
    	session.setMaxInactiveInterval(60);
    %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session example1</h1>
	<form method="post" action="session1_1.jsp">
		1.가장 좋아하는 계절은 <br>
		<input type="radio" name="season" value="봄">봄<br>
		<input type="radio" name="season" value="여름">여름<br>
		<input type="radio" name="season" value="가을">가을<br>
		<input type="radio" name="season" value="겨울">겨울<br>
		
		<input type="submit" value="결과보기">
	</form>
</body>
</html>