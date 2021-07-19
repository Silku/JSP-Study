<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Junil blog</title>
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/border.css">
</head>
<body>
    <div id="container">
        <header id="mainheader">
            <nav id="navbar">
                <!-- 로고(로고이미지, 홈페이지 이름) -->
                <!-- 메뉴(자기소개, 게시글) -->
                <!-- 링크(로그인, 회원가입) -->
                <a href="index" id="mainlogo"><i id="logo" class="fab fa-adn"></i> Junil blog</a>
                <ul> 
                    <a href="#"><li>블로그 소개</li></a>
                    <a href="border"><li>게시글</li></a>
                </ul>
                <div>
                    <a href="<%=request.getAttribute("user_name") %>" class="__links">로그인</a>
                    <a href="join" class="__links">회원가입</a>
                </div>
                
            </nav>
        </header>