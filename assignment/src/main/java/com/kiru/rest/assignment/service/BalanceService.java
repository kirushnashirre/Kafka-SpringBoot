package com.kiru.rest.assignment.service;

import com.kiru.rest.assignment.dto.BalanceDTO;
import com.kiru.rest.assignment.dto.BalanceQueryDTO;
import com.kiru.rest.assignment.dto.TransactionDTO;

public interface BalanceService {

	BalanceDTO getLatestBalance(BalanceQueryDTO dto);
     
     void calculateBalance(TransactionDTO transaction);
}
