package biz;

import dao.LoginDAO;

public class LoginBiz {

	public LoginBiz() {
		super();	
	}
	
	public boolean getLoginUser(String id, String pass) {
		LoginDAO dao=new LoginDAO();
		return dao.getLoginUser(id, pass);
	}
	
	
}
