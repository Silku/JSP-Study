<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <main>
        <!-- EL태그를 적용한 형식의 border파일, 기존 스크립틀릿태그는 다 지워짐! -->
        <!-- 일일히 다 고치기 힘들어서 jsp파일은 border(jsp style backup).jsp로 백업해둠!,  java scr내에 border.java에도 변경사항있음 ! -->
            <article class="border_contain">
                <div class="border_header"><h1><i class="fas fa-align-left" id="border_icon"></i> 게 시 글</h1></div>
                <c:choose>
                	<c:when test="${empty userBean }">
                		<c:set var="display" value="none"></c:set>
                	</c:when>
                	<c:otherwise>
                		<c:set var="display" value="flex"></c:set>
                	</c:otherwise>
                </c:choose>
                <div class="border_insert_button" style="display:${display };">
                	<button onclick="location.href='borderinsert'">글쓰기</button>
                </div>
                <div class="border_body">
                    <table class="border_table">
                        <tr class="row_header">
                           <th class="border_index">번호</th>
                           <th class="border_title">제목</th>
                           <th class="border_writer">작성자</th>
                           <th class="border_date">작성일</th>
                           <th class="border_count">조회수</th> 
                        </tr>
              			<c:forEach var = "bean" items="${borderList }">
	              			<tr>
	                        	<td class="border_index">${bean.border_code }</td>
	                            <td class="border_title"><a href="borderdtl?border_code=${bean.border_code }&page=${page}">${bean.border_title }</a></td>
	                            <td class="border_writer">${bean.writer_name }</td>
	                            <td class="border_date">${bean.border_date }</td>
	                            <td class="border_count">${bean.border_count }</td>
	                        </tr>
              			</c:forEach>

                    </table>
                </div>
                <div class="border_footer">
                    <div class="this_page">
                   		<span>${page }</span> / <span>${totalPage }</span> pages
                        <!-- 위는 EL태그를 사용한 표현식 아래는 jsp의 표현식 -->
                        <!-- <span><%= request.getAttribute("page")%></span> / <span><%= request.getAttribute("totalPage")%></span> pages -->
                    </div>
                    <div class="select_page">
                    	<%
                    		/*
                    	 	아래는 jsp형태로 사용할때의 변수 선언
                    		int prePage = ((Integer)request.getAttribute("pageStart") - 1 == 0 ? 1: (Integer)request.getAttribute("pageStart") -1);
                    		int nextPage = ((Integer)request.getAttribute("pageEnd")-1 == (Integer)request.getAttribute("totalPage") ? (Integer)request.getAttribute("pageEnd")-1 : (Integer)request.getAttribute("pageEnd")) ;
                    		*/
                    	%>
                        <span><a href=border?page=${pageStart - 1 eq 0 ? 1 : pageStart- 1}><i class="fas fa-angle-left"></i></a></span>
                        <c:forEach var ="i" begin="${pageStart}" end="${pageEnd }">
							<span><a href=border?page=${i }>${i }</a></span>
                        </c:forEach>

                        <span><a href=border?page=${pageEnd-1 eq totalPage ? pageEnd : pageEnd+1}><i class="fas fa-angle-right"></i></a></span>
                        
                    </div>
                    <div class="search">
                    	<form method="get" action="borderSearch">
                    	<select name="searchFilter">
                    		<option value="all">전체</option>
                    		<option value="title">제목</option>
                    		<option value="content">내용</option>
                    		<option value="writer">작성자</option>
                    	</select>
                    	<input type="search" name ="border_search"><button type ="submit">검색</button>
                    	</form>
                    </div>
                </div>

            </article>
        </main>