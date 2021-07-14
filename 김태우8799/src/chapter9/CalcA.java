package chapter9;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcA
 */
@WebServlet("/chapter9/calcA")
public class CalcA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		ServletContext application = request.getServletContext();
		
		int v = 0;
		String op = null;
		if(request.getParameter("v") != null) {
			v = Integer.parseInt(request.getParameter("v"));
		}
		if(request.getParameter("operator") !=null) {
			op = request.getParameter("operator");
		}
		if(op.equals("=")) {
			int x = (Integer)application.getAttribute("v");
			int y= v;
			int result = 0;
			String oper = (String)application.getAttribute("op");
			
			if(oper.equals("+")) {
				result = x+y;
			}else {
				result = x-y;
			}
			response.getWriter().println("°á°ú : " + result);
		}else {
			application.setAttribute("v", v);
			application.setAttribute("op", op);
			response.sendRedirect("calc.jsp");
		}
	}
}
