package com.paymentservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.assembler.TransactionAssembler;
import com.paymentservice.dao.MonthReport;
import com.paymentservice.dao.TransactionRepository;
import com.paymentservice.dao.UserRepository;
import com.paymentservice.dto.TransactionDTO;
import com.paymentservice.entity.Transaction;
import com.paymentservice.entity.User;

//@Service annotation tells spring boot type of object. spring boot stored it to container for dependancy injection
@Service
public class TransactionService implements ITransactionService{

	//Dependency injection 
	//injecting object of type repository and assembler by using @Autowired
	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	TransactionAssembler transactionAssembler;
	
	@Autowired
	UserRepository userRepo;
	
   
	//method for getting All Transaction By UserId given by user
	public List<TransactionDTO> getAllTransactionByUserId(Integer userId) {
		
		User UserEntity = userRepo.getUserById(userId);
		List<Transaction> transactionEntityList = transactionRepo.getAllTransactionByUserCard(UserEntity.getUserCardNumber());

		List<TransactionDTO> transactionDTOList = transactionAssembler.convertEntitytoDTO(transactionEntityList);

		return transactionDTOList;
	}
	
public List<MonthReport> getAllTransactionMonthwise() {
		
		List<MonthReport> transactionMonthwise = transactionRepo.getAllTransactionMonthwise();
       System.out.println(transactionMonthwise);
		return transactionMonthwise;
	}


	//method for getting All Transaction By UserCard number given by user
public List<TransactionDTO> getAllTransactionByUserCard(Long cardNumber) {
		// getting user object from database
		List<Transaction> transactionEntityList = transactionRepo.getAllTransactionByUserCard(cardNumber);

		//converting Transaction object to DTO object
		List<TransactionDTO> transactionDTOList = transactionAssembler.convertEntitytoDTO(transactionEntityList);

		//returns DTO object instead of Entity Object to secure actual Entity object
		return transactionDTOList;
	}
	
	public List<TransactionDTO> getAllTransactionByMonth(){
		
		List<Transaction> transactionEntityList = transactionRepo.findAll();
        
		List<TransactionDTO> transactionDTOList = transactionAssembler.convertEntitytoDTO(transactionEntityList);

		return transactionDTOList;
	}
//getting balance from user by using transaction card number	
public Double getBalanceByCard(Long cardNumber){
		
	Double Balance = userRepo.getBalanceByCard(cardNumber);

		return Balance;
	}

   //method to perform transaction by User
    @Transactional
	public TransactionDTO saveTransaction(TransactionDTO transactionDTO) {
		User UserEntity = userRepo.getUserByCardId(transactionDTO.getCardNumber());

		try {

			if(UserEntity == null) // checking user validity
			{
				throw new CardNotFoundException("Sorry but Card Not found");
			}
			
			Transaction transactionEntity = transactionAssembler.convertDTOtoEntity(transactionDTO);
			Double balance = userRepo.getBalanceByCard(transactionEntity.getCardNumber());
			Double amount = transactionEntity.getAmount();
			Double Debit = UserEntity.getTotalDebits();
			Double Credit = UserEntity.getTotalCredits();
			String type = transactionEntity.getType();
			if(type.equals("Debit")) {
				// checked type of transaction Credit/Debit 
				try {
					if((balance < amount) ) // checking balance 
					{
						throw new BalanceNotFoundException("Sorry Insufficient Balance");
					}
					//Debit operation
					balance = balance - amount;
					Debit = Debit + amount;
					transactionEntity.setDebitAmount(amount);
					UserEntity.setBalance(balance);
					UserEntity.setTotalDebits(Debit);
					userRepo.save(UserEntity); //Entity object return back to database
					transactionRepo.save(transactionEntity);//Transaction return to database
				}catch (BalanceNotFoundException b) {


					System.out.println("Exception occured :"+b.getMessage());

				}
				
				
			}
			else if(type.equals("Credit")) {
				 //Credit Operation
				   balance = balance + amount;
				   Credit = Credit + amount;
				   UserEntity.setBalance(balance);
				   UserEntity.setTotalCredits(Credit);
				   transactionEntity.setCreditAmount(amount);
				   userRepo.save(UserEntity); //Entity object return back to database
				   transactionRepo.save(transactionEntity);//Transaction return to database
				 }
			else {
				System.out.println();
			  }
			   
			   transactionDTO  = transactionAssembler.convertEntitytoDTO(transactionEntity);
				   
				   
          } catch (CardNotFoundException c) {


			System.out.println("Exception occured :"+c.getMessage());

		}

		return transactionDTO;	

	}

}









