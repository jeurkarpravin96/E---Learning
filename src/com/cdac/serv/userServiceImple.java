package com.cdac.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.userDao;
import com.cdac.dto.User;

@Service
public class userServiceImple implements userService {
	@Autowired
	private userDao userdao;
			
	@Override
	public void regUser(User user) {
		 userdao.insertUser(user);
	}

	@Override
	public boolean validateUser(User user) {
		return userdao.checkUser(user);
	}
	public User getUser(User user) {
		return userdao.selectUser(user);
	}

	@Override
	public void modifyUser(User user) {
		userdao.updateUser(user);
		
	}
	@Override
	public String ResetPassword(String userMail) {
		return userdao.forgotPassword(userMail);
	}
	@Override
	
	public List<User> getUsers(){
		return userdao.selectUsers();
	}
}
