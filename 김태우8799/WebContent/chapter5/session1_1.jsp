<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        	
<%
	request.setCharacterEncoding("UTF-8");
    String season = request.getParameter("season");
    String id = (String)session.getAttribute("idKey");
    /**
    이 session이란것은 object도 넘길수 있고해서 String으로 다운캐스팅 해줌.
    **/
    String sessionId= session.getId();
    
    int intervalTime = session.getMaxInactiveInterval();
   
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 if(id != null){
%>
	<%=id %>님이 좋아하는 계절은 <%=season %>입니다.
	세션ID : <%=sessionId %>
	세션 유지 시간 : <%=intervalTime %>초
<%
	session.invalidate();
    }else{
%>
	 세션시간이 만료 되었습니다. 다시 로그인 하십시오.
<%  
	 }
%>	        
</body>
</html>