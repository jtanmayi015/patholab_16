package com.patholab.service;

import java.util.List;

import com.patholab.entity.BookTest;
import com.patholab.entity.BookingDetails;

public interface BookingDetailsService {

	void saveBookingDetails(BookingDetails bd);
	BookingDetails findById(int id);
	List<BookingDetails> findByBookTest(BookTest bookTest);
}
