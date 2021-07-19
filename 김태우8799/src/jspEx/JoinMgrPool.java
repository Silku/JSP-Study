package jspEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import db.DBConnectionMgr;

public class JoinMgrPool {
	private DBConnectionMgr pool = null;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now = new Date();
	String nowDate = dateFormat.format(now);
	
	public JoinMgrPool() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			System.out.println("오류: DBConnection Pool 실패.");
		}
	}
	
	public boolean idCheck(String user_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		String id = null;
		
		try {
			con = pool.getConnection();
			sql = "select user_id from user_mst where user_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		if(id != null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean joinInsert(UserBean userBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "insert into user_mst(user_id, user_pwd, user_name, user_birthday, createdate, updatedate)"
					+ "values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userBean.getUser_id());
			pstmt.setString(2, userBean.getUser_pwd());
			pstmt.setString(3, userBean.getUser_name());
			pstmt.setString(4, userBean.getUser_birthday());
			pstmt.setString(5, nowDate);
			pstmt.setString(6, nowDate);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			pool.freeConnection(con, pstmt);
		}
		return true;
		
	}
	
}







