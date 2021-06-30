package myhome;

import java.util.ArrayList;



public class LoginData {

		ArrayList<UserData> user = new ArrayList<UserData>();
		
		LoginData login;
		private static LoginData Login;
		
		public LoginData() {
			Userdata ud = new UserData();
			ud.setId("Junil");
			ud.setPwd("1234");
			ud.setName("±Ë¡ÿ¿œ");
			user.add(ud);
		}
		public static LoginData getLoginData() {
			if(Login == null) {
				Login = new LoginData();
			}
			return Login;
		}
		
		public UserData getUser(String id, String pwd){
			for(int i =0; i< user.size(); i++) {
				if(user.get(i).getId().equals(id)) {
					if(user.get(i).getPwd().equals(pwd)) {
						return user.get(i);
					}
					return null;
				}
			}
			return null; 
		}
	}

 