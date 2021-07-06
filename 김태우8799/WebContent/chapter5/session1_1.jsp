<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8");
	String season = request.getParameter("season");
	String id = (String)session.getAttribute("idKey");
	
	String sessionId = session.getId();
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	int intervalTime = session.getMaxInactiveInterval();
	long lastTime = session.getLastAccessedTime(); //마지막 클라이언트의 요청시간.
	long creatTime = session.getCreationTime(); //세션이 생성된 시간.
	session.setAttribute("formatter", formatter);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(id != null){
%>
	<%=id %>님이 좋아하는 계절은 <%=season %>입니다.
	세션 ID : <%=sessionId %>
	세션 유지 시간 : <%=intervalTime %>초
	세션이 생성된 시간 : <%=formatter.format(creatTime) %>
	클라이언트의 마지막 요청시간 : <%=formatter.format(lastTime) %>
	<form method = "post" action="session1_2.jsp">
		<input name = "name"><br>
		<input type = "submit" value = "다음">
	</form>
<%
	}else{
%>
	세션 시간이 만료되었습니다. 다시 로그인 하십시오.
<%
	}	

%>
</body>
</html>