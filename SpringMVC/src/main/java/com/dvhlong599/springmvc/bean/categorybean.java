package com.dvhlong599.springmvc.bean;

public class categorybean {
	private long categoryID;
	private String categoryName;
	public categorybean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public categorybean(long categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
