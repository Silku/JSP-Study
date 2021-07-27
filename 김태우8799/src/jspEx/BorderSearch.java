package jspEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BorderSearch
 */
@WebServlet("/jspEx/borderSearch")
public class BorderSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filter = request.getParameter("searchFilter");
		String search = request.getParameter("border_search");
		
		BorderMgrPool borderMgrPool = new BorderMgrPool();
		request.setAttribute("searchBorderList", borderMgrPool.getBorderList(filter,search));
		
		request.getRequestDispatcher("border").forward(request, response);
	}

}
