package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Courses;

public interface courseDao {

	void insertCourse(Courses course);
	void deleteCourse(int courseId);
	void updateCourse(Courses course);
	List<Courses> selectAllCourses();
	List<Courses> selectByUserId(int userId);
	Courses selectByCourseId(int courseId);
	List<Courses> searchCourse(String courseName);
	
	
}
               