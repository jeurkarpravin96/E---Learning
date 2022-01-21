package com.cdac.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.userCourseDao;
import com.cdac.dto.Courses;
import com.cdac.dto.User;
@Service
public class userCourseServImple implements userCourseServ{
	@Autowired
	private userCourseDao usercourseD;
	@Override
	public void insertData(Courses c, User u) {
		usercourseD.insertData(c, u);
	}

	@Override
	public List<Courses> SelectCourses(Courses c, User u) {
		// TODO Auto-generated method stub
		return null;
	}

}
