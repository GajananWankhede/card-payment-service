package com.paymentservice.service;

import java.util.List;

import com.paymentservice.dto.TransactionDTO;

public interface ITransactionService {
	// method declaration without definition
	public List<TransactionDTO> getAllTransactionByUserId(Integer userId);
	public List<TransactionDTO> getAllTransactionByMonth();
	public List<TransactionDTO> getAllTransactionByUserCard(Long cardNumber);
	public TransactionDTO saveTransaction(TransactionDTO transactionDTO);
	
}
