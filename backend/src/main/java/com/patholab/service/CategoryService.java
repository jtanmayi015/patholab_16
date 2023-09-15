package com.patholab.service;

import java.util.List;

import com.patholab.entity.TestCategory;

public interface CategoryService {
	void save(TestCategory cat);
	List<TestCategory> listAll();
	TestCategory findById(int id);
	void deleteCategory(int id);
	void updateStatus(int id,boolean status);
}
