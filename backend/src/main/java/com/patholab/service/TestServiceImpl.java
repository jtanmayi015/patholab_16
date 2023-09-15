package com.patholab.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.patholab.entity.Test;
import com.patholab.repository.TestRepository;
import com.patholab.utils.StorageService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired private TestRepository testRepo;
	@Autowired private StorageService storageService;
	@Autowired private EmployeeService empService;
	
	@Override
	public void addTest(Test p,MultipartFile pic) {
		// TODO Auto-generated method stub
		String photo=storageService.store(pic);
		p.setPhoto(photo);
	
		testRepo.save(p);
	}

	@Override
	public List<Test> findTests(int empId) {
		// TODO Auto-generated method stub
		return testRepo.findByEmpId(empId,Sort.by(Sort.Direction.DESC,"testid"));
	}

	@Override
	public void updateTest(Test p) {
		Test pp=testRepo.getById(p.getTestid());
		p.setEmp(pp.getEmp());
		testRepo.save(p);
	}

	@Override
	public void deleteTest(int prodid) {
		// TODO Auto-generated method stub
		Test p=testRepo.getById(prodid);
		testRepo.delete(p);
	}

	@Override
	public List<Test> allTests() {
		// TODO Auto-generated method stub
		return testRepo.findAll(Sort.by(Sort.Direction.DESC,"testid"));
	}

	@Override
	public Test findTestById(int testid) {
		// TODO Auto-generated method stub
		return testRepo.getById(testid);
	}

	@Override
	public List<Test> categoryTests(int pcat) {
		// TODO Auto-generated method stub
		return testRepo.findByCategoryId(pcat,Sort.by(Sort.Direction.DESC,"testid"));
	}
	
	@Override
	public Page<Test> allTestsPaginated(int page,int pagesize) {
		Page<Test> test=testRepo.findAll(PageRequest.of(page, pagesize,Sort.by(Direction.DESC, "testid")));
		System.err.println(test.getSize());
		return test;
	}
}
