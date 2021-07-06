<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="80%" align="center" border="0" cellspacing="0" cellpadding="5">
	<tr>
		<td align="center" valign="middle" bgcolor="#FFFFCC">
			<table width="90%" border="1" cellspacing="0" cellpadding="2" align="center">
				<form name = "regForm" method="post" action="registerProc.jsp">
					<tr>
						<td colspan="3"><font color="#FFFFFF"><b>회원 가입</b></font></td>
					</tr>
					<tr>
						<td width="100">아이디</td>
						<td width="200"><input name="id" size="15"></td>
						<td width="200">아이디를 입력해 주세요.</td>
					</tr>
					<tr>
						<td>패스워드</td>
						<td><input type="password" name="pwd" size="15"></td>
						<td>패스워드를 입력해 주세요.</td>
					</tr>
					<tr>
						<td>패스워드 확인</td>
						<td><input type="password" name="repwd" size="15"></td>
						<td>패스워드를 확인합니다.</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input name="name" size="15"></td>
						<td>이름을 입력해주세요.</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input name="birthday" size="27"></td>
						<td>생년월일을 입력해주세요.</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name="email" size="20"></td>
						<td>이메일을 입력해주세요.</td>
					</tr>
					<tr>
						<td colspan="3" align="center">
							<input type="button" value="회원가입 " onclick="inputCheck()"> 
							<input type="reset" value="다시쓰기">
						</td>
					</tr>
				</form>
			</table>	
		</td>
	</tr>
	</table>
	<script>
		function inputCheck(){
			if(document.regForm.id.value==""){
				alert("아이디를 입력해 주세요");
				document.regForm.id.focus();
				return;
			}
			if(document.regForm.pwd.value==""){
				alert("비밀번호를 입력해 주세요");
				document.regForm.pwd.focus();
				return;
			}
			if(document.regForm.repwd.value==""){
				alert("비밀번호확인을 입력해 주세요");
				document.regForm.repwd.focus();
				return;
			}
			if(document.regForm.repwd.value!=document.regForm.pwd.value){
				alert("비밀번호가 서로 일치하지 않습니다.");
				document.regForm.repwd.focus();
				return;
			}
			if(document.regForm.name.value==""){
				alert("이름을 입력해 주세요");
				document.regForm.name.focus();
				return;
			}
			if(document.regForm.birthday.value==""){
				alert("생일을 입력해 주세요");
				document.regForm.birthday.focus();
				return;
			}
			if(document.regForm.email.value==""){
				alert("email을 입력해 주세요");
				document.regForm.email.focus();
				return;
			}
			document.regForm.submit();
		}
	</script>
</body>
</html>