package chapter7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.DBConnectionMgr;

public class RegisterMgrPool {
	private DBConnectionMgr pool = null;
	
	public RegisterMgrPool() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch(Exception e) {
			System.out.println("Error: 연결에 실패했습니다.");
		}
	}
	public ArrayList<RegisterBean>getRegisterList(){
//		셋다 java.sql.영역안에 있음
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		String col = "*", 
				tbl = "tblregister", 
				where = null, 
				group= null, 
				order = null;
		ArrayList<RegisterBean> list = new ArrayList<RegisterBean>();
		try {
			con = pool.getConnection();
			stmt = con.createStatement();
			sql = 
			"select"
			+ col
			+ "from"
			+ tbl
			+ "where"
			+ where
			+ "group by"
			+ group
			+ "order by"
			+ order;
			rs = stmt.executeQuery(sql);
		while(rs.next()) {
			RegisterBean bean = new RegisterBean();
			bean.setId(rs.getString("id"));
			bean.setPwd(rs.getString("pwd"));
			bean.setName(rs.getString("name"));
			bean.setNum1(rs.getInt("num1"));
			bean.setNum2(rs.getInt("num2"));
			bean.setEmail(rs.getString("email"));
			bean.setPhone(rs.getString("phone"));
			bean.setZipcode(rs.getString("zipcode"));
			bean.setAddress(rs.getString("address"));
			bean.setJob(rs.getString("job"));
			bean.setCreatedate(rs.getString("createdate"));
			bean.setUpdatedate(rs.getString("updatedate"));
			list.add(bean);
			}
		}catch(Exception e) {
			System.out.println("Exception : " + e);
		}finally {
			pool.freeConnection(con, stmt, rs);
		}
		return list;
	}
}
