package com.patholab.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patholab.entity.Admin;
import com.patholab.repository.AdminRepository;

@Service

public class AdminServiceImpl implements AdminService {
	
	@Autowired 
	AdminRepository adminRepo;

	@Override
	public Admin validate(String userid, String pwd) {
		// TODO Auto-generated method stub
		Optional<Admin> admin=adminRepo.findById(userid);
		if(admin.isPresent() && admin.get().getPwd().equals(pwd)) {
			return admin.get();
		}
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		if(admin.getPwd().equals("") || admin.getPwd()==null) {
			admin.setPwd(adminRepo.getById(admin.getUserid()).getPwd());
		}
		adminRepo.save(admin);		
	}

	@Override
	public long count() {
		return adminRepo.count();
	}

	@Override
	public void createAdmin() {
		Admin admin=new Admin();
		admin.setUserid("admin");
		admin.setPwd("admin");
		admin.setUname("Administrator");
		adminRepo.save(admin);
	}

}
