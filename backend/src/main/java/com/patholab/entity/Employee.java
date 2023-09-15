package com.patholab.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String city;
	private String userid;
	private String pwd;
	private String phone;
	private LocalDateTime createdOn;
	private String certificate;
	private boolean isactive;
		
	public Employee() {
		// TODO Auto-generated constructor stub
		this.createdOn=LocalDateTime.now();
	}
	


}