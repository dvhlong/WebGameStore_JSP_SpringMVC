package com.dvhlong599.springmvc.bean;

public class codebean {
	private String code;
	private long gid;
	private boolean isNoLimit;
	private long uid;
	public codebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public codebean(String code, long gid, boolean isNoLimit, long uid) {
		super();
		this.code = code;
		this.gid = gid;
		this.isNoLimit = isNoLimit;
		this.uid = uid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public boolean isNoLimit() {
		return isNoLimit;
	}
	public void setNoLimit(boolean isNoLimit) {
		this.isNoLimit = isNoLimit;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	
}
