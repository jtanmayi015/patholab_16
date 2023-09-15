package com.patholab.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patholab.dto.BookTestDto;
import com.patholab.dto.BookTestResponseDTO;
import com.patholab.dto.CartDTO;
import com.patholab.dto.Response;
import com.patholab.dto.TestDetailsDTO;
import com.patholab.entity.Address;
import com.patholab.entity.BookTest;
import com.patholab.entity.BookingDetails;
import com.patholab.entity.Patient;
import com.patholab.entity.Payment;
import com.patholab.entity.Test;
import com.patholab.service.AddressService;
import com.patholab.service.BookTestService;
import com.patholab.service.BookingDetailsService;
import com.patholab.service.PatientService;
import com.patholab.service.PaymentService;
import com.patholab.service.TestService;

@CrossOrigin
@RestController
@RequestMapping("/api/bookTest")
public class BookTestController {

	@Autowired BookTestService bookTestService;
	@Autowired PatientService patientService;
	@Autowired AddressService addressService;
	@Autowired PaymentService paymentService;
	@Autowired BookingDetailsService bookingDetailsService;	
	@Autowired TestService tservice;	
	
	@PostMapping
	public ResponseEntity<?> saveBookTest(@RequestBody BookTestDto dto) {	
		Address address=addressService.saveAddress(dto.getAddress());
		dto.getPayment().setPaymentdate(new Date());
		Payment payment=paymentService.savePayment(dto.getPayment());
		BookTest bookTest=new BookTest();
		bookTest.setBookTestDate(new Date());
		bookTest.setAddress(address);
		bookTest.setPayment(payment);
		Patient patient=patientService.findById(dto.getPatientId());
		bookTest.setPatient(patient);
		BookTest bookTests=bookTestService.saveBookTest(bookTest);
		
		for(CartDTO cart : dto.getCart()) {
			BookingDetails bd=new BookingDetails();
			bd.setBookTest(bookTests);
			bd.setQty(cart.getQty());
			Test test=tservice.findTestById(cart.getTestid());
			bd.setTest(test);			
			bookingDetailsService.saveBookingDetails(bd);
			test.setQty(test.getQty()-cart.getQty());
			tservice.updateTest(test);
		}
		
		return Response.status(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllBookingTests(Optional<Integer> patientid) {
		List<BookTest> result=null;
		if(patientid.isPresent()) {
			Patient patient=patientService.findById(patientid.get());
			 result= bookTestService.getPatientTests(patient);
		}else {
			result = bookTestService.getAllBookingTests();
		}
		return Response.success(result);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findBookTestById(@PathVariable("id") int id) {
		BookTest bookTest = bookTestService.findById(id);
		List<BookingDetails> details=bookingDetailsService.findByBookTest(bookTest);
		List<TestDetailsDTO> detailsdto=new ArrayList<TestDetailsDTO>();
		details.forEach(bd -> {
			TestDetailsDTO dto=TestDetailsDTO.fromEntity(bd);
			detailsdto.add(dto);
		});
		BookTestResponseDTO result=new BookTestResponseDTO();
		result.setTest(bookTest);
		result.setDetails(detailsdto);
		return Response.success(result);
	}
}
