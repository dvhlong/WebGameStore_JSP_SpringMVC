package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dvhlong599.springmvc.bean.cartbean;
import com.dvhlong599.springmvc.bo.cartbo;

public class cartdao {
	public void purchaseCart(cartbo cbo,String un) throws Exception {
		java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime();
	  	cbo.timebuy=new java.sql.Timestamp(javaTime);
	  	Connection cn;
	  	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.useraccount where accname=?");
    	st.setString(1, un);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		long id=rs.getLong(1);
    		for(cartbean c:cbo.ds) {
    			st=cn.prepareStatement("insert into webgamestore.purchase (UserID,GID,purchaseTime,cost) values(?,?,?,?)");
    			st.setLong(1, id);
    			st.setLong(2, c.getGid());
    			st.setTimestamp(3, cbo.timebuy);
    			st.setLong(4, c.getFinalcost());
    			st.executeUpdate();
    		}
    	}
    	cn.close();
	}
}
