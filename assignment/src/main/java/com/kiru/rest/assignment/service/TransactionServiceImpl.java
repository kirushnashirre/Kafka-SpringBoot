package com.kiru.rest.assignment.service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiru.rest.assignment.dto.TransactionDTO;
import com.kiru.rest.assignment.dto.TransactionQueryDTO;
import com.kiru.rest.assignment.model.Transaction;
import com.kiru.rest.assignment.repository.TransactionRepository;
import com.kiru.rest.assignment.util.DateTimeUtil;
import com.kiru.rest.assignment.util.ObjectMapper;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public List<TransactionDTO> getTransactions(TransactionQueryDTO dto) {
		List<Transaction> list = new ArrayList<>();
		List<TransactionDTO> result = new ArrayList<>();
		OffsetDateTime startDate, endDate = null;
		if (transactionRepository.countByAccountNumber(dto.getAccountNumber()) > 0) {
			if (dto.getWindow() != null) {
				startDate = DateTimeUtil.getDateTime(getstartDate(dto.getWindow()));
				endDate = DateTimeUtil.getDateTime(new Date());
			} else {
				startDate = DateTimeUtil.convertToDateTime(dto.getStartDate());
				endDate = DateTimeUtil.convertToDateTime(dto.getEndDate());
			}
			if (dto.getType() != null)
				list = transactionRepository.findAllByAccountNumberAndTypeAndTransactionTsBetween(
						dto.getAccountNumber(), dto.getType(), startDate, endDate);
			else
				list = transactionRepository.findAllByAccountNumberAndTransactionTsBetween(dto.getAccountNumber(),
						startDate, endDate);
			list.forEach(i -> {
				result.add(ObjectMapper.mapToTransactionDTO(i));
			});

			return result;
		}

		return result;
	}

	Date getstartDate(String window) {
		Date startDate = null;

		switch (window) {
		case "DAILY":
			startDate = DateUtils.addDays(new Date(), -1);
			break;
		case "WEEKLY":
			startDate = DateUtils.addDays(new Date(), -7);
			break;
		case "MONTHLY":
			startDate = DateUtils.addMonths(new Date(), -1);
			break;
		}

		return startDate;
	}

}
