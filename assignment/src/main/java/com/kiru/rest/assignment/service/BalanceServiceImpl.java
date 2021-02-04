package com.kiru.rest.assignment.service;

import com.kiru.rest.assignment.dto.BalanceDTO;
import com.kiru.rest.assignment.dto.BalanceQueryDTO;
import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.exception.ResourceNotFoundException;
import com.kiru.rest.assignment.model.Balance;
import com.kiru.rest.assignment.repository.BalanceRepository;
import com.kiru.rest.assignment.util.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	BalanceRepository balanceRepository;

	@Autowired
	KafkaTemplate<String, Balance> kafkaTemplate;

	private static final String topic = "Balance";

	@Override
	public BalanceDTO getLatestBalance(BalanceQueryDTO dto) {
		Balance balance = balanceRepository.findById(dto.getAccountNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Account Number Not Found!"));
		return ObjectMapper.mapToBalanceDTO(balance);
	}

	@Override
	public void calculateBalance(TransactionDTO transaction) {
		Balance balance = balanceRepository.findById(transaction.getAccountNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Account Number Not Found!"));
		Double current = balance.getBalance();
		balance.setBalance(transaction.getType().equalsIgnoreCase("Deposit") ? current + transaction.getAmount()
				: current - transaction.getAmount());
		balance.setLastUpdateTimestamp(transaction.getTransactionTs());
		kafkaBalanceFeed(balance);
	}
	
	void kafkaBalanceFeed(Balance balance) {
		kafkaTemplate.send(topic, balance);
	}
}
