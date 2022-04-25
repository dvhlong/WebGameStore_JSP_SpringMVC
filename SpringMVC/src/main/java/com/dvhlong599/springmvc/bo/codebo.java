package com.dvhlong599.springmvc.bo;

import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.codebean;
import com.dvhlong599.springmvc.dao.codedao;

public class codebo {
	public ArrayList<codebean> getCodeList() throws Exception{
		codedao cdao=new codedao();
		return cdao.getCodeList();
	}
	public void addCode(long gid,int nolimit) throws Exception {
		codedao cdao=new codedao();
		cdao.addCode(gid, nolimit);
	}
	public void deleteCode(String code) throws Exception {
		codedao cdao=new codedao();
		cdao.deleteCode(code);
	}
}
