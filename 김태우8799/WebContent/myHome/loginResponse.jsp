<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myhome.LoginData"  %>
<%@ page import="myhome.UserData"  %>

<%
	   request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginData login = LoginData.getLoginData();
		UserData user = login.getUser(id,pwd);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if(user !=null){
%>
			<jsp:forward page="index.jsp"></jsp:forward>	
<%
	}else{
%>
		<jsp:forward page="join.jsp">
			<jsp:param value="<%=id %>" name="loginID"/>
		</jsp:forward>	
<%		
		}
%>

	
</body>
</html>