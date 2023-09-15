package com.patholab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patholab.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	Patient findByUserid(String userid);
}
