package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.JavaEEN4_DoanVanHoangLong_Sachbean;

public class JavaEEN4_DoanVanHoangLong_Sachdao {
	public ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> getSach() throws Exception{
		ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> ds =new ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean>();
		Connection cn;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	System.out.println("Da xac dinh HQTCSDL");
    	String url="jdbc:sqlserver://localhost:1433;databaseName=DoanVanHoangLong;user=sa; password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("use DoanVanHoangLong Select * From Sach");
    	while(rs.next()) {
    			//System.out.print(rs.getString(2));
				ds.add(new JavaEEN4_DoanVanHoangLong_Sachbean(rs.getLong(1), rs.getString(2),rs.getString(3),rs.getLong(4),rs.getLong(5)));		
    	}
    	cn.close();
		return ds;
	}
}
