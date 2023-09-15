package com.patholab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.patholab.dto.LoginDTO;
import com.patholab.dto.Response;
import com.patholab.dto.UpdateStatusDTO;
import com.patholab.entity.Employee;
import com.patholab.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

	@Autowired private EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<?> save(Employee emp,MultipartFile photo) {		
		empService.registerEmp(emp,photo);
		return Response.success(emp);
	}
	
	@PostMapping("status")
	public ResponseEntity<?> updateStatus(@RequestBody UpdateStatusDTO dto) {
		empService.updateStatus(dto);
		return Response.success("Status updated successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAllPatients() {
		List<Employee> result = empService.allEmps();
		return Response.success(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findEmployeeProfile(@PathVariable("id") int id) {
		Employee result = empService.findById(id);
		return Response.success(result);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmp(id);
		return Response.status(HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Employee user=empService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null && !user.isIsactive())
			return Response.error("Employee not verified");
		else if(user!=null && user.isIsactive())
			return Response.success(user);
		else
			return Response.error("Invalid username or password");
	}
	
}
