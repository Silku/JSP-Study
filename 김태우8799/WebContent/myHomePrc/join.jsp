<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <script src="https://kit.fontawesome.com/c3df4d7d1c.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/join_style.css" />
</head>
<body>
    <div id="container">
        <header id="mainheader">
            <nav id="join_navbar">
                <!-- 로고(로고이미지, 홈페이지 이름) -->
                <!-- 메뉴(자기소개, 게시글) -->
                <!-- 링크(로그인, 회원가입) -->
                <a href="index.html" id="mainlogo"><i id="logo" class="fab fa-adn"></i> Junil blog</a>
            </nav>
        </header>
        <main>
            <form id="joinform" action="joinProc" method="post">
                <div id="join_content">
                    <div class="join_items">
                        <label class="join_label">아이디</label>
                        <span class="join_input">
                        	<input type="hidden" id="idstatus" name="idstatus" value="<%=request.getParameter("idstatus") %>">
                            <input type="text" id="id_text" class="join_text" name="user_id" value="<%=request.getParameter("user_id") %>" >
                            <span class="join_input_text">@naver.com</span>
                        </span>
                        <div id="id_warning" class="join_warning">
                            <p class="warning_text">필수 정보입니다.</p>
                        </div>
                    </div>
                    <div class="join_items">
                        <label class="join_label">비밀번호</label>
                        <span class="join_input">
                            <input type="password" class="join_text" id="pwd_text" name="user_pwd">
                            <span class="join_input_text"></span>
                        </span>
                        <div class="join_warning">
                            <p class="warning_text">필수 정보입니다.</p>
                        </div>
                    </div>
                    <div class="join_items">
                        <label class="join_label">비밀번호 재확인</label>
                        <span class="join_input">
                            <input type="password" class="join_text" id="repwd_text" name="user_repwd">
                            <span class="join_input_text"></span>
                        </span>
                        <div class="join_warning">
                            <p class="warning_text">필수 정보입니다.</p>
                        </div>
                    </div>
                    <div class="join_items">
                        <label class="join_label">이름</label>
                        <span class="join_input">
                            <input type="text" class="join_text" id="name_text" name="user_name">
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
                                    <input type="text" class="join_text" id="birth_year" name="user_year">
                                </span>
                            </div>
                            <div class="bir_mm">
                                <span class="ps_box">
                                    <select class="bir_select" id="birth_month" name="user_month">
                                        <option value="0">월</option>
                                        <option value="01">1</option>
                                        <option value="02">2</option>
                                        <option value="03">3</option>
                                        <option value="04">4</option>
                                        <option value="05">5</option>
                                        <option value="06">6</option>
                                        <option value="07">7</option>
                                        <option value="08">8</option>
                                        <option value="09">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                </span>
                            </div>
                            <div class="bir_dd">
                                <span class="ps_box">
                                    <input type="text" class="join_text" id="birth_day" name="user_day">
                                </span>
                            </div>
                        </div>
                        <div class="join_warning">
                            <p class="warning_text">필수 정보입니다.</p>
                        </div>
                    </div>
					<input type="hidden" id="submitflag" name="submitflag" value="false"> 
                    <button type="button" class="join_button">
                        <span class="button_text">가입하기</span>
                    </button>
                </div>
            </form>
        </main>
        <footer>
            <div id="foot">
                <!-- 이름, 연락처, 주소, 이메일 -->
                <ul>
                    <li>이름: 김준일</li>
                    <li>연락처: 010-9988-1916</li>
                    <li>주소: 부산 동래구 명륜로</li>
                    <li>이메일: skjil1218@kakao.com</li>
                </ul>
            </div>
        </footer>
    </div>
	<script>
		const submitflag = document.querySelector("#submitflag");
	
		const id_text = document.querySelector("#id_text");
		const joinform = document.querySelector("#joinform");
		id_text.onblur = () => {
			joinform.submit();
		}
		const idstatus = document.querySelector("#idstatus");
		if(idstatus.value == "true"){
			alert(id_text.value + "(은)는 이미 존재하는 아이디 입니다.");
			id_text.value="";
		}
		
		const submitbtn = document.querySelector(".join_button");
		const pwd_text = document.querySelector("#pwd_text");
		const repwd_text = document.querySelector("#repwd_text");
		const name_text = document.querySelector("#name_text");
		const birth_year = document.querySelector("#birth_year");
		const birth_month = document.querySelector("#birth_month");
		const birth_day = document.querySelector("#birth_day");
		
		
		submitbtn.onclick = () => {
			if(idstatus.value == "true"){
				alert(id_text.value + "(은)는 이미 존재하는 아이디 입니다.");
				return;
			}else if(id_text.value == "" || id_text.value == null){
				alert("아이디를 입력해 주세요.");
				return;
			}else if(pwd_text.value == null || pwd_text.value == ""){
				alert("비밀번호는 공백을 입력할 수 없습니다.");
				return;
			}else if(repwd_text.value == null || repwd_text.value == ""){
				alert("비밀번호는 공백을 입력할 수 없습니다.");
				return;
			}else if(pwd_text.value != repwd_text.value){
				alert("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
				return;
			}else if(name_text.value == null || name_text.value == ""){
				alert("이름을 입력해 주세요.");
				return;
			}else if(birth_year.value == null || birth_year.value == ""){
				alert("년도를 입력해 주세요.(예: 2021)");
				return;
			}else if(birth_month.value == 0){
				alert("월을 선택해 주세요.");
				return;
			}else if(birth_day.value == null || birth_day.value == ""){
				alert("일자를 입력해 주세요.(예: 1 ~ 31)");
				return;
			}
			
			submitflag.value = "true";
			joinform.submit();
		}
		
		
	</script>
</body>
</html>










