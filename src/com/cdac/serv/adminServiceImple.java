package com.cdac.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.adminDao;
import com.cdac.dto.Admin;

@Service
public class adminServiceImple implements adminService{

	@Autowired
	private adminDao Admindao;
	@Override
	public boolean validateAdmin(Admin admin) {
		return Admindao.checkAdmin(admin);
	}
	@Override
	public Admin getAdmin(Admin admin) {
		
		return Admindao.getAdmin(admin);
	}

}
