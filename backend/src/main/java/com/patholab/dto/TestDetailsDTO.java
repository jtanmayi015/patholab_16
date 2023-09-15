package com.patholab.dto;

import org.springframework.beans.BeanUtils;

import com.patholab.entity.BookingDetails;
import com.patholab.entity.Test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class TestDetailsDTO {
	
	private int id;
	private Test test;
	private int qty;


	public static TestDetailsDTO fromEntity(BookingDetails entity) {
		TestDetailsDTO dto = new TestDetailsDTO();
		BeanUtils.copyProperties(entity, dto);		
		return dto;
	}
}
