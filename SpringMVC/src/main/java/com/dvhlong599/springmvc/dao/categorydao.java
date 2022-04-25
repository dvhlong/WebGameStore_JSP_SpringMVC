package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.categorybean;


public class categorydao {
	public  ArrayList<categorybean> getCategory() throws Exception {
		ArrayList<categorybean> ds= new ArrayList<categorybean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From webgamestore.category");
    	while(rs.next()) {
			ds.add(new  categorybean(rs.getLong(1),rs.getString(2)));		
    	}
    	cn.close();
    	return ds;
	}
	public void addCategory(String cname) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("insert into webgamestore.category (CategoryName) values(?)");
    	st.setString(1, cname);
    	st.executeUpdate();
    	cn.close();
	}
	public void deleteCategory(long cid) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("delete from webgamestore.category where CategoryID=?");
    	st.setLong(1, cid);
    	st.executeUpdate();
    	cn.close();
	}
	public void updateCategory(long cid,String cname) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("update webgamestore.category set CategoryName=? where CategoryID=?");
    	st.setString(1, cname);
    	st.setLong(2, cid);
    	st.executeUpdate();
    	cn.close();
	}
}
