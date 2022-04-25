package com.dvhlong599.springmvc.controller;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dvhlong599.springmvc.bean.categorybean;
import com.dvhlong599.springmvc.bean.codebean;
import com.dvhlong599.springmvc.bean.gamebean;
import com.dvhlong599.springmvc.bean.gamedetailbean;
import com.dvhlong599.springmvc.bo.adminbo;
import com.dvhlong599.springmvc.bo.categorybo;
import com.dvhlong599.springmvc.bo.codebo;
import com.dvhlong599.springmvc.bo.gamebo;
import com.dvhlong599.springmvc.dao.gamedao;

import nl.captcha.Captcha;

@Controller
public class gstore_adminController {
	@RequestMapping("/showAdmin")
	public ModelAndView showAdmin(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		return new ModelAndView("GameAdmin");
	}
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			String un=request.getParameter("txtun"); 
			String pass=request.getParameter("txtpw");
			String answer = request.getParameter("answer");
		  	adminbo adbo=new adminbo();
		  	long dem;
		  	if(session.getAttribute("showcapt")==null){
		  		dem=0;
		  		session.setAttribute("showcapt", dem);//=Integer.parseInt( (String) session.getAttribute("showcapt"));
		  	}
		  	dem=(Long) session.getAttribute("showcapt");
		  	if(adbo.ktdnAdmin(un, pass)) {
		  		if(dem>=3) {
		  		if(!captcha.isCorrect(answer)) {
		  			dem++;
		  			session.setAttribute("showcapt", dem);
		  			session.setAttribute("tbad", "Capcha sai");
		  			return new ModelAndView("GameAdmin");
		  		} else {
		  			dem=0;
					session.setAttribute("showcapt", dem);
					session.setAttribute("adun", un);
					return new ModelAndView("GameAdmin");
		  		}
		  		} else {
		  		dem=0;
				session.setAttribute("showcapt", dem);
				session.setAttribute("adun", un);
				return new ModelAndView("GameAdmin");
		  		}
		  	}else {
		  		dem++;
		  		session.setAttribute("showcapt", dem);
		  		session.setAttribute("tbad", "Dang nhap sai");
		  	}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("GameAdmin");
	}
	@RequestMapping("/adminLogout")
	public ModelAndView adminLogout(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		session.setAttribute("adun", null);
		session.setAttribute("tbad", null);
		return new ModelAndView("GameAdmin");
	}
	@RequestMapping("/adminSignup")
	public ModelAndView adminSignup(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			String un=request.getParameter("newun");
			String pass=request.getParameter("newpass");
			String repass=request.getParameter("newrepass");
			adminbo adbo= new adminbo();
			adbo.add(un, pass, repass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("GameAdmin");
	}
	@RequestMapping("/manageGame")
	public ModelAndView manageGame(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			gamebo gbo=new gamebo();
			categorybo cbo= new categorybo();
			ArrayList<gamedetailbean> gdtList= gbo.getGameDetailList();
			ArrayList<categorybean> clist=cbo.getCategory();
			model.addAttribute("clist",clist);
			model.addAttribute("gdtList",gdtList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("ManageGame");
	}
	@RequestMapping("/manageCategory")
	public ModelAndView manageCategory(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			categorybo cbo= new categorybo();
			ArrayList<categorybean> clist=cbo.getCategory();
			model.addAttribute("clist",clist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("ManageCategory");
	}
	@RequestMapping("/showEditGame")
	public ModelAndView showEditGame(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			categorybo cbo= new categorybo();
			gamebo gbo=new gamebo();
			ArrayList<categorybean> clist=cbo.getCategory();
			model.addAttribute("clist",clist);
			String gid=request.getParameter("gid");
			gamedetailbean gdtbean=gbo.getGameDetail(Long.parseLong(gid));
			model.addAttribute("gdtbean",gdtbean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("EditGame");
	}
	@RequestMapping("/deleteGame")
	public String deleteGame(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String gid=request.getParameter("gid");
			gamebo gbo=new gamebo();
			gbo.deleteGame(Long.parseLong(gid));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:manageGame";
	}
	@RequestMapping("/editGame")
	public String editGame(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session,RedirectAttributes ra) {
		try {
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String gid=request.getParameter("gid");
			String gname="";
			Date rdate=null;
			String dev="";
			String pub="";
			String os="";
			String process="";
			String ram="";
			String gpu="";
			String dx="";
			String sto="";
			String about="";
			String img=request.getParameter("oldimg");
			long cost=0;
			int discount=0;
			long cid=0;
			String imgl=request.getParameter("oldimgl");
			String file=request.getParameter("oldgfile");
			List<FileItem> fItems = upload.parseRequest(request);
			for(FileItem fItem:fItems) {
				if(!fItem.isFormField()) {
					String fieldName = fItem.getFieldName();
					String nameimg = new File(fItem.getName()).getName();
					if(fieldName.equals("img")) {
						if(!nameimg.equals("")) {
							 try {
								 img=nameimg;
								 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE_EXAM\\SpringMVC\\src\\main\\webapp\\imgGame"+File.separator+nameimg));
								 System.out.println("UPLOAD THÀNH CÔNG...!");
					             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
								// TODO: handle exception
								 e.printStackTrace();
							 }
						}
					}
					if(fieldName.equals("imgl")) {
						if(!nameimg.equals("")) {
							 try {
								 imgl=nameimg;
								 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE_EXAM\\SpringMVC\\src\\main\\webapp\\imgGameLarge"+File.separator+nameimg));
								 System.out.println("UPLOAD THÀNH CÔNG...!");
					             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
								// TODO: handle exception
								 e.printStackTrace();
							 }
						}
					}
					if(fieldName.equals("gfile")) {
						if(!nameimg.equals("")) {
							 try {
								 file=nameimg;
								 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE_EXAM\\SpringMVC\\src\\main\\webapp\\gameFile"+File.separator+nameimg));
								 System.out.println("UPLOAD THÀNH CÔNG...!");
					             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
								// TODO: handle exception
								 e.printStackTrace();
							 }
						}
					}
				} else {
					String fieldName = fItem.getFieldName();
					if(fieldName.equals("gname"))
						gname=fItem.getString("utf-8");
					if(fieldName.equals("rdate"))
						rdate=Date.valueOf(fItem.getString("utf-8"));
					if(fieldName.equals("dev"))
						dev=fItem.getString("utf-8");
					if(fieldName.equals("pub"))
						pub=fItem.getString("utf-8");
					if(fieldName.equals("os"))
						os=fItem.getString("utf-8");
					if(fieldName.equals("process"))
						process=fItem.getString("utf-8");
					if(fieldName.equals("ram"))
						ram=fItem.getString("utf-8");
					if(fieldName.equals("gpu"))
						gpu=fItem.getString("utf-8");
					if(fieldName.equals("dx"))
						dx=fItem.getString("utf-8");
					if(fieldName.equals("sto"))
						sto=fItem.getString("utf-8");
					if(fieldName.equals("about"))
						about=fItem.getString("utf-8");
					if(fieldName.equals("cost"))
						cost=Long.valueOf(fItem.getString("utf-8"));
					if(fieldName.equals("discount"))
						discount=Integer.valueOf(fItem.getString("utf-8"));
					if(fieldName.equals("cid"))
						cid=Long.valueOf(fItem.getString("utf-8"));
				}
			}
			
			gamedetailbean gdtbean=new gamedetailbean(Long.parseLong(gid), gname, rdate, dev, pub, os, process, ram, gpu, dx, sto, about, img, cost, discount, cid, imgl, file);
			gamebo gbo=new gamebo();
			gbo.editGame(gdtbean);
			ra.addAttribute("gid", gid);
		} catch (FileUploadException e) {
				// TODO: handle exception
				e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return "redirect:showEditGame";
	}
	@RequestMapping("/addGame")
	public String addGame(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session,RedirectAttributes ra) {
		try {
			request.setCharacterEncoding("utf-8");
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			String gname="";
			Date rdate=null;
			String dev="";
			String pub="";
			String os="";
			String process="";
			String ram="";
			String gpu="";
			String dx="";
			String sto="";
			String about="";
			String img="";
			long cost=0;
			int discount=0;
			long cid=0;
			String imgl="";
			String file="";
			List<FileItem> fItems = upload.parseRequest(request);
			for(FileItem fItem:fItems) {
				if(!fItem.isFormField()) {
					String fieldName = fItem.getFieldName();
					String nameimg = new File(fItem.getName()).getName();
					if(fieldName.equals("img")) {
						if(!nameimg.equals("")) {
							 try {
								 img=nameimg;
								 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE_EXAM\\SpringMVC\\src\\main\\webapp\\imgGame"+File.separator+nameimg));
								 System.out.println("UPLOAD THÀNH CÔNG...!");
					             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
								// TODO: handle exception
								 e.printStackTrace();
							 }
						}
					}
					if(fieldName.equals("imgl")) {
						if(!nameimg.equals("")) {
							 try {
								 imgl=nameimg;
								 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE_EXAM\\SpringMVC\\src\\main\\webapp\\imgGameLarge"+File.separator+nameimg));
								 System.out.println("UPLOAD THÀNH CÔNG...!");
					             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
								// TODO: handle exception
								 e.printStackTrace();
							 }
						}
					}
					if(fieldName.equals("gfile")) {
						if(!nameimg.equals("")) {
							 try {
								 file=nameimg;
								 fItem.write(new File("D:\\Download\\JAVA\\JAVAEE_EXAM\\SpringMVC\\src\\main\\webapp\\gameFile"+File.separator+nameimg));
								 System.out.println("UPLOAD THÀNH CÔNG...!");
					             //System.out.println("Đường dẫn lưu file là: "+dirUrl);
							 } catch (Exception e) {
								// TODO: handle exception
								 e.printStackTrace();
							 }
						}
					}
				} else {
					String fieldName = fItem.getFieldName();
					if(fieldName.equals("gname"))
						gname=fItem.getString("utf-8");
					if(fieldName.equals("rdate"))
						rdate=Date.valueOf(fItem.getString("utf-8"));
					if(fieldName.equals("dev"))
						dev=fItem.getString("utf-8");
					if(fieldName.equals("pub"))
						pub=fItem.getString("utf-8");
					if(fieldName.equals("os"))
						os=fItem.getString("utf-8");
					if(fieldName.equals("process"))
						process=fItem.getString("utf-8");
					if(fieldName.equals("ram"))
						ram=fItem.getString("utf-8");
					if(fieldName.equals("gpu"))
						gpu=fItem.getString("utf-8");
					if(fieldName.equals("dx"))
						dx=fItem.getString("utf-8");
					if(fieldName.equals("sto"))
						sto=fItem.getString("utf-8");
					if(fieldName.equals("about"))
						about=fItem.getString("utf-8");
					if(fieldName.equals("cost"))
						cost=Long.valueOf(fItem.getString("utf-8"));
					if(fieldName.equals("discount"))
						discount=Integer.valueOf(fItem.getString("utf-8"));
					if(fieldName.equals("cid"))
						cid=Long.valueOf(fItem.getString("utf-8"));
				}
			}
			gamebo gbo=new gamebo();
			gbo.addGame(gname, rdate, dev, pub, os, process, ram, gpu, dx, sto, about, img, cost, discount, cid, imgl, file);
		} catch (FileUploadException e) {
			// TODO: handle exception
			e.printStackTrace();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:manageGame";
	}
	@RequestMapping("/editCategory")
	public String editCategory(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String cid=request.getParameter("cid");
			String cname=request.getParameter("cname");
			categorybo cbo=new categorybo();
			if(request.getParameter("butsua")!=null) {
				cbo.updateCategory(Long.parseLong(cid), cname);
			}
			if(request.getParameter("butxoa")!=null) {
				cbo.deleteCategory(Long.parseLong(cid));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:manageCategory";
	}
	@RequestMapping("/addCategory")
	public String addCategory(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String cname=request.getParameter("cname");
			categorybo cbo=new categorybo();
			cbo.addCategory(cname);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:manageCategory";
	}
	@RequestMapping("/manageCode")
	public ModelAndView manageCode(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			codebo cbo=new codebo();
			gamebo gbo=new gamebo();
			ArrayList<codebean> clist=cbo.getCodeList();
			ArrayList<gamebean> glist=gbo.getGameUseCode();
			model.addAttribute("clist",clist);
			model.addAttribute("glist",glist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("ManageCode");
	}
	@RequestMapping("/addCode")
	public String addCode(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String gid=request.getParameter("gid");
			String nolimit=request.getParameter("nolimit");
			codebo cbo=new codebo();
			cbo.addCode(Long.parseLong(gid), Integer.parseInt(nolimit));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:manageCode";
	}
	@RequestMapping("/deleteCode")
	public String deleteCode(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		try {
			request.setCharacterEncoding("utf-8");
			String code=request.getParameter("code");
			codebo cbo=new codebo();
			cbo.deleteCode(code);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "redirect:manageCode";
	}
}
