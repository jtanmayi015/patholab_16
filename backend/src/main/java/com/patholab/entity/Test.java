package com.patholab.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString

public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testid;
	private String tname;
	private String descr;
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private TestCategory category;
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee emp;
	private int price;
	private String photo;
	private int qty;
	private LocalDateTime createdOn;
	
	public Test() {
		this.createdOn=LocalDateTime.now();
	}
	
	public Test(int testid) {
		this.testid=testid;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public TestCategory getCategory() {
		return category;
	}
	public void setCategory(TestCategory category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
}
