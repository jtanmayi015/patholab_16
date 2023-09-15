package com.patholab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patholab.entity.TestCategory;
import com.patholab.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired private CategoryRepository repo;
	
	public void save(TestCategory cat) {
		repo.save(cat);
	}
	
	public List<TestCategory> listAll(){
		return repo.findAll();
	}
	
	public TestCategory findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteCategory(int id) {
		TestCategory cat=findById(id);
		cat.setIsactive(false);
		repo.save(cat);
	}

	@Override
	public void updateStatus(int id, boolean status) {
		TestCategory cat=findById(id);
		cat.setIsactive(status);
		repo.save(cat);		
	}
}
