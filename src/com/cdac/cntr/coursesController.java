package com.cdac.cntr;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.view.RedirectView;

import com.cdac.dto.Courses;
import com.cdac.dto.courseContent;
import com.cdac.serv.contentServ;
import com.cdac.serv.courseService;

@Controller
public class coursesController {
	@Autowired
	private courseService courseServ;
	@Autowired
	private contentServ contentserv;
	
	
	@RequestMapping(value = "/prep_add_course_form.htm", method = RequestMethod.GET)
	public String prepRegUserForm(ModelMap map) {
		map.put("course", new Courses());
		return "course_add_form";
	}
	
	@RequestMapping(value = "/course_add_form.htm", method = RequestMethod.POST)
	public RedirectView addCourse(Courses course, ModelMap map,HttpSession s,HttpServletRequest request) {
		courseServ.addCourse(course);
		map.put("course", course);
		map.put("courseContent", new courseContent() );
		s.setAttribute("cntr", course);
		String contextPath = request.getContextPath();
		return new RedirectView (contextPath + "/addCourseContent");
		//return "redirect:/addCourseContent";
	}
	@RequestMapping(value = "/addCourseContent.htm", method = RequestMethod.POST)
	public String  addContent(Courses course,courseContent courseCnt, ModelMap map , HttpSession s) {
		courseCnt.setCourseId(((Courses)s.getAttribute("cntr")).getCourseId());
		System.out.println("done");
		contentserv.addContent(courseCnt);
		map.put("course", course);
		map.put("courseContent", new courseContent() );
		return "addCourseContent";
	}
//	@RequestMapping(value = "/prep_show_courses.htm", method = RequestMethod.GET)
//	public String preShowCourses( ModelMap map) {
//		return "showCourses";
//	}
	@RequestMapping(value = "/show_courses.htm", method = RequestMethod.GET)
	public String showCourses( ModelMap map) {
		List<Courses> li =  courseServ.showAllCourses();
		map.put("courseList", li);
		return "showCourses";
	}
	
	
	@RequestMapping(value = "/delete_course.htm", method = RequestMethod.GET)
	public String RemoveCourses( ModelMap map,@RequestParam int cid) {
		courseServ.removeCourse(cid);
		contentserv.removeContent(cid);
	//		System.out.println(cid);
		List<Courses> li =  courseServ.showAllCourses();
		map.put("courseList", li);
		return "showCourses";
	}
	
	
	
	
	@RequestMapping(value = "/pre_update_course_details.htm", method = RequestMethod.GET)
	public String preUpdateCourses( ModelMap map,@RequestParam int cid) {
		Courses c =  courseServ.getByCourseId(cid);
		System.out.println("predetailscid ="+cid);
		c.setCourseId(cid);
		map.put("course", c);
		System.out.println("course"+c);
		List<courseContent> cnt = (List<courseContent>)contentserv.getContentList(cid);
		map.put("cntList", cnt);

		return "updateCourseDetails";
	}
	
	
	@RequestMapping(value = "/update_course_details.htm", method = RequestMethod.POST)
	public String UpdateCourses(Courses c, ModelMap map,HttpSession session) { 
		Courses crs = (Courses) session.getAttribute("course");
		int cid = crs.getCourseId();
		System.out.println("cid= "+c);
		c.setCourseId(cid);
		System.out.println("courseId= "+c.getCourseId());
		 courseServ.modifyCourse(c);
		
		 Courses c1 =  courseServ.getByCourseId(crs.getCourseId());
		 //session.setAttribute("course", c1);
		 List<courseContent> cntList =(List<courseContent>) contentserv.getContentList(crs.getCourseId());
			/*
			 * System.out.println("course= "+c1); System.out.println("done");
			 */
			map.put("course", c1);
			System.err.println(c1);
			
			
			 List<courseContent> list = contentserv.getContentList(cid);
			 map.put("cntList", list);
			 map.put("courseList", new courseContent());
			 
		return "lecUpdate";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/pre_update_content.htm", method = RequestMethod.GET)
	public String prepUpdateContent(HttpSession session,HttpServletRequest request, ModelMap map,@RequestParam int cid,@RequestParam int cnid) { 
		//System.out.println("cid= "+cid+"  cnid"+cnid); 
		session.setAttribute("cntid", cnid);
		
		courseContent cnt = contentserv.getContent(cnid);
		 Courses crs = courseServ.getByCourseId(cid);
		 request.setAttribute("cnt1", cnt);
		// System.out.println("cnt="+cnt);
		 map.put("cnt", cnt);
		 map.put("course", crs );
		return "updateContent";
	}
	
	@RequestMapping(value = "/update_content.htm", method = RequestMethod.POST)
	public String updateContent(courseContent c, HttpServletRequest request ,ModelMap map,HttpSession session) { 
		int cid=(int) session.getAttribute("cid");
		int cntid = (int)session.getAttribute("cntid");
		System.out.println("140= "+cid+"  cntid= "+cntid);
		Courses crs = courseServ.getByCourseId(cid) ;
		 System.out.println("Checking ="+c);
		//c.setCourseId(cid);
		c.setContentId(cntid);
		 System.out.println("courseId= "+c.getCourseId());
		c.setCourseId(cid);
		
		 contentserv.modifyContent(c);
		// List<courseContent> cntList =(List<courseContent>) contentserv.getContentList(crs.getCourseId());
			map.put("course", crs);
			//System.err.println(crs);
			List<courseContent> list = contentserv.getContentList(cid);
			 map.put("cntList",list);		 
		return "lecUpdate";
	}
	
	
	
	
	
}







