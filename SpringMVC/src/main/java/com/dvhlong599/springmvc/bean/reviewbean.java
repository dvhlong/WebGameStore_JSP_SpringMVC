package com.dvhlong599.springmvc.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class reviewbean {
	private String un;
	private Long gid;
	private String content;
	private int star;
	private Date rdate;
	public reviewbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public reviewbean(String un, Long gid, String content, int star, Date rdate) {
		super();
		this.un = un;
		this.gid = gid;
		this.content = content;
		this.star = star;
		this.rdate = rdate;
	}

	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
	public Date getRdate() {
		return rdate;
	}
	public String getRdateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM, yyyy");
		return sdf.format(rdate);
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getFormatContent(){
		String st=content.replace("\n", "<br>");
		return st;
	}
	
}
