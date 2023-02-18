package com.paymentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.dao.MonthReport;
import com.paymentservice.dto.TransactionDTO;
import com.paymentservice.service.TransactionService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/payment-services")
public class TransactionController implements ITransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction/save")
	public TransactionDTO saveTransaction(@RequestBody TransactionDTO transactionDTO) {
		return transactionService.saveTransaction(transactionDTO);
	}
	
	@GetMapping("/transaction/getAllTransactionById/{userId}")
	public List<TransactionDTO> getAllTransactionById(@PathVariable  Integer userId){
		return transactionService.getAllTransactionByUserId(userId);
	}
	
	@GetMapping("/transaction/getBalanceByCard/{cardNumber}")
	public Double getAllbalance(@PathVariable  Long cardNumber){
		return transactionService.getBalanceByCard(cardNumber);
	}
	
	@GetMapping("/transaction/getAllTransactionByMonth")
	public List<MonthReport> getAllTransactionMonthwise(){
		return transactionService.getAllTransactionMonthwise();
	}
	
	@GetMapping("/transaction/getAllTransactionByUserCard/{cardNumber}")
	public List<TransactionDTO> getAllTransactionByUserCard(@PathVariable  Long cardNumber){
		return transactionService.getAllTransactionByUserCard(cardNumber);
	}
	

}
