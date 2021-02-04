package com.kiru.rest.assignment.dto;

public class TransactionDTO {

	private String tranId;

	private String accountNumber;

	private String transactionTs;

	private String type;

	private Double amount;

	public TransactionDTO() {
	};

	public TransactionDTO(String tranId, String accountNumber, String transactionTs, String type, Double amount) {
		super();
		this.tranId = tranId;
		this.accountNumber = accountNumber;
		this.transactionTs = transactionTs;
		this.type = type;
		this.amount = amount;
	}

	public String getTranId() {
		return tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionTs() {
		return transactionTs;
	}

	public void setTransactionTs(String transactionTs) {
		this.transactionTs = transactionTs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
