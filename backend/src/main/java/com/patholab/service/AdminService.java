package com.patholab.service;

import com.patholab.entity.Admin;

public interface AdminService {
	Admin validate(String userid,String pwd);
	void updateAdmin(Admin amin);
	long count();
	void createAdmin();
}
