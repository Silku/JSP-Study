package jspEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinProc
 */
@WebServlet("/jspEx/joinProc")
public class JoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		JoinMgrPool joinMgr = new JoinMgrPool();
		UserBean userBean = new UserBean();
		
		String	user_id = "",
				user_pwd = "",
				user_repwd = "",
				user_name = "",
				user_year = "",
				user_month = "",
				user_day = "",
				idstatus = "",
				submitflag = "";
		
		if(request.getParameter("user_id") != null){
			user_id = request.getParameter("user_id");
		}
		if(request.getParameter("user_pwd") != null){
			user_pwd = request.getParameter("user_pwd");
		}
		if(request.getParameter("user_repwd") != null){
			user_repwd = request.getParameter("user_repwd");
		}
		if(request.getParameter("user_name") != null){
			user_name = request.getParameter("user_name");
		}
		if(request.getParameter("user_year") != null){
			user_year = request.getParameter("user_year");
		}
		if(request.getParameter("user_month") != null){
			user_month = request.getParameter("user_month");
		}
		if(request.getParameter("user_day") != null){
			user_day = request.getParameter("user_day");
		}
		if(request.getParameter("idstatus") != null){
			idstatus = request.getParameter("idstatus");
		}
		if(request.getParameter("submitflag") != null && request.getParameter("submitflag").equals("true")){
			submitflag = request.getParameter("submitflag");
			
			userBean.setUser_id(user_id);
			userBean.setUser_pwd(user_pwd);
			userBean.setUser_name(user_name);
			userBean.setUser_birthday(user_year + "-" + user_month + "-" + user_day);
			
			boolean insertStatus = joinMgr.joinInsert(userBean);
			if(insertStatus == true){
				response.sendRedirect("login");
				return;
			}
		}
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_pwd", user_pwd);
		request.setAttribute("user_repwd", user_repwd);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_year", user_year);
		request.setAttribute("user_month", user_month);
		request.setAttribute("user_day", user_day);
		request.setAttribute("idstatus", joinMgr.idCheck(user_id));
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

}
