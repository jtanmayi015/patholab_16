package com.patholab.dto;

import java.util.List;

import lombok.ToString;
@ToString
public class TestPagedResponseDTO {
	private List<TestResponseDTO> tlist;
	private int current;
	private long total;
	private int pagesize;
	public List<TestResponseDTO> getTlist() {
		return tlist;
	}
	public void setTlist(List<TestResponseDTO> tlist) {
		this.tlist = tlist;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
	
	
}
