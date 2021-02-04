package com.kiru.rest.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.dto.TransactionQueryDTO;
import com.kiru.rest.assignment.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping("getAllTransactions")
	public List<TransactionDTO> getAllTransactions(@RequestBody TransactionQueryDTO dto) {

		return transactionService.getTransactions(dto);
	}
	
	@PostMapping("/getWithdrawTransactions")
	public List<TransactionDTO> getWithdrawTransactions(@RequestBody TransactionQueryDTO dto) {

		return transactionService.getTransactions(dto);
	}

}
