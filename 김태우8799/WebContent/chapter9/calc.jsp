<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="calcC">
		<div>
			<label>입력 : </label>
			<input name ="v">
		</div>
		<div>
			<input type="submit" name="operator" value="+">
			<input type="submit" name="operator" value="-">
			<input type="submit" name="operator" value="=">
		</div>
		<div>
			결과 :0 
		</div>
	</form>
</body>
</html>