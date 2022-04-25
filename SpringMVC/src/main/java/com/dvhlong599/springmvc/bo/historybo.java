package com.dvhlong599.springmvc.bo;

import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.historybean;
import com.dvhlong599.springmvc.dao.historydao;

public class historybo {
	public ArrayList<historybean> getHistory(String un) throws Exception{
		historydao hdao=new historydao();
		return hdao.getHistory(un);
	}
	public long totalPurchase(ArrayList<historybean> hlist) {
		long s=0;
		for (historybean h:hlist) {
			s=s+h.getCost();
		}
		return s;
	}
}
