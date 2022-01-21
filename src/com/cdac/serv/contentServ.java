package com.cdac.serv;

import java.util.List;

import com.cdac.dto.courseContent;

public interface contentServ {

	 void addContent(courseContent courseCnt);
	 void removeContent(int courseId);
	 List<courseContent> getContentList(int courseId);
	 void modifyContent(courseContent coursecontent);
	 courseContent getContent(int contentId);
}
