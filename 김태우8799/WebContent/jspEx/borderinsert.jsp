<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <main>
            <form id="borderinsertform" method="post" action="borderinsert">
                <article class="border_contain">
                    <div class="border_header"><h1><i class="fas fa-align-left" id="border_icon"></i> 게 시 글</h1></div>
                    <div class="border_body">
                        <table class="borderDtl_table">
                            <tr> 
                                <th>제목</th>
                                <td colspan="3">
                                    <input type ="text" class="border_text" name="border_title">
                                </td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <input type="hidden" name="user_name" value="${userBean.user_name }">
                                <td>${userBean.user_name }</td>
                                <th>첨부파일</th>
                                <td>test</td>
                            </tr>
                        </table>
                        <div>
                            <textarea class="content_textarea" name="content_textarea"></textarea>
                        </div>
                        <div class="border_button">
                        	<input type="hidden" id="submitFlag" name="submitFlag" value="false">
                            <button id ="insertButton">작성하기</button>
                            <button type="reset">다시작성</button>
                        </div>
                    </div>
                </article>
            </form>
        </main>