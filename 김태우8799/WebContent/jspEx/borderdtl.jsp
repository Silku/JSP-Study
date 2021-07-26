<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <main>
            <article class="border_contain">
                <div class="border_header"><h1><i class="fas fa-align-left" id="border_icon"></i> 게 시 글</h1></div>
                <div class="border_body">
                    <table class="borderDtl_table">
                        <tr> 
                            <th>제목</th>
                            <td colspan="3">${contentBean.border_title }</td>
                        </tr>
                        <tr>
                            <th>작성일</th>
                            <td colspan="3">${contentBean.border_date }</td>
                        </tr>
                        <tr>
                            <th>작성자</th>
                            <td>${contentBean.writer_name }</td>
                            <th>조회수</th>
                            <td>${contentBean.border_count }</td>
                        </tr>
                        <tr>
                            <th>첨부파일</th>
                            <td colspan="3">test</td>
                        </tr>
                    </table>
                    <pre class ="border_content">${contentBean.border_content }</pre>
                    <div class="border_button">
                        <button onclick="location.href='border?page=${page }'">목록</button>
                    </div>
                    <table class="borderDtl_table">
                        <tr>
                            <th>이전글</th>
                            <td class="footer_td" colspan="3"><a href="borderdtl?border_code=${preBean.border_code }&page=${page }">${preBean.border_title }</a></td>
                        </tr>
                        <tr>
                            <th>다음글</th>
                            <td class="footer_td" colspan="3"><a href="borderdtl?border_code=${nextBean.border_code }&page=${page }">${nextBean.border_title }</a></td>
                        </tr>
                    </table>
                </div>
            </article>
        </main>