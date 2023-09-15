package com.patholab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patholab.dto.LoginDTO;
import com.patholab.dto.Response;
import com.patholab.entity.Patient;
import com.patholab.service.PatientService;

@CrossOrigin
@RestController
@RequestMapping("/api/patients")
public class PatientController {
	
	@Autowired PatientService patientService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Patient patient) {	
		if(patientService.verifyUserId(patient.getUserid())) {
			return Response.error("Email already registered");
		}
		patientService.registerPatient(patient);
		return Response.success(patient);
	}
	
	@GetMapping
	public List<Patient> findAllPatients() {
		List<Patient> result = patientService.allPatients();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findPatientById(@PathVariable("id") int id) {
		Patient result = patientService.findById(id);
		return Response.success(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Patient user=patientService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null)
			return Response.success(user);
		else
			return Response.status(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProfile(@RequestBody Patient patient,@PathVariable("id") int id) {
		patientService.updateProfile(patient);
		return Response.status(HttpStatus.OK);
	}

}
