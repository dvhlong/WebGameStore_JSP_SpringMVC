package com.dvhlong599.springmvc.bo;

import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.JavaEEN4_DoanVanHoangLong_Sachbean;
import com.dvhlong599.springmvc.dao.JavaEEN4_DoanVanHoangLong_Sachdao;


public class JavaEEN4_DoanVanHoangLong_Sachbo {
	public ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> Timtensach(String key) throws Exception{
		JavaEEN4_DoanVanHoangLong_Sachdao sdao=new JavaEEN4_DoanVanHoangLong_Sachdao();
    	ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> tam= new ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean>();
    	ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> ds=sdao.getSach();
    	for(JavaEEN4_DoanVanHoangLong_Sachbean s: ds) {
    		if(s.getTensach().toLowerCase().trim().contains(key.toLowerCase().trim())) {
    			System.out.println("check");
    			System.out.println(s.getTensach().toLowerCase().trim());
    			tam.add(s);
    		}
    	}
    	return tam;
    }
	public ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> TimGia(String key) throws Exception{
		JavaEEN4_DoanVanHoangLong_Sachdao sdao=new JavaEEN4_DoanVanHoangLong_Sachdao();
    	ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> tam= new ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean>();
    	ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> ds=sdao.getSach();
    	for(JavaEEN4_DoanVanHoangLong_Sachbean s: ds) {
    		if(s.getGia()>=Long.parseLong(key)) {
    			System.out.println("check");
    			System.out.println(s.getTensach().toLowerCase().trim());
    			tam.add(s);
    		}
    	}
    	return tam;
    }
	public ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> getSach() throws Exception {
		JavaEEN4_DoanVanHoangLong_Sachdao sdao=new JavaEEN4_DoanVanHoangLong_Sachdao();
		return sdao.getSach();
	}
}
