package com.kiru.rest.assignment.model;

import java.time.OffsetDateTime;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Transaction {
	
	 	@Id
	 	private String tranId;
	 	
	    private String accountNumber;

	    private OffsetDateTime transactionTs;
	    
	    private String type;

	    private Double amount;
	    
	    public Transaction() {};


		public Transaction(String tranId, String accountNumber, OffsetDateTime transactionTs, String type, Double amount) {
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

		public OffsetDateTime getTransactionTs() {
			return transactionTs;
		}

		public void setTransactionTs(OffsetDateTime transactionTs) {
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


		@Override
		public String toString() {
			return "Transaction [tranId=" + tranId + ", accountNumber=" + accountNumber + ", transactionTs="
					+ transactionTs + ", type=" + type + ", amount=" + amount + "]";
		}

		
	    
	    

}
