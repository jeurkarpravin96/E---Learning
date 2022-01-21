package com.cdac.cntr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Courses;
import com.cdac.dto.User;
import com.cdac.dto.courseContent;
import com.cdac.serv.contentServ;
import com.cdac.serv.courseService;
import com.cdac.serv.userCourseServ;
import com.cdac.serv.userService;

@Controller
public class userServiceController {
	
	@Autowired
	private userService Userservice;
	@Autowired
	private courseService courseServ;
	@Autowired
	private contentServ contentserv;
	@Autowired
	private userCourseServ userC;
	
	@RequestMapping(value = "/show_user_courses.htm", method = RequestMethod.GET)
	public String showCourses( ModelMap map,User user,HttpSession session) {
		List<Courses> li =  courseServ.showAllCourses();
		map.put("courseList", li);
		User u = (User) session.getAttribute("user_s");
		map.put("u", u);
		return "welcome_user";
	}
	
	
	@RequestMapping(value = "/go_to_course.htm", method = RequestMethod.GET)
	public String gotoCourses( ModelMap map,User user,HttpServletRequest request,HttpSession session,@RequestParam int cid) {
		User u = (User) session.getAttribute("user_s");
		System.out.println(user);
		List<courseContent> temp =  (List<courseContent>) contentserv.getContentList(cid);
		System.out.println(temp);
		request.setAttribute("cnid", temp.get(0).getContentId());
		System.out.println(temp.get(0).getContentId());
		
		map.put("cntList", temp);
		map.put("u", u);
		Courses c = courseServ.getByCourseId(cid);
		map.put("course",c);
		
		
		return "goToCourse";
	}
	
	@RequestMapping(value="/pre-explore_course.htm", method=RequestMethod.GET)
	public String exploreCourses( ModelMap map,User user,HttpSession session,@RequestParam int cid) {
		List<courseContent> li =  contentserv.getContentList(cid);
		map.put("cntList", li);
		User u = (User) session.getAttribute("user_s");
		map.put("u", u);
		Courses c = courseServ.getByCourseId(cid);
		map.put("course",c);
		return "exploreCourse";
	}
	@RequestMapping(value="/pre-enroll_course.htm", method=RequestMethod.GET)
	public String preEnrollCourse( ModelMap map,HttpSession session,@RequestParam int cid) {
		User u = (User) session.getAttribute("user_s");	
//		map.put("u", u);
		System.out.println(cid);
		System.out.println(u);
		
		Courses c = courseServ.getByCourseId(cid);
		System.out.println(c);
		u.setCourse(c);
		c.setUser(u);
		
		
		Userservice.modifyUser(u);
		courseServ.modifyCourse(c);
		
		List<courseContent> li =  contentserv.getContentList(cid);
		map.put("cntList", li);
		map.put("u", u);
		map.put("course",c);
		return "exploreCourse";
	}
	
	
	@RequestMapping(value="/pre_go_to_course.htm", method=RequestMethod.GET)
	public String preGoToCourse( ModelMap map,User user,HttpSession session,@RequestParam int cid,@RequestParam int cnid,HttpServletRequest request) {
		List<courseContent> li =  contentserv.getContentList(cid);
		map.put("cntList", li);
		User u = (User) session.getAttribute("user_s");
		request.setAttribute("cnid", cnid);
		map.put("u", u);
		Courses c = courseServ.getByCourseId(cid);
		map.put("course",c);
		return "goToCourse";
	}
	
	@RequestMapping(value="/go_to_course.htm", method=RequestMethod.GET)
	public String goToCourse( ModelMap map,User user,HttpSession session,@RequestParam int cid,@RequestParam int cnid,HttpServletRequest request) {
		List<courseContent> li =  contentserv.getContentList(cid);
		map.put("cntList", li);
		User u = (User) session.getAttribute("user_s");
		request.setAttribute("cnid", cnid);
		map.put("u", u);
		Courses c = courseServ.getByCourseId(cid);
		map.put("course",c);
		return "goToCourse";
	}
}
