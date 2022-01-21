package com.cdac.serv;

import java.util.List;

import com.cdac.dto.Courses;

public interface courseService {
	
	void addCourse(Courses course);
	void removeCourse(int courseId);
	void modifyCourse(Courses course);
	List<Courses> showAllCourses();
	List<Courses> getByUserId(int userId);
	Courses getByCourseId(int courseId);
	List<Courses> findCourse(String courseName);
	
}
