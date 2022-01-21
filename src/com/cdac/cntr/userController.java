package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Admin;
import com.cdac.dto.Courses;
import com.cdac.dto.User;
import com.cdac.serv.contentServ;
import com.cdac.serv.courseService;
import com.cdac.serv.userService;

@Controller
public class userController {
	@Autowired
	private userService Userservice;
	@Autowired
	private contentServ contentserv;
	@Autowired
	private courseService courseServ;
	@Autowired
	private MailSender mailSender;
	
	@RequestMapping(value = "/prep_reg_user_form.htm", method = RequestMethod.GET)
	public String prepRegUserForm(ModelMap map) {
		map.put("user", new User());
		return "reg_user_form";
	}
	
	@RequestMapping(value = "/reg_user_form.htm", method = RequestMethod.POST)
	public String  regUserForm(User user,HttpServletRequest request, ModelMap map) {
		boolean check = Userservice.validateUser(user);
		System.out.println("Check="+check);
		if(check) {
			request.setAttribute("userPresent", "You Have Already Registered Please Log In.");
			return "log_user_form";
		}else {
			Userservice.regUser(user);
			return "log_user_form";
		}
		
	}
	

	@RequestMapping(value = "/prep_log_user_form.htm", method = RequestMethod.GET)
	public String preplogUserForm(ModelMap map) {
		map.put("user", new User());
		return "log_user_form";
	}
	
	@RequestMapping(value = "/log_user_form.htm", method = RequestMethod.POST)
	public String  logUserForm(User user, ModelMap map,HttpSession session) {
		boolean check = Userservice.validateUser(user);
		User u1 = Userservice.getUser(user);
		System.out.println(u1);
		if(check) {
			map.put("user", u1);
			session.setAttribute("user_s", u1);
			List<Courses> li =  courseServ.showAllCourses();
			map.put("courseList", li);
		return "loginSuccess";
		}
		else {
			map.put("user", new User());
			return "log_user_form";
		}
	}
	
	@RequestMapping(value = "/prep_user_profile.htm", method = RequestMethod.GET)
	public String prepuserProfile(ModelMap map , HttpSession session) {
		User u = (User) session.getAttribute("user_s");
		User u1 = Userservice.getUser(u);
		
		
		map.put("user", u1);
		return "userProfile";
	}
	
	
	@RequestMapping(value = "/prep_update_profile.htm", method = RequestMethod.GET)
	public String prepUpdateProfile(ModelMap map , HttpSession session) {
		User u = (User) session.getAttribute("user_s");
		User u1 = Userservice.getUser(u);
		
		
		map.put("user", u1);
		return "UpdateUserProfile";
	}
	
	@RequestMapping(value = "/update_profile.htm", method = RequestMethod.GET)
	public String updateProfile(User u,ModelMap map , HttpSession session) {
			List<User> uList = Userservice.getUsers();
			for(User user : uList) {
				if(user.getUserMail()==u.getUserMail() &&  user.getUserPass() == u.getUserPass()) {
					map.put("user", u);
					return "UpdateUserProfile";
				}
			}
		 Userservice.modifyUser(u);
		map.put("user", u);
		return "userProfile";
	}
	
	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String LogOutUser(ModelMap map , HttpSession session) {
		User u = (User) session.getAttribute("user_s");
		Admin a = (Admin) session.getAttribute("admin_s");
		if(u!=null) {
			
			session.removeAttribute("user_s");
			return "index";
		}else if(a!=null){
			
			session.removeAttribute("admin_s");
			return "index";
		}
		return null;
	}
	
	@RequestMapping(value = "/forgot_password.htm",method = RequestMethod.POST)
    public String forgotPassword(@RequestParam String userMail,ModelMap map) {      
        String pass = Userservice.ResetPassword(userMail);
        String msg = "you are not registered";
        if(pass!=null) {    
            
            SimpleMailMessage message = new SimpleMailMessage();  
            message.setFrom("pratikt9999@gmail.com");  
            message.setTo(userMail);  
            message.setSubject("Your password");  
            message.setText(pass);  
            //sending message   
            mailSender.send(message);
            msg = "check the mail for password";
        }
        map.put("msg", msg);
        return "info";
    }
	
	
	
}

