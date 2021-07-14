<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("user_id");
		boolean result = false;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div>
			<%=id %><br>
			<%
			if(result){
					out.println("사용가능한 아이디입니다.");
			}else{
				out.println("이미 존재하는 아이디입니다.");
			}
			%>
			<br>
			<button onClick = "self.close()">닫기</button>
		</div>
</body>
</html>