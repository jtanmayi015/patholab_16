package com.patholab.service;

import java.util.List;

import com.patholab.entity.Patient;
import com.patholab.entity.BookTest;

public interface BookTestService {

	BookTest saveBookTest(BookTest bookTest);
	List<BookTest> getAllBookingTests();
	List<BookTest> getPatientTests(Patient patient);
	BookTest findById(int id);
}
