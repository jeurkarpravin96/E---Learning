package com.cdac.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Admin {
	@Id
	@GeneratedValue
	private int adminId;
	private String adminName;
	private String adminUserName;
	private Long adminMobileNo;
	private String adminMail;
	private String adminPass;
	@OneToMany
	@JoinColumn( name ="adminId" )
	List<User> user;
	
	public Admin() {
		
	}
	
	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public Long getAdminMobileNo() {
		return adminMobileNo;
	}

	public void setAdminMobileNo(Long adminMobileNo) {
		this.adminMobileNo = adminMobileNo;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminMail() {
		return adminMail;
	}
	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminMail=" + adminMail + ", adminPass="
				+ adminPass + ", user=" + user + "]";
	}
	
	
}
