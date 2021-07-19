package jspEx;

import java.io.IOException;
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserBean sessionBean = (UserBean)session.getAttribute("userBean");
		if(sessionBean == null) {
			request.getRequestDispatcher("header_logout.jsp").include(request, response);
		}else {			
			request.setAttribute("user_name", sessionBean.getUser_name());
			request.getRequestDispatcher("header_login.jsp").include(request, response);
		}
		request.getRequestDispatcher("border.jsp").include(request,response);
		request.getRequestDispatcher("footer_main.jsp").include(request,response);
	
	}

}
