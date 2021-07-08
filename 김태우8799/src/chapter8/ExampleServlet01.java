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
		// request랑 response 항상 풀네임을 사용해줘야된다.
			response.setContentType("text/html; charset=UTF-8" );
			response.setCharacterEncoding("UTF-8");	
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1> 서블릿 테스트 페이지입니다.</h1>");
			out.println("</body>");
			out.println("</html>");
	}
}
