package com.kiru.rest.assignment.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kiru.rest.assignment.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{
	
	long countByAccountNumber(String accountNumber);
	
	List<Transaction>findAllByAccountNumberAndTransactionTsBetween(String accountNumber,OffsetDateTime startDate, OffsetDateTime endDate);
	
	List<Transaction>findAllByAccountNumberAndTypeAndTransactionTsBetween(String accountNumber,String type, OffsetDateTime startDate, OffsetDateTime endDate);

}
