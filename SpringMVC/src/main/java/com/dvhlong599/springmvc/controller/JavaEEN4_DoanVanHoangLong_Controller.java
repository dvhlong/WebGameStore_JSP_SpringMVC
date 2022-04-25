package com.dvhlong599.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dvhlong599.springmvc.bean.JavaEEN4_DoanVanHoangLong_Sachbean;
import com.dvhlong599.springmvc.bo.JavaEEN4_DoanVanHoangLong_Sachbo;


@Controller
public class JavaEEN4_DoanVanHoangLong_Controller {
	@RequestMapping("/searchSach")
    public ModelAndView test3(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
    	try {
    		request.setCharacterEncoding("utf-8");
    		request.setAttribute("dssach", null);
    		request.setAttribute("tb", null);
    		JavaEEN4_DoanVanHoangLong_Sachbo sbo=new JavaEEN4_DoanVanHoangLong_Sachbo();
    		model.addAttribute("test4", "Chạy thành công Spring MVC");
    		String key=request.getParameter("key");
    		System.out.println(key);
    		ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean> dssach=new ArrayList<JavaEEN4_DoanVanHoangLong_Sachbean>();
    		if(request.getParameter("searchbutton")!=null)
    		if(key!=null) {
    			if (request.getParameter("chon").equals("tensach")) {
   	   		 	dssach=sbo.Timtensach(key);
   	   		 	if(dssach.size()==0)
   	   		 		request.setAttribute("tb", "Ko tìm thấy");
   	   		 	else
   	   		 		request.setAttribute("dssach", dssach);
    			}
    			if (request.getParameter("chon").equals("gia")) {
       	   		 	dssach=sbo.TimGia(key);
       	   		 	if(dssach.size()==0)
       	   		 		request.setAttribute("tb", "Ko tìm thấy");
       	   		 	else
       	   		 		request.setAttribute("dssach", dssach);
        		}
    		}
    		else {
    			dssach=sbo.getSach();
    			request.setAttribute("dssach", dssach);
    		}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return new ModelAndView("Sach");
    }
}
