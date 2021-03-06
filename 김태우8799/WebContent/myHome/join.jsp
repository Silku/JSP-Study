<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/7b49269132.js" crossorigin="anonymous"></script>
    <link rel="styleSheet" href="css/style.css">
    <link rel="styleSheet" href="css/join_style.css">

    <title>TW's MyHome</title>
</head>

<body>
    <div id=container>
        <header id="mainHeader">
            <nav id="join_navbar">
                <!-- 로고(로고이미지,홈페이지 이름),메뉴(자기소개, 게시글),링크(로그인,회원가입) -->
                <a href="index.html" id="mainlogo"> <i id="logo" class="fab fa-microblog"></i> TW's Blog</a>
            </nav>
        </header>   
        <form action="#" method="post">
            <!-- 네이버 회원가입 창을 본떠서 -->
            <div id="join_content">
                <h1 id = mainhello> 회원 가입 페이지</h1>
                <div class="join_items">
                    <label class="join_label">아이디</label>
                    <span class="join_input">
                        <input type="text" id="id_text" class="join_text" name="user_id">
                        <span class="join_input_text">@naver.com</span>
                    </span>
                    <div id="id_warning" class="join_warning">
                        <p class="warning_text">필수 정보입니다.</p>
                    </div>
                </div>
                <div class="join_items">
                    <label class="join_label">비밀번호</label>
                    <span class="join_input">
                        <input type="password" id="pwd_text" name="user_pwd" class="join_text">
                        <span class="join_input_text"></span>
                    </span>
                    <div class="join_warning">
                        <p class="warning_text">필수 정보입니다.</p>
                    </div>
                </div>
                <div class="join_items">
                    <label class="join_label" >비밀번호 재확인</label>
                    <span class="join_input">
                        <input type="password" class="join_text" name="user_repwd">
                        <span class="join_input_text"></span>
                    </span>
                    <div class="join_warning">
                        <p class="warning_text">필수 정보입니다.</p>
                    </div>
                </div>
                <div class="join_items">
                    <label class="join_label">이름</label>
                    <span class="join_input">
                        <input type="text" class="join_text">
                        <span class="join_input_text"></span>
                    </span>
                    <div class="join_warning">
                        <p class="warning_text">필수 정보입니다.</p>
                    </div>
                </div>
                <div class="join_items">
                    <label class="join_label">생년월일</label>
                    <div class="bir_warp">
                        <div class="bir_yy">
                            <span class="ps_box">
                                <input type="text" class="join_text" name="birth_year">
                            </span>
                        </div>
                        <div class="bir_mm">
                            <span class="ps_box">
                                <select class="bir_select" name="birth_month">
                                    <option value="0">월</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </span>
                        </div>
                        <div class="bir_dd">
                            <span class="ps_box">
                                <input type="text" class="join_text" name ="birth_day">
                            </span>
                        </div>
                    </div>
                    <div class="join_warning">
                        <p class="warning_text">필수 정보입니다.</p>
                    </div>
                </div>

                <button type="submit" class="join_button">
                    <span class="button_text">가입하기</span>
                </button>
            </div>
        </form>
        <footer>
            <div id="footer">
                <!-- 이름,연락처,주소,이메일 -->
                <ul>
                    <li>name : tw </li>
                    <li>phoneNum : 010-1234-5678</li>
                    <li>address : 부산광역시 부산진구 </li>
                    <li>e-Mail :koreaIT@korea.com </li>
                </ul>
            </div>
        </footer>
    </div>
    <script> 
    	const join_id = document.querySelector("id_text");
    	join_id.onBlur = () => {
    		alert("test");
    	}
    </script>
    <script src = "js/join.js"></script>
</body>

</html>