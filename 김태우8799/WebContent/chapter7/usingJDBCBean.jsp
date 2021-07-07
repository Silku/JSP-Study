<%@ page import= "chapter7.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="regMgr" class="chapter7.RegisterMgr"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<RegisterBean> list= regMgr.getRegisterList();
	for(int i =0; i < list.size(); i++){
		RegisterBean bean = list.get(i);
%>
					id : <%=bean.getId() %><br>
					pwd : <%=bean.getPwd() %><br>
					name : <%=bean.getName() %><br>
					num1 : <%=bean.getNum1() %><br>
					num2 : <%=bean.getNum2() %><br>
					email : <%=bean.getEmail() %><br>
					phone : <%=bean.getPhone() %><br>
					zipcode : <%=bean.getZipcode() %><br>
					address : <%=bean.getAddress() %><br>
					createdate : <%=bean.getCreatedate() %><br>
					updatedate : <%=bean.getUpdatedate() %><br>	
					<hr>
<%
	}
%>
</body>
</html>