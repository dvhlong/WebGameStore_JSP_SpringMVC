package com.dvhlong599.springmvc.bo;

import java.sql.Date;
import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.activatebean;
import com.dvhlong599.springmvc.bean.gamebean;
import com.dvhlong599.springmvc.bean.gamedetailbean;
import com.dvhlong599.springmvc.dao.gamedao;

public class gamebo {
	public ArrayList<gamebean> searchGame(String key) throws Exception {
		gamedao gdao=new gamedao();
		ArrayList<gamebean> tam= new ArrayList<gamebean>();
		ArrayList<gamebean> ds=gdao.getGame();
		for(gamebean s:ds) {
			if(s.getGname().toLowerCase().trim().contains(key.toLowerCase().trim())){
				System.out.println(s.getGname());
				tam.add(s);
			}
		}
		return tam;
	}
	public ArrayList<gamebean> searchByCategory(long CategoryID) throws Exception {
		gamedao gdao=new gamedao();
		ArrayList<gamebean> tam=new ArrayList<gamebean>();
		ArrayList<gamebean> glist=gdao.getGame();
		for(gamebean g: glist) {
			if(g.getCategoryID()==CategoryID)
				//System.out.println(g.getGname());
				tam.add(g);
		}
		return tam;
	}
	public ArrayList<gamebean> getGame() throws Exception {
		gamedao gdao=new gamedao();
		return gdao.getGame();
	}
	public ArrayList<gamebean> getGameUseCode() throws Exception {
		gamedao gdao=new gamedao();
		return gdao.getGameUseCode();
	}
	public gamedetailbean getGameDetail(Long GID) throws Exception {
		gamedao gdao=new gamedao();
		return gdao.getGameDetail(GID);
	}
	public int checkbuy(String un,long gid) throws Exception {
		gamedao gdao=new gamedao();
		return gdao.checkbuy(un, gid);
	}
	public void buynow(String un,long gid,long finalcost) throws Exception {
		gamedao gdao=new gamedao();
		gdao.buynow(un, gid, finalcost);
	}
	public activatebean checkcode(String code,String un) throws Exception {
		gamedao gdao=new gamedao();
		return gdao.checkcode(code, un);
	}
	public ArrayList<gamedetailbean> getGameDetailList() throws Exception{
		gamedao gdao=new gamedao();
		return gdao.getGameDetailList();
	}
	public void editGame(gamedetailbean gdtbean) throws Exception {
		gamedao gdao=new gamedao();
		gdao.editGame(gdtbean);
	}
	public void deleteGame(long gid) throws Exception {
		gamedao gdao=new gamedao();
		gdao.deleteGame(gid);
	}
	public void addGame(String gname,Date rdate,String dev,String pub,String os,String process,String ram, String gpu,String dx,String sto,String about,String img,long cost,int discount,long cid,String imgl,String gfile) throws Exception {
		gamedao gdao=new gamedao();
		gdao.addGame(gname, rdate, dev, pub, os, process, ram, gpu, dx, sto, about, img, cost, discount, cid, imgl, gfile);
	}
}
