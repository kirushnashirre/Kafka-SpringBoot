package com.kiru.rest.assignment.dto;

public class BalanceDTO {

	private String accountNumber;

	private String lastUpdateTimestamp;

	private Double balance;

	public BalanceDTO() {
		
	}

	public BalanceDTO(String accountNumber, String lastUpdateTimestamp, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
