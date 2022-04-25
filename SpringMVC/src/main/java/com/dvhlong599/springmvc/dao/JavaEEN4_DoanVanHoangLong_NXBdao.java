package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.JavaEEN4_DoanVanHoangLong_NXBbean;

public class JavaEEN4_DoanVanHoangLong_NXBdao {
	public ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean> getNXB() throws Exception{
		ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean> ds =new ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean>();
		Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	String url="jdbc:sqlserver://localhost:1433;databaseName=DoanVanHoangLong;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("use DoanVanHoangLong Select * From NhaXuatBan");
    	while(rs.next()) {
				ds.add(new  JavaEEN4_DoanVanHoangLong_NXBbean(rs.getString(1), rs.getString(2)));		
    	}
    	cn.close();
		return ds;
	}
}
