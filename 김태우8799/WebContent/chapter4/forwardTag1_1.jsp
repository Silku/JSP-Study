<%@page contentType="text/html;charset=UTF-8"%>
<%
	   request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
%>
<html>
<body>
<h1>Forward Tag Example1</h1>
Forward Tag의 포워딩 되기 전의 페이지입니다.
<%
	if(id.equals("korea	")){
		if(pwd.equals("1234")){
%>
			<jsp:forward page="forwardTag1_2.jsp">
				<jsp:param name="name" value="코리아"/>
			</jsp:forward>
<%
		}
	}
%>
	<script>
		history.back();
	</script>

</body>
</html>