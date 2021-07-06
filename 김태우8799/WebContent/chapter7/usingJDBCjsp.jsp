<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>	
<%
	Class.forName("org.gjt.mm.mysql.Driver");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String id = "",
			pwd ="",
			name = "",
			email = "",
			phone ="",
			zipcode = "",
			address ="",
			job = "",
			createdate = "",
			updatedate ="";
	int num1 = 0,
		num2 = 0;
	int counter = 0;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try{
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/web", "root", "toor");
	stmt = con.createStatement();
	rs = stmt.executeQuery("select * from tblRegister");

		if(rs !=null){
			while(rs.next()){
					id = rs.getString("id");
					pwd = rs.getString("pwd");
					name = rs.getString("name");
					num1 = rs.getInt("num1");
					num2	= rs.getInt("num2");
					email = rs.getString("email");
					phone = rs.getString("phone");
					address = rs.getString("address");
					job = rs.getString("job");
					createdate = rs.getString("createdate");
					updatedate = rs.getString("updatedate");
					

%>
					id : <%=id %><br>
					pwd : <%=pwd %><br>
					name : <%=name %><br>
					num1 : <%=num1 %><br>
					num2 : <%=num2 %><br>
					email : <%=email %><br>
					phone : <%=phone %><br>
					zipcode : <%=zipcode %><br>
					address : <%=address %><br>
					createdate : <%=createdate %><br>
					updatedate : <%=updatedate %><br>	
					<hr>
<%
					counter++;
				}//while end;
			} //if end;
		}catch(SQLException sqlEx){
			out.print(sqlEx);
		}catch(Exception ex){
			out.println(ex);
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException sqlEx){
					out.println(sqlEx);
				}
			}
			if(stmt != null){
				try{
					rs.close();
				}catch(SQLException sqlEx){
					out.println(sqlEx);
				}
			}
			if(con != null){
				try{
					rs.close();
				}catch(Exception ex){
					out.println(ex);
				}
			}
		}
%>		
</body>
</html>