package jspEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BorderInsert
 */
@WebServlet("/jspEx/borderinsert")
public class BorderInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String border_title = "",
				writer_name = "",
				content_textarea = "";
		if(request.getParameter("border_title") != null)
		border_title = request.getParameter("border_title");
		if(request.getParameter(border_title) != null)
		writer_name = request.getParameter("user_name");
		
		content_textarea = request.getParameter("content_textarea");
		
		if(request.getParameter("submitFlag").equals("true")) {
			BorderDtlBean bean = new BorderDtlBean();
			bean.setBorder_title(border_title);
			bean.setWriter_name(writer_name);
			bean.setBorder_content(content_textarea);
			bean.setWriter_ip(request.getRemoteHost());
			
			BorderMgrPool borderMgrPool = new BorderMgrPool();
			boolean insertFlag = borderMgrPool.borderInsert(bean);
			if(insertFlag == true) {
				response.sendRedirect("border");
				return;
			}
		}
		
		HttpSession session = request.getSession();
		UserBean sessionBean = (UserBean)session.getAttribute("userBean");
		if(sessionBean == null) {
			request.getRequestDispatcher("header_login.jsp").include(request, response);
		}else {
			request.setAttribute("name", sessionBean.getUser_name());
			request.getRequestDispatcher("header_logout.jsp").include(request, response);
		}
		request.getRequestDispatcher("borderinsert.jsp").include(request, response);
		request.getRequestDispatcher("footer.jsp").include(request, response);
	}
}
