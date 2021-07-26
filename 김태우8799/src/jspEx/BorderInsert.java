package jspEx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * 
 * Servlet implementation class BorderInsert
 */
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 50 * 2
)
@WebServlet("/jspEx/borderinsert")
public class BorderInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	위의 멀티파트콘피그 관련 관련..
//	'보더인서트.제이에스피' 에 있는 "멀티파트/form-data"관련임,
//	파일전송기능을 사용하기 위해서는 위에 멀티파트 콘피그를 언더테이션으로 설정해줘야된다함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		

		
		String 	border_title = "",
				writer_name = "",
				content_textarea = "";
		if(request.getParameter("border_title") != null)
		border_title = request.getParameter("border_title");
		if(request.getParameter("user_name") != null)
		writer_name = request.getParameter("user_name");
		if(request.getParameter("content_textarea") != null)
		content_textarea = request.getParameter("content_textarea");
			
			if(request.getParameter("submitFlag") != null && request.getParameter("submitFlag").equals("true")) {
				// 아래부터 파일 인아웃풋 기능 구현 방법
			String fileName = null;
				if(request.getPart("file") != null) {
					Part filePart = request.getPart("file");
					fileName = filePart.getSubmittedFileName();
					
					InputStream fis = filePart.getInputStream();
					String realPath = request.getServletContext().getRealPath("/jspEx/upload/");
					File path = new File(realPath);
					if(!path.exists()){
						path.mkdirs();
						//make directory
					}
					
					String filePath = realPath +File.separator + fileName;
					FileOutputStream fos = new FileOutputStream(filePath);
					int size = 0;
					byte[] buf = new byte[1024];
					while((size =  fis.read(buf))!= -1) {
						fos.write(buf, 0, size);
					}
				}
				
				BorderDtlBean bean = new  BorderDtlBean();
				bean.setBorder_title(border_title);
				bean.setWriter_name(writer_name);
				bean.setBorder_content(content_textarea);
				bean.setBorder_file(fileName);
				bean.setWriter_ip(request.getRemoteAddr());
				
				BorderMgrPool borderMgrPool = new BorderMgrPool();
				boolean insertFlag = borderMgrPool.borderInsert(bean);
				if(insertFlag == true) {
					response.sendRedirect("border");
					return;
//			   여기서 리턴 안해주면 아래 코드가 실행이되어 충돌이 날수있다고함.
				}
			}
		
		HttpSession session = request.getSession();
		UserBean sessionBean = (UserBean)session.getAttribute("userBean");
		if(sessionBean == null) {
			request.getRequestDispatcher("header_login.jsp").include(request, response);
		}else {
			request.setAttribute("name", sessionBean.getUser_name());
			request.getRequestDispatcher("header_logout.jsp").include(request, response);
		}
		request.getRequestDispatcher("borderinsert.jsp").include(request, response);
		request.getRequestDispatcher("footer.jsp").include(request, response);
	}
}
