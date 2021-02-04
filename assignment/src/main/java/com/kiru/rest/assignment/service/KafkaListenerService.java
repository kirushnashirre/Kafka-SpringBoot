package com.kiru.rest.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.model.Balance;
import com.kiru.rest.assignment.repository.BalanceRepository;
import com.kiru.rest.assignment.repository.TransactionRepository;
import com.kiru.rest.assignment.util.ObjectMapper;

	
@Service
public class KafkaListenerService {

	@Autowired
	BalanceRepository balanceRepository;

	@Autowired
	BalanceService balanceService;

	@Autowired
	TransactionRepository transactionRepository;

	@KafkaListener(groupId = "testGroup1", topics = "Balance", containerFactory = "balanceKafkaListernerContainerFactory")
	public void getMessageFromTopic(Balance balance) {
		balanceRepository.save(balance);
	}

	@KafkaListener(groupId = "testGroup2", topics = "Transaction", containerFactory = "transactionKafkaListernerContainerFactory")
	public void getTransactionFromTopic(TransactionDTO transaction) {
		transactionRepository.save(ObjectMapper.mapToTransaction(transaction));
		balanceService.calculateBalance(transaction);
	}

}
