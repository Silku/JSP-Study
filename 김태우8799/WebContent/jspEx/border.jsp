<%@page import="jspEx.BorderDtlBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <main>
        <!-- 깃테스트용!!!! -->
            <article class="border_contain">
                <div class="border_header"><h1><i class="fas fa-align-left" id="border_icon"></i> 게 시 글</h1></div>
                <div class="border_body">
                    <table class="border_table">
                        <tr class="row_header">
                           <th class="border_index">번호</th>
                           <th class="border_title">제목</th>
                           <th class="border_writer">작성자</th>
                           <th class="border_date">작성일</th>
                           <th class="border_count">조회수</th> 
                        </tr>
              			<%
              				ArrayList<BorderDtlBean> borderList = (ArrayList<BorderDtlBean>)request.getAttribute("borderList");
              				for(int i = 0; i< borderList.size(); i++){
              					BorderDtlBean bean = borderList.get(i);
              			%>
                        <tr>
                            <td class="border_index"><%=bean.getBorder_code() %></td>
                            <td class="border_title"><a href="borderdtl?border_code=<%=bean.getBorder_code()%>"><%=bean.getBorder_title() %></a></td>
                            <td class="border_writer"><%=bean.getWriter_name() %></td>
                            <td class="border_date"><%=bean.getBorder_date() %></td>
                            <td class="border_count"><%=bean.getBorder_count() %></td>
                        </tr>
                        <%
                        }
                        %>
                    </table>
                </div>
                <div class="border_footer">
                    <div class="this_page">
                        <span><%= request.getAttribute("page")%></span> / <span><%= request.getAttribute("totalPage")%></span> pages
                    </div>
                    <div class="select_page">
                    	<%
                    		int prePage = ((Integer)request.getAttribute("pageStart") - 1 == 0 ? 1: (Integer)request.getAttribute("pageStart") -1);
                    		int nextPage = ((Integer)request.getAttribute("pageEnd")-1 == (Integer)request.getAttribute("totalPage") ? (Integer)request.getAttribute("pageEnd")-1 : (Integer)request.getAttribute("pageEnd")) ;
                    	%>
                        <span><a href=border?page=<%=prePage%>><i class="fas fa-angle-left"></i></a></span>
                        <%
                        	for(int i = (Integer)request.getAttribute("pageStart"); i < (Integer)request.getAttribute("pageEnd"); i++){
                        %> 
                        <span><a href=border?page=<%=i%>><%=i%></a></span>
                        <%
                        	}
                        %>
                        <span><a href=border?page=<%=nextPage%>><i class="fas fa-angle-right"></i></a></span>
                        
                    </div>
                </div>

            </article>
        </main>