package com.patholab.dto;

import org.springframework.beans.BeanUtils;

import com.patholab.entity.Test;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class TestResponseDTO extends Test {

	private String employeeName;
	private int empId;

	
	
	public static TestResponseDTO fromEntity(Test entity) {
		TestResponseDTO dto = new TestResponseDTO();
		dto.setEmpId(entity.getEmp().getId());
		dto.setEmployeeName(entity.getEmp().getName());
		BeanUtils.copyProperties(entity, dto);
		
		return dto;
	}
}
