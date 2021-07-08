package chapter8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/chapter8/hello")
public class ExampleServlet01 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request�� response �׻� Ǯ������ �������ߵȴ�.
			response.setContentType("text/html; charset=UTF-8" );
			response.setCharacterEncoding("UTF-8");	
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> ���� �׽�Ʈ �������Դϴ�.</h1>");
			out.println("</body>");
			out.println("</html>");
	}
}
