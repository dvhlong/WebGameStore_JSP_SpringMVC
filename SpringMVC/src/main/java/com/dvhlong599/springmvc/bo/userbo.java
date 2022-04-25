package com.dvhlong599.springmvc.bo;

import java.sql.SQLException;

import com.dvhlong599.springmvc.bean.userbean;
import com.dvhlong599.springmvc.dao.userdao;

public class userbo {
	public userbean checkLogin(String un,String pass) throws ClassNotFoundException, SQLException  {
		userdao udao=new userdao();
		return udao.checkLogin(un, pass);
	}
	public void add(String un, String email,String pass,String repass) throws Exception {
		userdao udao=new userdao();
		udao.add(un, email, pass, repass);
	}
	public void changePass(String un,String newpass) throws Exception {
		userdao udao=new userdao();
		udao.changePass(un, newpass);
	}
}
