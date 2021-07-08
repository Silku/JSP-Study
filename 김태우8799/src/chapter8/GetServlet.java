package chapter8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/chapter8/GetServlet")
public class GetServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			String msg = request.getParameter("msg");
			if(msg == null) {
				msg = "";
			}
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>GET ��� ����</h1>");
			out.println("<h2>" + msg+"</h2>");
			out.println("</body>");
			out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8"); //post����϶��� ��û�� ���������� ������ ������ �̱⶧���� 'request.set~~~' �̰� �ٿ���ߵȴ�.
		PrintWriter out = response.getWriter();
		String msg = request.getParameter("msg");
		if(msg == null) {
			msg = "";
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>POST ��� ����</h1>");
		out.println("<h2>" + msg+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}
}
