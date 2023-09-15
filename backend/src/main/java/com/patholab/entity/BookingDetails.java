package com.patholab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="test_id")
	private Test test;
	private int qty;
	@ManyToOne
	@JoinColumn(name="bookTestId")
	private BookTest booktest;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public BookTest getBookTest() {
		return booktest;
	}
	public void setBookTest(BookTest booktest) {
		this.booktest = booktest;
	}
	
	
}
