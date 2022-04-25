package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.activatebean;
import com.dvhlong599.springmvc.bean.gamebean;
import com.dvhlong599.springmvc.bean.gamedetailbean;

public class gamedao {
	public ArrayList<gamebean> getGame() throws Exception {
		ArrayList<gamebean> ds=new ArrayList<gamebean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From webgamestore.games");
    	while(rs.next()) {
			ds.add(new  gamebean(rs.getLong(1), rs.getString(2),rs.getString(13),rs.getLong(14),rs.getInt(15),rs.getLong(16)));		
    	}
    	cn.close();
    	return ds;
	}
	public ArrayList<gamebean> getGameUseCode() throws Exception {
		ArrayList<gamebean> ds=new ArrayList<gamebean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	Statement st=cn.createStatement();
    	ResultSet rs;
    	rs=st.executeQuery("Select * From webgamestore.games where cost<>0");
    	while(rs.next()) {
			ds.add(new  gamebean(rs.getLong(1), rs.getString(2),rs.getString(13),rs.getLong(14),rs.getInt(15),rs.getLong(16)));		
    	}
    	cn.close();
    	return ds;
	}
	public gamedetailbean getGameDetail(long GID) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement(" Select * From webgamestore.games where GID=?");
    	st.setLong(1, GID);
    	ResultSet rs=st.executeQuery();
		gamedetailbean gdtbean=null;
    	if(rs.next())
    		gdtbean=new gamedetailbean(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getLong(14), rs.getInt(15), rs.getLong(16), rs.getString(17), rs.getString(18));
    	cn.close();
		return gdtbean;
	}
	public ArrayList<gamedetailbean> getGameDetailList() throws Exception {
		ArrayList<gamedetailbean> ds=new ArrayList<gamedetailbean>();
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement(" Select * From webgamestore.games");
    	ResultSet rs=st.executeQuery();
    	while(rs.next())
    		ds.add(new gamedetailbean(rs.getLong(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getLong(14), rs.getInt(15), rs.getLong(16), rs.getString(17), rs.getString(18)));
    	cn.close();
		return ds;
	}
	public int checkbuy(String un,long GID) throws Exception {
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
    		st=cn.prepareStatement(" Select * From webgamestore.purchase where GID=? and UserID=?");
    		st.setLong(1, GID);
    		st.setLong(2, id);
    		rs=st.executeQuery();
    		if(rs.next()) {
    			cn.close();
    			return 1;
    		}
    			
    	} 	
    	cn.close();
		return 0;
	}
	public void buynow(String un,long gid,long finalcost) throws Exception {
		java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime();
	  	Timestamp purchaseTime=new java.sql.Timestamp(javaTime);
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
    		st=cn.prepareStatement("insert into webgamestore.purchase (UserID,GID,purchaseTime,cost) values (?,?,?,?)");
    		st.setLong(1, id);
    		st.setLong(2, gid);
    		st.setTimestamp(3, purchaseTime);
    		st.setLong(4, finalcost);
    		st.executeUpdate();
    	}
	}
	public activatebean checkcode(String code,String un) throws Exception {
		activatebean abean=new activatebean(0,0);
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("select * from webgamestore.codeactivate where Code=?");
    	st.setString(1, code);
    	ResultSet rs=st.executeQuery();
    	if(rs.next()) {
    		long gid=rs.getLong(2);
    		abean.setGid(gid);
    		if (rs.getBoolean(3)==true) {
    			PreparedStatement st1=cn.prepareStatement("select * from webgamestore.useraccount where accname=?");
				st1.setString(1, un);
				ResultSet rs1=st1.executeQuery();
				if(rs1.next()) {
					long id=rs1.getLong(1);
					PreparedStatement st2=cn.prepareStatement("select * from webgamestore.purchase where GID=? and UserID=?");
					st2.setLong(1, gid);
					st2.setLong(2, id);
					ResultSet rs2=st2.executeQuery();
					if(rs2.next()) {
						abean.setStatus(4);	
					} else {
						st1=cn.prepareStatement("update webgamestore.codeactivate set UserID=? where code=?");
    		    		st1.setLong(1, id);
    		    		st1.setString(2, code);
    		    		st1.executeUpdate();
    		    		java.util.Date javaDate = new java.util.Date();
    		    	    long javaTime = javaDate.getTime();
    		    	  	Timestamp purchaseTime=new java.sql.Timestamp(javaTime);
    		    		st1=cn.prepareStatement("insert into webgamestore.purchase (UserID,GID,purchaseTime,cost) values(?,?,?,?)");
    		    		st1.setLong(1, id);
    		    		st1.setLong(2, gid);
    		    		st1.setTimestamp(3, purchaseTime);
    		    		st1.setLong(4, 0);
    		    		st1.executeUpdate();
    		    		abean.setStatus(1);	
					}
				}
    		} 
    		else {
    			long uid=rs.getLong(4);
    			if(rs.wasNull()) {
    				PreparedStatement st1=cn.prepareStatement("select * from webgamestore.useraccount where accname=?");
    				st1.setString(1, un);
    				ResultSet rs1=st1.executeQuery();
    				if(rs1.next()) {
    					long id=rs1.getLong(1);
    					PreparedStatement st2=cn.prepareStatement("select * from webgamestore.purchase where GID=? and UserID=?");
    					st2.setLong(1, gid);
    					st2.setLong(2, id);
    					ResultSet rs2=st2.executeQuery();
    					if(rs2.next()) {
    						abean.setStatus(4);	
    					} else {
    						st1=cn.prepareStatement("update webgamestore.codeactivate set UserID=? where code=?");
        		    		st1.setLong(1, id);
        		    		st1.setString(2, code);
        		    		st1.executeUpdate();
        		    		java.util.Date javaDate = new java.util.Date();
        		    	    long javaTime = javaDate.getTime();
        		    	  	Timestamp purchaseTime=new java.sql.Timestamp(javaTime);
        		    		st1=cn.prepareStatement("insert into webgamestore.purchase (UserID,GID,purchaseTime,cost) values(?,?,?,?)");
        		    		st1.setLong(1, id);
        		    		st1.setLong(2, gid);
        		    		st1.setTimestamp(3, purchaseTime);
        		    		st1.setLong(4, 0);
        		    		st1.executeUpdate();
        		    		abean.setStatus(1);	
    					}
    		    		
    				}
    			} else 
    				abean.setStatus(3);	
    		}
    	}
    	return abean;
	}
	public void editGame(gamedetailbean gdtbean) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("update webgamestore.games set GName=?,releasedate=?,develop=?,publish=?,OS=?,processor=?,ram=?,gpu=?,directx=?,storage=?,about=?,image=?,cost=?,discount=?,CategoryID=?,imageLarge=?,gameFile=? where GID=?");
    	st.setString(1, gdtbean.getGname());
    	st.setDate(2, gdtbean.getRdate());
    	st.setString(3, gdtbean.getDevelop());
    	st.setString(4, gdtbean.getPublish());
    	st.setString(5, gdtbean.getOs());
    	st.setString(6, gdtbean.getProcessor());
    	st.setString(7, gdtbean.getRam());
    	st.setString(8, gdtbean.getGpu());
    	st.setString(9, gdtbean.getDirectx());
    	st.setString(10, gdtbean.getStorage());
    	st.setString(11, gdtbean.getAbout());
    	st.setString(12, gdtbean.getImg());
    	st.setLong(13, gdtbean.getCost());
    	st.setInt(14, gdtbean.getDiscount());
    	st.setLong(15, gdtbean.getCategoryID());
    	st.setString(16, gdtbean.getImgLarge());
    	st.setString(17, gdtbean.getGameFile());
    	st.setLong(18,gdtbean.getGid());
    	st.executeUpdate();
    	cn.close();
	}
	public void deleteGame(long gid) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("delete from webgamestore.games where GID=?");
    	st.setLong(1, gid);
    	st.executeUpdate();
    	cn.close();
	}
	public void addGame(String gname,Date rdate,String dev,String pub,String os,String process,String ram, String gpu,String dx,String sto,String about,String img,long cost,int discount,long cid,String imgl,String gfile) throws Exception {
		Connection cn;
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Conected");
    	PreparedStatement st=cn.prepareStatement("insert into webgamestore.games (GName,releasedate,develop,publish,OS,processor,ram,gpu,directx,storage,about,image,cost,discount,CategoryID,imageLarge,gameFile) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
    	st.setString(1, gname);
    	st.setDate(2, rdate);
    	st.setString(3, dev);
    	st.setString(4, pub);
    	st.setString(5, os);
    	st.setString(6, process);
    	st.setString(7, ram);
    	st.setString(8, gpu);
    	st.setString(9, dx);
    	st.setString(10, sto);
    	st.setString(11, about);
    	st.setString(12, img);
    	st.setLong(13, cost);
    	st.setInt(14, discount);
    	st.setLong(15, cid);
    	st.setString(16, imgl);
    	st.setString(17, gfile);
    	st.executeUpdate();
    	cn.close();
	}
}
