<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="regBean" class="chapter6.MemberBean" scope="page"/>
<jsp:setProperty name="regBean" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 확인</title>
</head>
<body>
	<table width="80%" align="center" border="0" cellspacing="0" cellpadding="5">
		<tr>
			<td align="center" valign="middle" bgcolor="#FFFFCC">
			<table width="90%" border="1" cellspacing="0" cellpadding="2" align="center">
				<form name="regForm" method="post" action="memberInsert.jsp">
					<tr align="center" bgcolor="#996600">
					<td colspan="3">
						<font color="#FFFFFF">
							<b>
							<%=regBean.getName() %>
							<jsp:getProperty name="regBean" property="name" />
							회원님이 작성하신 내용입니다. 확인해 주세요.
							</b>
						</font>
					</td>
				</form>
			</table>
		</tr>
	</table>
</body>
</html>