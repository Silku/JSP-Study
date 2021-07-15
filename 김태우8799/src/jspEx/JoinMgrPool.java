package jspEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import db.DBConnectionMgr;

public class JoinMgrPool {
	private DBConnectionMgr pool = null;
	
	public JoinMgrPool(){
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			System.out.println("���� : DBConnection Pool ����.");
				
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
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
		
		Date now = new Date();
		
	
		try {
			con = pool.getConnection();
			sql = "insert into user_mst(user_id, user_pwd, user_name, user_birthday, creatdate, updatedate)"
					+"values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userBean.getUser_id());
			pstmt.setString(2, userBean.getUser_pwd());
			pstmt.setString(3, userBean.getUser_name());
			pstmt.setString(4, userBean.getUser_birthday());
			pstmt.setString(5, ""+now);
			pstmt.setString(6, ""+now);

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			pool.freeConnection(con,pstmt);
		}
	}
}
