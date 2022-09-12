package dao;

import model.LoginBean;

public class LoginDao {

	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		if (loginBean.getUsername().equals("admin") && loginBean.getPassword().equals("admin")) {
			return true;
		}

		return false;
	}
}
