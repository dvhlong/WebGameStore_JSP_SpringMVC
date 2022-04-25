package com.dvhlong599.springmvc.bo;

import java.util.ArrayList;

import com.dvhlong599.springmvc.bean.reviewbean;
import com.dvhlong599.springmvc.dao.reviewdao;

public class reviewbo {
	public ArrayList<reviewbean> getReview(Long gid) throws Exception {
		reviewdao rdao= new reviewdao();
		return rdao.getReview(gid);
	}
	public reviewbean getPersonalReview(String un,Long gid) throws Exception {
		reviewbo rbo=new reviewbo();
		ArrayList<reviewbean> ds=rbo.getReview(gid);
		reviewbean rbean=null;
		for(reviewbean r:ds) {
			if(r.getGid()==gid&&r.getUn().equals(un))
				rbean=new reviewbean(r.getUn(), r.getGid(), r.getContent(), r.getStar(),r.getRdate());
		}
		return rbean;
	}
	public String getAverageStar(Long gid) throws Exception {
		reviewbo rbo=new reviewbo();
		ArrayList<reviewbean> ds=rbo.getReview(gid);
		long s=0;
		long n=ds.size();
		for(reviewbean r: ds) {
			s=s+r.getStar();
		}
		return String.format("%.1f", (float)s/n);
	}
	public void addReview(String un,long gid,String content,int star) throws Exception {
		reviewdao rdao=new reviewdao();
		rdao.addReview(un, gid, content, star);
	}
	public void updateReview(String un,long gid,String content,int star) throws Exception {
		reviewdao rdao=new reviewdao();
		rdao.updateReview(un, gid, content, star);
	}
	public void deleteReview(String un,long gid) throws Exception {
		reviewdao rdao=new reviewdao();
		rdao.deleteReview(un, gid);
	}
}
