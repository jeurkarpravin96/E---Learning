package com.cdac.serv;

import com.cdac.dto.Admin;

public interface adminService {
	boolean validateAdmin(Admin admin); 
	Admin getAdmin(Admin admin);
}
