package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dvhlong599.springmvc.bean.userbean;

public class userdao {
	public userbean checkLogin(String un,String pass) throws SQLException, ClassNotFoundException  {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	
    	PreparedStatement st=cn.prepareStatement("Select * From webgamestore.useraccount where accname=? and pass=?");
    	st.setString(1, un);
    	st.setString(2, pass);
  
    	ResultSet rs;
    	rs=st.executeQuery();

    	if (rs.next()) {
    		System.out.println("Checktrue");
    		System.out.println(rs.getString(2)+" and "+rs.getString(3));;
    		userbean user = new userbean(rs.getString(2), rs.getString(3), rs.getString(4));
    		cn.close();
    		return user;
    	} else {
    		System.out.println("Checkture");
    		cn.close();
    		return null;
		}
	}
	public void add(String un,String email,String pass,String repass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement(" Select * From webgamestore.useraccount where accname=?");
    	st.setString(1, un);
    	ResultSet rs,rs1;
    	rs=st.executeQuery();
    	PreparedStatement st2=cn.prepareStatement(" Select * From webgamestore.useraccount where email=?");
    	st2.setString(1, email);
    	rs1=st2.executeQuery();
    	//System.out.println("check");
    	if(!rs.next()&&pass.equals(repass)&&!rs1.next()) {
    			PreparedStatement st1=cn.prepareStatement("insert into webgamestore.useraccount (accname,pass,email) values (?,?,?)");
        		st1.setString(1, un);
        		st1.setString(2, pass);
        		st1.setString(3, email);
        		st1.executeUpdate();
    	}
    	cn.close();
	}
	public void changePass(String un,String newpass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement(" update webgamestore.useraccount set pass=? where accname=?");
    	st.setString(1, newpass);
    	st.setString(2, un);
    	st.executeUpdate();
    	cn.close();
	}
}
