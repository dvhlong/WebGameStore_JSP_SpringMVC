package com.dvhlong599.springmvc.bean;

public class userbean {
	private String un;
	private String pass;
	private String email;
	public userbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public userbean(String un, String pass, String email) {
		super();
		this.un = un;
		this.pass = pass;
		this.email = email;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
