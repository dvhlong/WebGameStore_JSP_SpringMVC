package com.dvhlong599.springmvc.bean;

public class JavaEEN4_DoanVanHoangLong_Sachbean {
	private Long masach;
	private String tensach;
	private String tacgia;
	private Long gia;
	private Long soluong;
	public JavaEEN4_DoanVanHoangLong_Sachbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JavaEEN4_DoanVanHoangLong_Sachbean(Long masach, String tensach, String tacgia, Long gia, Long soluong) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.soluong = soluong;
	}
	public Long getMasach() {
		return masach;
	}
	public void setMasach(Long masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public long thanhtien() {
		return this.gia*this.soluong;
	}
	public String Muc() {
		if (this.thanhtien()>1000000)
			return "Cao";
		else
			return "Trung Bình";
	}
}
