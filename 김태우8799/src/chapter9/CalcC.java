package chapter9;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CalcC
 */
@WebServlet("/chapter9/calcC")
public class CalcC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Cookie[] cookies = request.getCookies();
		
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
			
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("v")){
					x = Integer.parseInt(c.getValue());
					break;
				}
				}
			int y = v;
			int result= 0;
			String oper = null;
				for(Cookie c : cookies) {
					if(c.getName().equals("op")){
						oper = c.getValue();
						break;
				}
			}
			
			if(oper.equals("+")) {
				result = x+y;
			}else {
				result = x-y;
			}
			response.getWriter().println("결과 : " + result);
		}else {
			Cookie vCookie = new Cookie("v" , Integer.toString(v));
			Cookie opCookie = new Cookie("op", op);
			vCookie.setPath("/");//모든 페이지에서 쿠키를 전달
			opCookie.setPath("/calcC");
			response.addCookie(vCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("calc.jsp");
		}
	}
}
