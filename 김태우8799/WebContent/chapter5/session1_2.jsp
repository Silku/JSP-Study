<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String id = (String)session.getAttribute("idKey");
	String name = request.getParameter("name");
	SimpleDateFormat formatter = (SimpleDateFormat)session.getAttribute("formatter");
	long lastTime = session.getLastAccessedTime(); //마지막 클라이언트의 요청시간.
	long creatTime = session.getCreationTime(); //세션이 생성되 시간.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(id != null){
%>
	<%=name %>님의 정보입니다.
	세션이 생성된 시간 : <%=creatTime %>
	클라이언트의 마지막 요청시간 : <%=lastTime %>
<%
	}else{
%>
	세션이 만료되었습니다. 다시 로그인하십시오.
<%
	}
%>
</body>
</html>


