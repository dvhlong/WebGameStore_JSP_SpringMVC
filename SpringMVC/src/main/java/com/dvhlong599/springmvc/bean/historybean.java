package com.dvhlong599.springmvc.bean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class historybean {
	private String gname;
	private Timestamp purchaseTime;
	private long cost;
	public historybean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public historybean(String gname, Timestamp purchaseTime, long cost) {
		super();
		this.gname = gname;
		this.purchaseTime = purchaseTime;
		this.cost = cost;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Timestamp getPurchaseTime() {
		return purchaseTime;
	}
	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public String getFormatTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM, yyyy hh:mm:ss aaa");
		return sdf.format(purchaseTime);
	}
}
