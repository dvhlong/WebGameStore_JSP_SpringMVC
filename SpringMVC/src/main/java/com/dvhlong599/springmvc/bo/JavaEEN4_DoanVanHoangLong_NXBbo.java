package com.dvhlong599.springmvc.bo;

import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.JavaEEN4_DoanVanHoangLong_NXBbean;
import com.dvhlong599.springmvc.dao.JavaEEN4_DoanVanHoangLong_NXBdao;

public class JavaEEN4_DoanVanHoangLong_NXBbo {
	public ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean> Tim(String key) throws Exception{
		JavaEEN4_DoanVanHoangLong_NXBdao nxbdao=new JavaEEN4_DoanVanHoangLong_NXBdao();
    	ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean> tam= new ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean>();
    	ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean> ds=nxbdao.getNXB();
    	for(JavaEEN4_DoanVanHoangLong_NXBbean s: ds)
    		if(s.getManxb().toLowerCase().trim().contains(key.toLowerCase().trim()) ||
    				s.getTennxb().toLowerCase().trim().contains(key.toLowerCase().trim()))
    			tam.add(s);
    	return tam;
    }
}
