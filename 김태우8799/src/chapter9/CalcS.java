package chapter9;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalcS
 */
@WebServlet("/chapter9/calcS")
public class CalcS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5);
//		session.setMaxInactiveInterval(60*60*24*365); 1년간 보관하는 세션 ㅋㅋ 
		
		int v = 0;
		String op = null;
		if(request.getParameter("v") != null) {
			v = Integer.parseInt(request.getParameter("v"));
		}
		if(request.getParameter("operator") !=null) {
			op = request.getParameter("operator");
		}
		if(op.equals("=")) {
//			int x = (Integer)application.getAttribute("v");
			int x = (Integer)session.getAttribute("v");
			int y= v;
			int result = 0;
//			String oper = (String)application.getAttribute("op");
			String oper = (String)session.getAttribute("op");
			
			if(oper.equals("+")) {
				result = x+y;
			}else {
				result = x-y;
			}
			response.getWriter().println("결과 : " + result);
		}else {
//			application.setAttribute("v", v);
//			application.setAttribute("op", op);
			session.setAttribute("v", v);
			session.setAttribute("op", op);
			response.sendRedirect("calc.jsp");
		}
	}
}
