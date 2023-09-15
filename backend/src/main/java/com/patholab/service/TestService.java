package com.patholab.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.patholab.entity.Test;

public interface TestService {
	void addTest(Test p,MultipartFile pic);
	List<Test> findTests(int empId);
	void updateTest(Test t);
	void deleteTest(int testid);
	List<Test> allTests();
	List<Test> categoryTests(int tcat);
	Test findTestById(int testid);
	Page<Test> allTestsPaginated(int page,int pagesize);
}
