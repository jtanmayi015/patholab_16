package com.patholab.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.patholab.dto.UpdateStatusDTO;
import com.patholab.entity.Employee;

public interface EmployeeService {
	void registerEmp(Employee emp,MultipartFile photo);
	List<Employee> allEmps();
	Employee findById(int id);
	Employee validate(String userid,String pwd);
	void deleteEmp(int id);
	void updateStatus(UpdateStatusDTO dto);
}
