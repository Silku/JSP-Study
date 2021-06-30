<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>while example</h1>
		<%
			 request.setCharacterEncoding("UTF-8");
			 String msg = request.getParameter("msg");
			 int num = Integer.parseInt(request.getParameter("number"));
			 int count = 0;
			 while(count<num){
		%>
		<h3><%=msg %></h3><br>
		<%
					count++;
			 }
		%>
</body>
</html>