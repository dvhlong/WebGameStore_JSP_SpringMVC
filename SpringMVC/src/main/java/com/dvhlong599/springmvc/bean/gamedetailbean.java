package com.dvhlong599.springmvc.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class gamedetailbean {
	private long gid;
	private String gname;
	private Date releasedate;
	private String develop;
	private String publish;
	private String os;
	private String processor;
	private String ram;
	private String gpu;
	private String directx;
	private String storage;
	private String about;
	private String img;
	private long cost;
	private int discount;
	private long CategoryID;
	private String imgLarge;
	private String gameFile;
	public gamedetailbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public gamedetailbean(long gid, String gname, Date releasedate, String develop, String publish, String os,
			String processor, String ram, String gpu, String directx, String storage, String about, String img,
			long cost, int discount, long categoryID, String imgLarge, String gameFile) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.releasedate = releasedate;
		this.develop = develop;
		this.publish = publish;
		this.os = os;
		this.processor = processor;
		this.ram = ram;
		this.gpu = gpu;
		this.directx = directx;
		this.storage = storage;
		this.about = about;
		this.img = img;
		this.cost = cost;
		this.discount = discount;
		this.CategoryID = categoryID;
		this.imgLarge = imgLarge;
		this.gameFile = gameFile;
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
	public Date getRdate() {
		return releasedate;
	}
	public String getEditReleasedate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(releasedate);
	}
	public String getReleasedate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM, yyyy");
		return sdf.format(releasedate);
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}
	public String getDevelop() {
		return develop;
	}
	public void setDevelop(String develop) {
		this.develop = develop;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getGpu() {
		return gpu;
	}
	public void setGpu(String gpu) {
		this.gpu = gpu;
	}
	public String getDirectx() {
		return directx;
	}
	public void setDirectx(String directx) {
		this.directx = directx;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
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
		this.CategoryID = categoryID;
	}
	public long getFinalCost() {
		return cost-Math.round(cost*discount/100);
	}
	public String getImgLarge() {
		return imgLarge;
	}
	public void setImgLarge(String imgLarge) {
		this.imgLarge = imgLarge;
	}
	public String getGameFile() {
		return gameFile;
	}
	public void setGameFile(String gameFile) {
		this.gameFile = gameFile;
	}
	
}
