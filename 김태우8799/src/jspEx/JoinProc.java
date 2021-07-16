package jspEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnectionMgr;

/**
 * Servlet implementation class JoinProc
 */
//@WebServlet("/jspEx/joinProc") ���⿡ �� �ִ� ��ΰ� �Ʒ�ó�� jsp���� ��ο� ���ƾ���.
@WebServlet("/myHomePrc/joinProc")
public class JoinProc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		JoinMgrPool joinMgr = new JoinMgrPool();
		UserBean userBean = new UserBean();
		
	
// �Ʒ� useBean �׼��±״� ���Ұ��ϴ�. ���� ���� ó�� ����.
//	<jsp:useBean id="joinMgr" class="jspEx.JoinMgrPool"></jsp:useBean>
//	<jsp:useBean id="userBean" class="jspEx.UserBean"></jsp:useBean>
//	<jsp:setProperty name="userBean" property="*" />
		
		
		String user_id = "";
		String user_pwd = "";
		String user_repwd = "";
		String user_name = "";
		String user_year = "";
		String user_month = "";
		String user_day = "";
		String idstatus = "";
		String submitflag = "";
		
		if(request.getParameter("user_id") != null){
			user_id = request.getParameter("user_id");
		}
		
		if(request.getParameter("submitflag") != null && request.getParameter("submitflag").equals("true")){
			submitflag = request.getParameter("submitflag");
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
			
			userBean.setUser_id(user_id);
			userBean.setUser_pwd(user_pwd);
			userBean.setUser_name(user_name);
			userBean.setUser_birthday(user_year + "-" + user_month + "-" + user_day);
			
			boolean insertStatus = joinMgr.joinInsert(userBean);
			if(insertStatus == true){
				response.sendRedirect("login.html");
			}
		}
		
		boolean idCheckStatus = joinMgr.idCheck(user_id);
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

}
