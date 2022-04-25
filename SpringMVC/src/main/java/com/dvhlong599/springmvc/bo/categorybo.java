package com.dvhlong599.springmvc.bo;

import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.categorybean;
import com.dvhlong599.springmvc.dao.categorydao;

public class categorybo {
	public ArrayList<categorybean> getCategory() throws Exception {
		categorydao cdao=new categorydao();
		return cdao.getCategory();
	}
	public void addCategory(String cname) throws Exception {
		categorydao cdao=new categorydao();
		cdao.addCategory(cname);
	}
	public void deleteCategory(long cid) throws Exception {
		categorydao cdao=new categorydao();
		cdao.deleteCategory(cid);
	}
	public void updateCategory(long cid,String cname) throws Exception {
		categorydao cdao=new categorydao();
		cdao.updateCategory(cid, cname);
	}
}
