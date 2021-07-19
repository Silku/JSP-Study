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
	
	public ArrayList<BorderMstBean> getBorderList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<BorderMstBean> list = new ArrayList<BorderMstBean>();
		try {
			con = pool.getConnection();
			sql = "select * from border_mst";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BorderMstBean bean = new BorderMstBean();
				bean.setBorder_code(rs.getInt(1));
				bean.setBorder_index(rs.getInt(2));
				bean.setBorder_title(rs.getString(3));
				bean.setBorder_writer(rs.getString(4));
				bean.setBorder_date(rs.getString(5));
				bean.setBorder_count(rs.getInt(6));
				list.add(bean);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
}
