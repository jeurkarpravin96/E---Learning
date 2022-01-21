package com.cdac.cntr;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Admin;
import com.cdac.dto.User;
import com.cdac.serv.adminService;
@Controller
public class adminController {
	
	@Autowired
	private adminService Adminservice;
	
	@RequestMapping(value = "/prep_log_admin_form.htm", method = RequestMethod.GET)
	public String preplogAdminForm(ModelMap map) {
		map.put("admin", new Admin());
		return "log_admin_form";
	}
	
	@RequestMapping(value = "/log_admin_form.htm", method = RequestMethod.POST)
	public String  logAdminForm(Admin admin, ModelMap map,HttpSession session) {
		boolean check = Adminservice.validateAdmin(admin);
		System.out.println("check"+check);
		if(check) {
			Admin a = Adminservice.getAdmin(admin);
			session.setAttribute("admin_s", a);
			//System.out.println(a);
			map.put("admin", admin);
		return "adminLoginSuccess";
		}
		else {
			map.put("admin", new Admin());
			return "log_admin_form";
		}
	}
	
	@RequestMapping(value = "/welcome_admin.htm", method = RequestMethod.GET)
	public String  welcomeAdmin(Admin admin, ModelMap map,HttpSession session) {
		
			return "welcome_admin";
	}
	
	@RequestMapping(value = "/prep_admin_profile.htm", method = RequestMethod.GET)
	public String prepAdminProfile(ModelMap map , HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin_s");
		Admin adminprofile = (Admin)Adminservice.getAdmin(a);
		System.out.println("adminprofile ="+adminprofile);
		//System.out.println("Sesionadmin= "+a);
		map.put("admin", adminprofile);
		return "adminProfile";
	}
	@RequestMapping(value = "/prep_user_logs.htm", method = RequestMethod.GET)
	public String prepUserLogs(ModelMap map , HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin_s");
		Admin adminprofile = (Admin)Adminservice.getAdmin(a);
		System.out.println("adminprofile ="+adminprofile);
		//System.out.println("Sesionadmin= "+a);
		map.put("admin", adminprofile);
		return "userLog";
	}
	
	@RequestMapping(value = "/indexAdmin.htm", method = RequestMethod.GET)
	public String LogOutUser(ModelMap map , HttpSession session) {
		Admin a = (Admin) session.getAttribute("admin_s");
		if(a!=null) {
			session.invalidate();
			session.removeAttribute("admin_s");
			return "home";
		}
		
		return "";
	}
	
}
