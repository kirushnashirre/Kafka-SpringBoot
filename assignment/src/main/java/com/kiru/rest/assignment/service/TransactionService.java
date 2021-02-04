package com.kiru.rest.assignment.service;

import java.util.List;

import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.dto.TransactionQueryDTO;

public interface TransactionService {
	
	List<TransactionDTO> getTransactions(TransactionQueryDTO dto); 

}
