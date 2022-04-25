package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.historybean;

public class historydao {
	public ArrayList<historybean> getHistory(String un) throws Exception{
		ArrayList<historybean> ds=new ArrayList<historybean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement(" Select * From webgamestore.purchase as p "
    			+ "join webgamestore.useraccount as ua "
    			+ "on p.UserID=ua.UserID "
    			+ "join webgamestore.games as g on g.GID=p.GID "
    			+ "where ua.accname=? "
    			+ "order by p.PurchaseID desc");
    	st.setString(1, un);
    	ResultSet rs=st.executeQuery();
    	while(rs.next()) {
    		ds.add(new historybean(rs.getString(11),rs.getTimestamp(4), rs.getLong(5)));
    	}
    	cn.close();
    	return ds;
	}
}
