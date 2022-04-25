package com.dvhlong599.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectdao {
	public void KetNoi() throws Exception{
		Connection cn;
//		System.out.println("Da xac dinh HQTCSDL");
		Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/webgamestore?user=root&password=123456";
    	cn=DriverManager.getConnection(url);
    	System.out.println("Da ket noi");
    	cn.close();
    	}
}
