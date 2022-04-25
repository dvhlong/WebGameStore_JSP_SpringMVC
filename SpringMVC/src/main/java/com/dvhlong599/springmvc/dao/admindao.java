package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class admindao {
	public boolean ktdnadmin(String un, String pass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.adminaccount where accname=? and pass=?");
    	st.setString(1, un);
    	st.setString(2, pass);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		System.out.println(rs.getString(1)+" "+rs.getString(2));
    		cn.close();
    		return true;
    	} else {
    		cn.close();
    		return false;
    	}
	}
	public void add(String un, String pass, String repass) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.adminaccount where accname=? ");
    	st.setString(1, un);
    	ResultSet rs = st.executeQuery();
    	if(!rs.next()&&pass.equals(repass)) {
    		st=cn.prepareStatement("insert into webgamestore.adminaccount values (?,?)");
    		st.setString(1, un);
    		st.setString(2, pass);
    		st.executeUpdate();
    	}
    	cn.close();
	}
}
