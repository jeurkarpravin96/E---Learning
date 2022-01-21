package com.cdac.dao;

import java.util.List;

import com.cdac.dto.courseContent;

public interface ContentDao {

	void insertContent(courseContent courseCnt);

	void deleteContent(int courseId);

	List<courseContent> selectContentList(int courseId);

	void updateContent(courseContent coursecontent);

	courseContent selectContent(int contentId);
}
