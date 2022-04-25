package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.reviewbean;

public class reviewdao {
	public ArrayList<reviewbean> getReview(long gid) throws Exception{
		ArrayList<reviewbean> ds= new ArrayList<reviewbean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("Select * From webgamestore.review as r"
    			+ " join webgamestore.useraccount as ua on r.UserID=ua.UserID "
    			+ "where r.GID=?");
    	st.setLong(1, gid);
    	ResultSet rs=st.executeQuery();
    	while(rs.next()) {
    		ds.add(new reviewbean(rs.getString(8), rs.getLong(3), rs.getString(4), rs.getInt(5),rs.getDate(6)));
    	}
    	cn.close();
		return ds;
	}
	public void addReview(String un,long gid,String content,int star) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.useraccount where accname=?");
    	st.setString(1, un);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		Date d=Date.valueOf(LocalDate.now());
    		long id=rs.getLong(1);
    		st=cn.prepareStatement("insert into webgamestore.review (UserID,GID,content,star,rdate) values (?,?,?,?,?)");
    		st.setLong(1, id);
    		st.setLong(2, gid);
    		st.setString(3, content);
    		st.setInt(4, star);
    		st.setDate(5, d);
    		st.executeUpdate();
    	}
    	cn.close();
    	//PreparedStatement st1= cn.prepareStatement(insert into Review value (?,?,?) );
	}
	public void updateReview(String un,long gid, String content,int star) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.useraccount where accname=?");
    	st.setString(1, un);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		Date d=Date.valueOf(LocalDate.now());
    		long id=rs.getLong(1);
    		st=cn.prepareStatement("update webgamestore.review set content=?,star=?,rdate=? where UserID=? and GID=?");
    		st.setString(1, content);
    		st.setInt(2, star);
    		st.setDate(3, d);
    		st.setLong(4, id);
    		st.setLong(5, gid);
    		st.executeUpdate();
    	}
    	cn.close();
	}
	public void deleteReview(String un,long gid) throws Exception {
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
    		st=cn.prepareStatement("delete from webgamestore.review where UserID=? and GID=?");
    		st.setLong(1, id);
    		st.setLong(2, gid);
    		st.executeUpdate();
    	}
    	cn.close();
	}
}
