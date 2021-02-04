package com.kiru.rest.assignment.dto;

public class TransactionQueryDTO {
	
	private String accountNumber;
	
	private String type;
	
	private String window;
	
	private String startDate;
	
	private String endDate;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
