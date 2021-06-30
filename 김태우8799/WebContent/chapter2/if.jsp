<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>if-else example</h1>
		<form method="post" action="if2.jsp">
				이름:<input type="text" name ="name"><br>
				좋아하는 색깔 : <select name="color">
					<option value="blue" selected>파란색</option>
					<option value="red" selected>빨간색</option>
					<option value="orange" selected>오렌지색</option>
					<option value="etc" selected>기타</option>
				</select><br>
				좋아하는 색깔 선택 : <input type="color" name="color2"><br>
				<input type="submit" value="보내기">
		</form>
</body>
</html>