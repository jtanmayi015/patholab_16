package com.patholab.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.patholab.dto.TestPagedResponseDTO;
import com.patholab.dto.TestResponseDTO;
import com.patholab.dto.Response;
import com.patholab.entity.Test;
import com.patholab.service.CategoryService;
import com.patholab.service.TestService;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired private TestService tservice;
	@Autowired CategoryService cservice;
	
	@PostMapping
	public ResponseEntity<?> saveProduct(Test test,MultipartFile pic) {
		tservice.addTest(test,pic);
		return Response.success("Test Saved successfully");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Test test,@PathVariable("id") int id) {
		test.setTestid(id);
		tservice.updateTest(test);
		return Response.success("Test updated successfully");		
	}
	
	@GetMapping("{id}")
	public Test findBook(@PathVariable("id")int id) {
		Test book=tservice.findTestById(id);
		return book;
	}
	
	@GetMapping
	public ResponseEntity<?> findAllTests(Optional<Integer> empid) {
		List<TestResponseDTO> result = new ArrayList<TestResponseDTO>();
		if(empid.isPresent()) {
			System.out.println(empid);
			for(Test t : tservice.findTests(empid.get())) {
				result.add(TestResponseDTO.fromEntity(t));
			}
			
		}else {
			for(Test t : tservice.allTests()) {
				result.add(TestResponseDTO.fromEntity(t));
			}
		}
		
		return Response.success(result);
	}
	
	@GetMapping("/available")
	public List<Test> findAvailableBooks() {
		return tservice.allTests();
	}
	
	@GetMapping("/paginated")
	public ResponseEntity<?> paginatedTests(int page,int pagesize) {
		List<TestResponseDTO> result = new ArrayList<TestResponseDTO>();
		Page<Test> data=tservice.allTestsPaginated(page, pagesize);
		data.forEach(item-> {
			result.add(TestResponseDTO.fromEntity(item));
		});
		TestPagedResponseDTO resp=new TestPagedResponseDTO();
		resp.setPagesize(pagesize);
		resp.setCurrent(page);
		resp.setTotal(data.getTotalElements());
		resp.setTlist(result);
		return Response.success(resp);
	}
	
	@GetMapping("cats/{id}")
	public List<Test> findByCategory(@PathVariable("id") int id) {
		List<Test> result = new ArrayList<Test>();
		for(Test b : tservice.categoryTests(id)) {
			result.add(b);
		}
		return result;
	}
		
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id) {
		tservice.deleteTest(id);
		return Response.status(HttpStatus.OK);
	}
}
