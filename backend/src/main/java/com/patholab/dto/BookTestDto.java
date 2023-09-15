package com.patholab.dto;

import java.util.List;

import com.patholab.entity.Address;
import com.patholab.entity.Payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class BookTestDto {

	private Address address;
	private List<CartDTO> cart;
	private Payment payment;
	private int patientId;
	
	
	
	
}
