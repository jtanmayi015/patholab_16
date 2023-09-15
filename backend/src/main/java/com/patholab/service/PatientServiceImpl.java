package com.patholab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patholab.entity.Patient;
import com.patholab.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired private PatientRepository dao;

	@Override
	public void registerPatient(Patient cust) {
		dao.save(cust);
	}

	@Override
	public List<Patient> allPatients() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Patient findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public Patient validate(String userid, String pwd) {
		Patient cc=dao.findByUserid(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	@Override
	public boolean verifyUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.findByUserid(userid)!=null;
	}

	@Override
	public void updateProfile(Patient cust) {
		// TODO Auto-generated method stub
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(findById(cust.getId()).getPwd());
		}
		dao.save(cust);	
	}
	
}
