package com.cdac.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ContentDao;
import com.cdac.dto.courseContent;

@Service
public class contentServImple implements contentServ{

	@Autowired
	private ContentDao contentdao;
	@Override
	public void addContent(courseContent courseCnt) {
		contentdao.insertContent(courseCnt);
		
	}
	@Override
	public void removeContent(int courseId) {
		contentdao.deleteContent(courseId);
	}
	@Override
	public List<courseContent> getContentList(int courseId) {
		
		return contentdao.selectContentList(courseId);
	}
	@Override
	public void modifyContent(courseContent coursecontent) {
		contentdao.updateContent(coursecontent);
		
	}
	@Override
	public courseContent getContent(int contentId) {
		
		return contentdao.selectContent(contentId);
	}
	
}
