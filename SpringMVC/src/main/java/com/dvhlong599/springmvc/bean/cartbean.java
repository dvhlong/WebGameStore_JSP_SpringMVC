package com.dvhlong599.springmvc.bean;

public class cartbean {
	private long gid;
	private String gname;
	private long finalcost;
	public cartbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public cartbean(long gid, String gname, long finalcost) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.finalcost = finalcost;
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
	public long getFinalcost() {
		return finalcost;
	}
	public void setFinalcost(long finalcost) {
		this.finalcost = finalcost;
	}
	
}
