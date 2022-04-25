package com.dvhlong599.springmvc.bo;

import com.dvhlong599.springmvc.dao.admindao;

public class adminbo {
	public boolean ktdnAdmin(String un, String pass) throws Exception {
		admindao addao=new admindao();
		return addao.ktdnadmin(un, pass);
	}
	public void add(String un,String pass, String repass) throws Exception {
		admindao addao=new admindao();
		addao.add(un, pass, repass);
	}
}
