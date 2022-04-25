package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.UUID;

import com.dvhlong599.springmvc.bean.codebean;


public class codedao {
	public ArrayList<codebean> getCodeList() throws Exception{
		ArrayList<codebean> ds=new ArrayList<codebean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From webgamestore.codeactivate");
    	while(rs.next()) {
    		ds.add(new codebean(rs.getString(1), rs.getLong(2), rs.getBoolean(3), rs.getLong(4)));
    	}
    	cn.close();
    	return ds; 
	}
	public void addCode(long gid,int nolimit) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	String uuid = UUID.randomUUID().toString();
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.codeactivate where Code=?");
    	st.setString(1, uuid);
    	ResultSet rs=st.executeQuery();
    	if(!rs.next()) {
    		st=cn.prepareStatement("insert into webgamestore.codeActivate(Code,GID,isNoLimitUser) values(?,?,?)");
    		st.setString(1, uuid);
    		st.setLong(2, gid);
    		st.setInt(3, nolimit);
    		st.executeUpdate();		
    	}
    	cn.close();
	}
	public void deleteCode(String code) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("delete from webgamestore.codeactivate where Code=?");
    	st.setString(1, code);
    	st.executeUpdate();
    	cn.close();
	}
}
