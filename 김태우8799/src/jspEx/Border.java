package jspEx;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Border
 */
@WebServlet("/jspEx/border")
public class Border extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		BorderMgrPool borderMgrPool = new BorderMgrPool();
		
		ArrayList<BorderDtlBean> borderDtlList = null;		
		if(request.getAttribute("searchBorderList") == null) {
			borderDtlList = borderMgrPool.getBorderList();
		}else {
			borderDtlList = (ArrayList<BorderDtlBean>)request.getAttribute("searchBorderList");
		}
		

// mysql db에서 가져온 데이터 모든 갯수		
		ArrayList<BorderDtlBean> borderList = new ArrayList<BorderDtlBean>();
//	이 부분은 페이지당 게시물 갯수를 가져올 부분의 어레이리스트
		int totalListCount = borderDtlList.size();
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//List 게시물 처리 알고리즘--------------------------------
		int indexStart = (page-1)*10; 
		int indexEnd = page*10;
		
//		(page-1)*10   , 1페이지에서는 0부터 시작하고 2페이지부터는 10부터 시작할수 있게 공식짜줌.
		
		for(int i = indexStart; i< indexEnd && i < totalListCount; i++) {
			borderList.add(borderDtlList.get(i));
		}
	
		
		//pageNunmber 페이지 넘버 알고리즘-------------------------------------------
//		삼항 연산자 활용
		int totalPage = (totalListCount%10 == 0 ? totalListCount/10 : totalListCount/10 + 1);
		int pageStart = (page%5 == 0 ? page -4 :  page - (page%5) + 1);
		int pageEnd = (pageStart+4 <= totalPage ? pageStart+4 : totalPage);

//		***이 부분 JSP 스크립틀릿 태그 쓸때와 다름!! 아래는 jsp형식일때임, EL태그 쓸때는 jsp형식으로 할때 1값 더줬던걸 없애버림. 
//		int pageEnd = (pageStart+4 <= totalPage ? pageStart+4 : totalPage) + 1;
//      ***		
		request.setAttribute("borderList", borderList);
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageStart", pageStart);
		request.setAttribute("pageEnd", pageEnd);
	
		
		HttpSession session = request.getSession();
		UserBean sessionBean = (UserBean)session.getAttribute("userBean");
		if(sessionBean == null) {
			request.getRequestDispatcher("header_login.jsp").include(request, response);
		}else {
			request.setAttribute("name", sessionBean.getUser_name());
			request.getRequestDispatcher("header_logout.jsp").include(request, response);
		}
		request.getRequestDispatcher("border.jsp").include(request, response);
		request.getRequestDispatcher("footer.jsp").include(request, response);
		
	}

}
