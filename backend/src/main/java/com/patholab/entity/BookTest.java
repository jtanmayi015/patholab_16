package com.patholab.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="book_test")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookTestId;
	private Date bookTestDate;
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="addressId")
	private Address address;
	@ManyToOne
	@JoinColumn(name="paymentId")
	private Payment payment;

	
	
}
