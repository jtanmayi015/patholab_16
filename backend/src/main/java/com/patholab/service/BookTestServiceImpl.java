package com.patholab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patholab.entity.Patient;
import com.patholab.entity.BookTest;
import com.patholab.repository.BookTestRepository;

@Service
public class BookTestServiceImpl implements BookTestService {

	@Autowired BookTestRepository dao;
	
	@Override
	public BookTest saveBookTest(BookTest bookTest) {
		// TODO Auto-generated method stub
		return dao.save(bookTest);
	}

	@Override
	public List<BookTest> getAllBookingTests() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<BookTest> getPatientTests(Patient patient) {
		// TODO Auto-generated method stub
		return dao.findByPatient(patient);
	}

	@Override
	public BookTest findById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	
}
