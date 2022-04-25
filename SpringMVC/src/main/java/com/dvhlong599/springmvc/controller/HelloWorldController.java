package com.dvhlong599.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvhlong599.springmvc.bean.JavaEEN4_DoanVanHoangLong_NXBbean;
import com.dvhlong599.springmvc.bo.Connectbo;
import com.dvhlong599.springmvc.bo.JavaEEN4_DoanVanHoangLong_NXBbo;
import com.dvhlong599.springmvc.dao.JavaEEN4_DoanVanHoangLong_NXBdao;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(Model model) {
       
        model.addAttribute("greeting", "Chạy thành công Spring MVC");
       
        return "helloworld";
       
    }
    @RequestMapping("/test1")
    public ModelAndView test1(Model model) {
    	model.addAttribute("test1", "Chạy thành công Spring MVC");
    	return new ModelAndView("parameter");
    }
    @RequestMapping("/checkparameter")
    public String checkparameter(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	try {
    		request.setCharacterEncoding("utf-8");
    		//response.setCharacterEncoding("utf-8");
    		String p=request.getParameter("hoten");
    		System.out.print(p);
    		session.setAttribute("StringGeted", p);
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return "redirect:test1";
    }
    @RequestMapping("/testConnect")
    public String testConnect(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	session.setAttribute("ConnectStatus", "Thất Bại");
    	try {
			Connectbo cnbo=new Connectbo();
			cnbo.KetNoi();
			session.setAttribute("ConnectStatus", "Thành Công");
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return "redirect:test2";
    }
    @RequestMapping("/test2")
    public ModelAndView test2(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	model.addAttribute("test2", "Chạy thành công Spring MVC");
    	return new ModelAndView("connectDB");
    }
    @RequestMapping("/searchNXB")
    public ModelAndView test3(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	try {
    		request.setCharacterEncoding("utf-8");
    		request.setAttribute("dsnxb", null);
    		JavaEEN4_DoanVanHoangLong_NXBbo nxbbo=new JavaEEN4_DoanVanHoangLong_NXBbo();
    		JavaEEN4_DoanVanHoangLong_NXBdao nxbdao=new JavaEEN4_DoanVanHoangLong_NXBdao();
    		model.addAttribute("test3", "Chạy thành công Spring MVC");
    		String key=request.getParameter("key");
    		ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean> dsnxb=new ArrayList<JavaEEN4_DoanVanHoangLong_NXBbean>();
    		if(request.getParameter("searchbutton")!=null)
    		if(key!=null) {
   	   		 	dsnxb=nxbbo.Tim(key);
   	   		 	request.setAttribute("dsnxb", dsnxb);
    		}
    		else {
    			dsnxb=nxbdao.getNXB();
    			request.setAttribute("dsnxb", dsnxb);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return new ModelAndView("NXB");
    }
}