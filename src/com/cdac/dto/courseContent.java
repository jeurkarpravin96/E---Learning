package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class courseContent {
	@Id
	@GeneratedValue
	private int contentId;
	private int courseId;
	private int lectureNo;
	private String lectureName;
	private String url;
	@Column(columnDefinition = "mediumtext")
	private String lecDesc;
	public courseContent() {
		
	}
	
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public courseContent(int courseId2) {
		this.courseId=courseId2;
	}

	public String getLecDesc() {
		return lecDesc;
	}

	public void setLecDesc(String lecDesc) {
		this.lecDesc = lecDesc;
	}

	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getLectureNo() {
		return lectureNo;
	}
	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "courseContent [contentId=" + contentId + ", courseId=" + courseId + ", lectureNo=" + lectureNo
				+ lectureName+ ", url=" + url + ", lecDesc=" + lecDesc + "]";
	}
	
}
