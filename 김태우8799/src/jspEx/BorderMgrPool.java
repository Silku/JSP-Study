package jspEx;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import db.DBConnectionMgr;

public class BorderMgrPool {
	private DBConnectionMgr pool = null;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now = new Date();
	String nowDate = dateFormat.format(now);
	
	public BorderMgrPool() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			System.out.println("�삤瑜�: DBConnection Pool �떎�뙣.");
		}
	}
	
	public ArrayList<BorderDtlBean> getBorderList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BorderDtlBean> list = new ArrayList<BorderDtlBean>();
		try {
			con = pool.getConnection();
			sql = "select * from border_dtl order by border_code desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BorderDtlBean bean = new BorderDtlBean();
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_title(rs.getString(2));
				bean.setBorder_content(rs.getString(3));
				bean.setWriter_name(rs.getString(4));
				bean.setWriter_ip(rs.getString(5));
				bean.setBorder_date(rs.getString(6));
				bean.setBorder_count(rs.getInt(7));
				list.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
//	el태그를 활용한 bean을 사용하기 위한 로직
	public BorderDtlBean getContent(int border_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BorderDtlBean> list = new ArrayList<BorderDtlBean>();
		BorderDtlBean bean = new BorderDtlBean();
		try {
			con = pool.getConnection();
			sql = "select * from border_dtl where border_code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, border_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_title(rs.getString(2));
				bean.setBorder_content(rs.getString(3));
				bean.setWriter_name(rs.getString(4));
				bean.setWriter_ip(rs.getString(5));
				bean.setBorder_date(rs.getString(6));
				bean.setBorder_count(rs.getInt(7));
				list.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
}
