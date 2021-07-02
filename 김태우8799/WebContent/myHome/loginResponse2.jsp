<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myhome.LoginData"  %>
<jsp:useBean id="user" class="myhome.UserData"></jsp:useBean>
<%
	   request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		LoginData login = LoginData.getLoginData();
		user.setId(login.getUser(id, pwd).getId());
		user.setPwd(login.getUser(id, pwd).getPwd());

	if(user.getId().equals(id)){
		if(user.getPwd().equals(pwd)){
%>
			<jsp:forward page="index.jsp"></jsp:forward>	
<%
		}else{
%>
 		<script>
 				alert("비밀번호가 틀렸습니다. 다시 입력해 주세요.");
 				histroy.back();
 		</script>
 <% 
		}
	}	
 %>
 <jsp:forward page="join.jsp">
		<jsp:param value="<%=id %>" name="loginId"/>
	</jsp:forward>	

	
</body>
</html>