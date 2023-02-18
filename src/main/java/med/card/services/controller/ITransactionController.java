package com.paymentservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.paymentservice.dao.MonthReport;
import com.paymentservice.dto.TransactionDTO;


public interface ITransactionController {

	
	public TransactionDTO saveTransaction(@RequestBody TransactionDTO userDTO);
	public List<MonthReport> getAllTransactionMonthwise();
	public List<TransactionDTO> getAllTransactionById(Integer userId);
}
