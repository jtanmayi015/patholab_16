package com.patholab.service;

import java.util.List;

import com.patholab.entity.Patient;

public interface PatientService {
	void registerPatient(Patient cust);
	List<Patient> allPatients();
	Patient findById(int id);
	Patient validate(String userid,String pwd);
	boolean verifyUserId(String userid);
	void updateProfile(Patient cust);
}
