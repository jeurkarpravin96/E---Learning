package com.cdac.serv;

import java.util.List;

import com.cdac.dto.Courses;
import com.cdac.dto.User;

public interface userCourseServ {
	void insertData(Courses c, User u);
	List<Courses> SelectCourses(Courses c, User u);
}
