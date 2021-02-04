package com.kiru.rest.assignment.util;

import com.kiru.rest.assignment.dto.BalanceDTO;
import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.model.Balance;
import com.kiru.rest.assignment.model.Transaction;

public class ObjectMapper {

	public static Transaction mapToTransaction(TransactionDTO dto) {
		return new Transaction(dto.getTranId(), dto.getAccountNumber(),
				DateTimeUtil.convertToDateTime(dto.getTransactionTs()), dto.getType().toUpperCase(), dto.getAmount());
	}

	public static BalanceDTO mapToBalanceDTO(Balance balance) {
		return new BalanceDTO(balance.getAccountNumber(), balance.getLastUpdateTimestamp(), balance.getBalance());
	}

	public static TransactionDTO mapToTransactionDTO(Transaction txn) {
		return new TransactionDTO(txn.getTranId(),txn.getAccountNumber(),txn.getType(),txn.getTransactionTs().toString(),txn.getAmount());
	}
}
