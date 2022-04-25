package com.dvhlong599.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RedirectAttributesMethodArgumentResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dvhlong599.springmvc.bean.activatebean;
import com.dvhlong599.springmvc.bean.cartbean;
import com.dvhlong599.springmvc.bean.categorybean;
import com.dvhlong599.springmvc.bean.gamebean;
import com.dvhlong599.springmvc.bean.gamedetailbean;
import com.dvhlong599.springmvc.bean.historybean;
import com.dvhlong599.springmvc.bean.reviewbean;
import com.dvhlong599.springmvc.bean.userbean;
import com.dvhlong599.springmvc.bo.cartbo;
import com.dvhlong599.springmvc.bo.categorybo;
import com.dvhlong599.springmvc.bo.gamebo;
import com.dvhlong599.springmvc.bo.historybo;
import com.dvhlong599.springmvc.bo.reviewbo;
import com.dvhlong599.springmvc.bo.userbo;

@Controller
public class gstoreController {
	@RequestMapping("/showGameList")
	public ModelAndView showGameList(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String activatefail=request.getParameter("activatefail");
			categorybo cbo=new categorybo();
			gamebo gbo=new gamebo();
			ArrayList<categorybean> clist=cbo.getCategory();
			ArrayList<gamebean> glist=gbo.getGame();
			String key=request.getParameter("key");
			String cid=request.getParameter("cid");
			if(cid!=null) {
				glist=gbo.searchByCategory(Long.parseLong(cid));
				for(gamebean g:glist)
					System.out.println(g.getGname());
			} else 
				if(key!=null)
				glist=gbo.searchGame(key);
			model.addAttribute("clist", clist);
			model.addAttribute("glist",glist);
			model.addAttribute("activatefail",activatefail);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("GameHome");
	}
	@RequestMapping("/showCart")
	public ModelAndView showCart(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			cartbo cbo=(cartbo) session.getAttribute("cbo");
				if(cbo==null) {
					cbo=new cartbo();
					session.setAttribute("cbo", cbo);
				}
				cbo=(cartbo) session.getAttribute("cbo");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("Cart");
	}
	@RequestMapping("/showGameDetail")
	public ModelAndView showGameDetail(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			gamebo gbo=new gamebo();
			reviewbo rbo=new reviewbo();
			cartbo cbo=(cartbo) session.getAttribute("cbo");
			String gid=request.getParameter("gid");
			String un=request.getParameter("un");
			String gname=request.getParameter("gname");
			String txtstar=request.getParameter("txtstar");
			String txtreview=request.getParameter("txtreview");
			String cost=request.getParameter("cost");
			String buynow=request.getParameter("buynow");
			String removeCart=request.getParameter("remove");
			String addCart=request.getParameter("add");
			String status=request.getParameter("status");
			if(status!=null) {
				session.setAttribute("status", status);
			} else {
				session.setAttribute("status", null);
			}
			if(buynow!=null) {
				if (cbo!=null)
					cbo.deleteFromCart(Long.parseLong(gid));
				session.setAttribute("cbo", cbo);
				System.out.println("a");
				gbo.buynow(un, Long.parseLong(gid), Long.parseLong(cost));
				System.out.println("b");
			}
			if(removeCart!=null) {
				if (cbo!=null)
					cbo.deleteFromCart(Long.parseLong(gid));
				session.setAttribute("cbo", cbo);
			}
			if(addCart!=null) {
				if(cbo==null) {
					cbo=new cartbo();
					session.setAttribute("cbo", cbo);
				}
				cbo=(cartbo) session.getAttribute("cbo");
				cbo.addToCart(Long.parseLong(gid), gname, Long.parseLong(cost));
				session.setAttribute("cbo", cbo);
			}
			if(request.getParameter("addReview")!=null) {
				rbo.addReview(un, Long.parseLong(gid), txtreview, Integer.parseInt(txtstar));
			}
			if(request.getParameter("updateReview")!=null) {
				rbo.updateReview(un, Long.parseLong(gid), txtreview, Integer.parseInt(txtstar));
			}
			if(request.getParameter("deleteReview")!=null) {
				rbo.deleteReview(un, Long.parseLong(gid));
			}
			ArrayList<reviewbean> rlist=rbo.getReview(Long.parseLong(gid));
			gamedetailbean gdtbean=gbo.getGameDetail(Long.parseLong(gid));
			reviewbean pReview=rbo.getPersonalReview(un, Long.parseLong(gid));
			String averageStar=rbo.getAverageStar(Long.parseLong(gid));
			model.addAttribute("gdtbean",gdtbean);
			model.addAttribute("rlist",rlist);
			model.addAttribute("pReview",pReview);
			model.addAttribute("averageStar",averageStar);
			model.addAttribute("checkbuy",gbo.checkbuy(un, Long.parseLong(gid)));
			model.addAttribute("isInCart",cbo.isToCart(cbo, Long.parseLong(gid)));
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("GameDetail");
	}
	@RequestMapping("/userLogin")
	public String userLogin(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String un=request.getParameter("txtun");
			String pass=request.getParameter("txtpw");
			System.out.println(un+' '+pass);
			userbo ubo=new userbo();
			userbean u;
			u=ubo.checkLogin(un, pass);
			if(u!=null){
				System.out.println(u.getUn()+' '+u.getPass());
		    	 session.setAttribute("u", u);
		    	 session.setAttribute("tb", null);
		     }else{
		    	 System.out.println("null");
		    	 session.setAttribute("tb", "Dang nhap sai");
		    	 session.setAttribute("u", null);
		     }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:showGameList";
	}
	@RequestMapping("/userLogout")
	public String userLoout(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session.setAttribute("u", null);
		session.setAttribute("tb", null);
		return "redirect:showGameList";
	}
	@RequestMapping("/userSignup")
	public String userSignup(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String un=request.getParameter("newun");
			String email=request.getParameter("newemail");
			String pass=request.getParameter("newpass");
			String repass=request.getParameter("newrepass");
			userbo ubo=new userbo();
			ubo.add(un, email, pass, repass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:showGameList";
	}
	@RequestMapping("/userChangePass")
	public String userChangePass(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String un=request.getParameter("un");
			String pass=request.getParameter("pass");
			String oldpass=request.getParameter("oldpass");
			String newpass=request.getParameter("newpass");
			String newrepass=request.getParameter("newrepass");
			userbo ubo=new userbo();
			if(oldpass.equals(pass)&&newpass.equals(newrepass)) {
				ubo.changePass(un, newpass);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:showGameList";
	}
	@RequestMapping("/removeFromCart")
	public String removeFromCart(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String gid=request.getParameter("gid");
			cartbo cbo=(cartbo) session.getAttribute("cbo");
			cbo.deleteFromCart(Long.parseLong(gid));
			session.setAttribute("cbo", cbo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:showCart";
	}
	@RequestMapping("/purchase")
	public String purchase(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			cartbo cbo=(cartbo) session.getAttribute("cbo");
			String un=request.getParameter("un");
			if(cbo.ds.size()!=0) {
				cbo.purchaseCart(cbo, un);
				session.setAttribute("cbo", null);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:showCart";
	}
	@RequestMapping("/purchaseHistory")
	public ModelAndView purchaseHistory(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			userbean u=(userbean) session.getAttribute("u");
			historybo hbo= new historybo();
			ArrayList<historybean> hlist=hbo.getHistory(u.getUn());
			long totalPurchaseCost=hbo.totalPurchase(hlist);
			model.addAttribute("totalPurchaseCost",totalPurchaseCost);
			model.addAttribute("hlist",hlist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("PurchaseHistory");
	}
	@RequestMapping("/activateGame")
	public String activateGame(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session,RedirectAttributes ra) {
		try {
			request.setCharacterEncoding("utf-8");
			String code=request.getParameter("code");
			userbean user=(userbean) session.getAttribute("u");
			gamebo gbo=new gamebo();
			long gid=0;
			if(code!=null) {
				activatebean a=gbo.checkcode(code, user.getUn());
				if (a.getGid()!=0) {
					gid=a.getGid();
					gamedetailbean gdtbean=gbo.getGameDetail(gid);
					System.out.println("Status send: "+String.valueOf(a.getStatus()));
					if(a.getStatus()==1) {
						cartbo cbo=(cartbo) session.getAttribute("cbo");
						if(cbo!=null) {
							cbo.deleteFromCart(gid);
							session.setAttribute("cbo", cbo);
						}
						ra.addAttribute("status","Activate Successful: You have own "+gdtbean.getGname());
					}
					if(a.getStatus()==3)
						ra.addAttribute("status","Activate fail: Code already used!!!!");
					if(a.getStatus()==4)
						ra.addAttribute("status","Activate fail: You own this game!!!!");
				}
			}
			if(gid==0) {
				ra.addAttribute("activatefail", "fails");
				return "redirect:showGameList";
			}
			ra.addAttribute("gid", gid);
			ra.addAttribute("un", user.getUn());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:showGameDetail";
	}
}
