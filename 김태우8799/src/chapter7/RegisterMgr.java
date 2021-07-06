package chapter7;

import java.sql.*;

public class RegisterMgr {
 private	Connection con = null;
 private	Statement stmt = null;
 private	ResultSet rs = null;
	
	public RegisterMgr() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		}catch(Exception e) {
			System.out.println("jdbc 드라이버 로딩 실패");
		}
	}
	public ArrayList<RegisterBean> getRegisterList(){
		ArrayList<RegisterBean> list = new ArrayList<RegisterBean>();
		try{
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/web", "root", "toor");
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from tblRegister");

			if(rs !=null){
				while(rs.next()){
						RegisterBean bean = new RegisterBean();
						bean.setId(rs.getString("id"));
						bean.setPwd(rs.getString("pwd"));
						bean.setName(rs.getString("name"));
						bean.setNum1(rs.getInt("num1"));
						bean.setNum2(rs.getInt("num2"));
						bean.setEmail(rs.getString("email"));
						bean.setPhone(rs.getString("phone"));
						bean.setAddress(rs.getString("address"));
						bean.setJob(rs.getString("job"));
						bean.setCreatedate(rs.getString("createdate"));
						bean.setUpdatedate(rs.getString("updatedate"));
						
						list.add(bean);
				}
			}
		}catch(SQLException sqlEx){
			System.out.print(sqlEx);
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException sqlEx){
					System.out.println(sqlEx);
				}
			}
			if(stmt != null){
				try{
					rs.close();
				}catch(SQLException sqlEx){
					System.out.println(sqlEx);
				}
			}
			if(con != null){
				try{
					rs.close();
				}catch(Exception ex){
					System.out.println(ex);
				}
			}
		}return list;
	}