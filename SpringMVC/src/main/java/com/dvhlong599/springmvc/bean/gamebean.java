package com.dvhlong599.springmvc.bean;

import java.sql.Date;

@SuppressWarnings("unused")
public class gamebean {
	private long gid;
	private String gname;
	private String img;
	private long cost;
	private int discount;
	private long CategoryID;
	public gamebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public gamebean(long gid, String gname, String img, long cost, int discount, long categoryID) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.img = img;
		this.cost = cost;
		this.discount = discount;
		CategoryID = categoryID;
	}
	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public long getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(long categoryID) {
		CategoryID = categoryID;
	}
	public long getFinalCost() {
		return cost-Math.round(cost*discount/100);
	}
}
