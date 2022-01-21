package com.cdac.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class Courses {
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	private String courseInstructor;
	private String couseHour;
	private String courseUpdatedate;
	private String CourseLanguage;
	@Column(columnDefinition = "longtext")
	private String courseDesc;
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="userId_courseId",joinColumns = {@JoinColumn(name ="courseId")},inverseJoinColumns = {@JoinColumn(name="userId")})
	private Set<User> user =  new HashSet<User>();
	
	public Courses() {
		
	}
	public void setUser(User users) {
		this.user.add(users); 
	}
	public Courses(int courseId2) {
		this.courseId=courseId2;
	}

	public String getCourseLanguage() {
		return CourseLanguage;
	}

	public void setCourseLanguage(String courseLanguage) {
		CourseLanguage = courseLanguage;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public String getCourseUpdatedate() {
		return courseUpdatedate;
	}

	public void setCourseUpdatedate(String courseUpdatedate) {
		this.courseUpdatedate = courseUpdatedate;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCouseHour() {
		return couseHour;
	}
	public void setCouseHour(String couseHour) {
		this.couseHour = couseHour;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return courseId + " " + courseName + " " + courseInstructor
				+ " " + couseHour + " " + courseUpdatedate + " "+ courseDesc;
	}
	 
	 
}
