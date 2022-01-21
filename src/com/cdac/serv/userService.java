package com.cdac.serv;

import java.util.List;

import com.cdac.dto.User;

public interface userService {
	void regUser(User user);
	boolean validateUser(User user); 
	User getUser(User user);
	void modifyUser(User user);
	String ResetPassword(String userName);
	List<User> getUsers();
}
