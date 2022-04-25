package com.dvhlong599.springmvc.bo;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.cartbean;
import com.dvhlong599.springmvc.dao.cartdao;



public class cartbo {
	public ArrayList<cartbean> ds=new ArrayList<cartbean>();
	public Timestamp timebuy;
	public void addToCart(long gid,String gname,long finalcost){
		for(cartbean c:ds) {
			if (c.getGid()==gid)
				return;
		}
		ds.add(new cartbean(gid, gname, finalcost));
	}
	public void deleteFromCart(long gid) {
		for(cartbean c:ds) {
			if(c.getGid()==gid) {
				ds.remove(c);
				return;
			}
		}
	}
	public void purchaseCart(cartbo cbo,String un) throws Exception {
		cartdao cdao= new cartdao();
		cdao.purchaseCart(cbo, un);
	}
	public ArrayList<cartbean> getCboList(){
		return ds;
	}
	public long totalcost() {
		long s=0;
		for (cartbean c:ds) {
			s=s+c.getFinalcost();
		}
		return s;
	}
	public int isToCart(cartbo cbo,long gid) {
		for(cartbean c:ds) {
			if(c.getGid()==gid) {
				return 1;
			}
		}
		return 0;
	}
}
