package com.patholab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.patholab.dto.UpdateStatusDTO;
import com.patholab.entity.Employee;
import com.patholab.repository.EmployeeRepository;
import com.patholab.utils.StorageService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired private EmployeeRepository empRepo;
	@Autowired private StorageService storage;
	@Override
	public void registerEmp(Employee emp,MultipartFile photo) {
		// TODO Auto-generated method stub
		String filename=storage.store(photo);
		emp.setCertificate(filename);		
		empRepo.save(emp);
	}

	@Override
	public List<Employee> allEmps() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return empRepo.getById(id);
	}

	@Override
	public Employee validate(String userid, String pwd) {
		Employee seller=empRepo.findByUserid(userid);
		if(seller!=null && seller.getPwd().equals(pwd)) {
			return seller;
		}
		return null;
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		Employee seller=empRepo.getById(id);
		empRepo.delete(seller);
	}

	@Override
	public void updateStatus(UpdateStatusDTO dto) {
		// TODO Auto-generated method stub
		Employee emp=findById(dto.getEmpid());
		emp.setIsactive(dto.getStatus());
		empRepo.save(emp);
	}

}
