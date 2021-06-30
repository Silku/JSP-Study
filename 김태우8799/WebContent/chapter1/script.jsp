<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Script Example</h1>
	<%!
		String declaration = "Declaration";
	%>
	<%!
		public String decMethod(){
			return declaration;
	}
	%>
	<%
		String scriptlet = "Scriptlet";
		String comment ="Comment";
		out.println("내장객체를 이용한 출력: " +declaration+"<P>");
	%>
	선언문의 출력 1: <%=declaration %><br>
	선언문의 출력 2: <%=decMethod() %><br>
	스크립트릿의 출력: <%=scriptlet %><br>
	<!-- jsp주석 -->
	<%
		/*
		여러줄 주석
		*/
	%>
	<%
		// 한줄주석
	%>
</body>
</html>