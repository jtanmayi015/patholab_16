package com.patholab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patholab.entity.BookTest;
import com.patholab.entity.BookingDetails;
import com.patholab.repository.BookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired BookingDetailsRepository bookingDetailsRepo;
	@Override
	public void saveBookingDetails(BookingDetails bd) {
		// TODO Auto-generated method stub
		bookingDetailsRepo.save(bd);
	}

	@Override
	public BookingDetails findById(int id) {
		// TODO Auto-generated method stub
		return bookingDetailsRepo.getById(id);
	}

	@Override
	public List<BookingDetails> findByBookTest(BookTest bookTest) {
		// TODO Auto-generated method stub
		return bookingDetailsRepo.findByTest(bookTest);
	}

}
