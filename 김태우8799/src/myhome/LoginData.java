package myhome;

import java.util.ArrayList;

public class LoginData {
	ArrayList<UserData> user = new ArrayList<UserData>();
	private static LoginData login = new LoginData();

	private LoginData() {
		UserData ud = new UserData();
		ud.setId("korea");
		ud.setPwd("1234");
		ud.setName("ÄÚ¸®¾Æ");
		user.add(ud);
	}
	
	public static LoginData getLoginData() {
		if(login == null) {
			login = new LoginData();
		}
		return login;
	}
	
	public UserData getUser(String id, String pwd){
		for(int i = 0; i < user.size(); i++) {
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
 