package med.card.services.service;

import med.card.services.dto.TransactionDTO;

import java.util.List;


public interface ITransactionService {
	// method declaration without definition
	public List<TransactionDTO> getAllTransactionByUserId(Integer userId);
	public List<TransactionDTO> getAllTransactionByMonth();
	public List<TransactionDTO> getAllTransactionByUserCard(Long cardNumber);
	public TransactionDTO saveTransaction(TransactionDTO transactionDTO);
	
}
