package com.cdac.dao;

import com.cdac.dto.Admin;

public interface adminDao {

	boolean checkAdmin(Admin admin);

	Admin getAdmin(Admin admin);
}
