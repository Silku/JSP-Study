package myhome;

import java.util.ArrayList;

public class UserData {
		private String id;
		private String pwd;
		private String name;

		public ArrayList<UserData> getUser() {
		return user;
	}
	public void setUser(ArrayList<UserData> user) {
		this.user = user;
	}
	public LoginData getLogin() {
		return login;
	}
	public void setLogin(LoginData login) {
		this.login = login;
	}
	public static LoginData getLogin() {
		return Login;
	}
	public static void setLogin(LoginData login) {
		Login = login;
	}
		
	}

