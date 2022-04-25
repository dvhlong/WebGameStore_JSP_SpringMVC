package com.dvhlong599.springmvc.bean;

public class activatebean {
	long gid;
	int status;
	public activatebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public activatebean(long gid, int status) {
		super();
		this.gid = gid;
		this.status = status;
	}
	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
