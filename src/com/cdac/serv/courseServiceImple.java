package com.cdac.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.courseDao;
import com.cdac.dao.courseDaoImple;
import com.cdac.dto.Courses;
@Service
public class courseServiceImple implements courseService {

	@Autowired
	private courseDao c;
	@Override
	public void addCourse(Courses course) {
		c.insertCourse(course);
		
	}

	@Override
	public void removeCourse(int courseId) {
		c.deleteCourse(courseId);
		
	}

	@Override
	public void modifyCourse(Courses course) {
		c.updateCourse(course);
	}

	@Override
	public List<Courses> showAllCourses() {
		return c.selectAllCourses();
	}

	@Override
	public List<Courses> getByUserId(int userId) {
		return c.selectByUserId(userId);
	}

	@Override
	public Courses getByCourseId(int courseId) {
		return c.selectByCourseId(courseId);
	}

	@Override
	public List<Courses> findCourse(String courseName) {
		return c.searchCourse(courseName);
	}
	
}
