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
			System.out.println("오류: DBConnection Pool 실패.");
		}
	}
	public ArrayList<BorderDtlBean> getBorderList(String filter, String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BorderDtlBean> list = new ArrayList<BorderDtlBean>();
		try {
			con = pool.getConnection();
			if(filter.equals("title")) {
				sql = "select border_code, border_title , border_content, border_file, writer_name, border_date, border_count from border_dtl where border_title like ? order by border_code desc";
			}else if(filter.equals("content")) {
				sql = "select border_code, border_title , border_content, border_file, writer_name, border_date, border_count from border_dtl where border_content like ?order by border_code desc";
			}else if(filter.equals("writer")) {
				sql = "select border_code, border_title , border_content, border_file, writer_name, border_date, border_count from border_dtl where writer_name like ?order by border_code desc";
			}else {
				sql = "select border_code, border_title , border_content, border_file, writer_name, border_date, border_count from border_dtl where border_title like ? or border_content like ? or writer_name like ? order by border_code desc";
			}
			
			pstmt = con.prepareStatement(sql);
			if(!filter.equals("all")) {
				pstmt.setString(1, "%" + search +"%");
			}else {
				pstmt.setString(1, "%" + search +"%");
				pstmt.setString(2, "%" + search +"%");
				pstmt.setString(3, "%" + search +"%");
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BorderDtlBean bean = new BorderDtlBean();
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_title(rs.getString(2));
				bean.setBorder_content(rs.getString(3));
				bean.setBorder_file(rs.getString(4));
				bean.setWriter_name(rs.getString(5));
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
	
	public ArrayList<BorderDtlBean> getBorderList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BorderDtlBean> list = new ArrayList<BorderDtlBean>();
		try {
			con = pool.getConnection();
			sql = "select border_code, border_title , border_content, border_file, writer_name, border_date, border_count from border_dtl order by border_code desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BorderDtlBean bean = new BorderDtlBean();
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_title(rs.getString(2));
				bean.setBorder_content(rs.getString(3));
				bean.setBorder_file(rs.getString(4));
				bean.setWriter_name(rs.getString(5));
//				bean.setWriter_ip(rs.getString(6));
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
				bean.setBorder_file(rs.getString(4));
				bean.setWriter_name(rs.getString(5));
				bean.setWriter_ip(rs.getString(6));
				bean.setBorder_date(rs.getString(7));
				bean.setBorder_count(rs.getInt(8));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	public BorderDtlBean getPreBorderCode(int border_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BorderDtlBean bean = new BorderDtlBean();
		try {
			con = pool.getConnection();
			sql = "select border_code, border_title from border_dtl where border_code = (select max(border_code) from border_dtl where border_code < ?)";
//			이처럼서브쿼리 쓰면 데이터 처리가 느려질수있다..
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, border_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_title(rs.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	public BorderDtlBean getNextBorderCode(int border_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		BorderDtlBean bean = new BorderDtlBean();
		try {
			con = pool.getConnection();
			sql = "select border_code, border_title from border_dtl where border_code = (select min(border_code) from border_dtl where border_code > ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, border_code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_title(rs.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	public boolean borderInsert(BorderDtlBean borderDtlBean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		try {
			con = pool.getConnection();
			sql = "insert into border_dtl values(0, ?, ?, ?, ?, ?, now(), 0 ,now(), now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, borderDtlBean.getBorder_title());
			pstmt.setString(2, borderDtlBean.getBorder_content());
			pstmt.setString(3, borderDtlBean.getBorder_file());
			pstmt.setString(4, borderDtlBean.getWriter_name());
			pstmt.setString(5, borderDtlBean.getWriter_ip());
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
