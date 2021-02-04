package com.kiru.rest.assignment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
public class Balance {

    @Id
    private String accountNumber;

    private String lastUpdateTimestamp;

    private Double balance;
    
    public Balance() {
    	
    }

	public Balance(String accountNumber, String lastUpdateTimestamp, Double balance) {
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



	@Override
	public String toString() {
		return "Balance [accountNumber=" + accountNumber + ", lastUpdateTimestamp=" + lastUpdateTimestamp + ", balance="
				+ balance + "]";
	}
    
    
}
