package med.card.services.assembler;

import java.util.ArrayList;
import java.util.List;

import med.card.services.dto.TransactionDTO;
import med.card.services.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionAssembler {

	//method to convert Entity Object to DTO Object and return DTO Object
	public TransactionDTO convertEntitytoDTO(Transaction transactionEntity){
		
		TransactionDTO transactionDTO = new TransactionDTO();
//		transactionDTO.setUser(transactionEntity.getUser());
		transactionDTO.setCardNumber(transactionEntity.getCardNumber());
		transactionDTO.setType(transactionEntity.getType());
		transactionDTO.setCurrency(transactionEntity.getCurrency());
		transactionDTO.setAmount(transactionEntity.getAmount());
		transactionDTO.setDebitAmount(transactionEntity.getDebitAmount());
		transactionDTO.setCreditAmount(transactionEntity.getCreditAmount());
		transactionDTO.setTimeStamp(transactionEntity.getTimeStamp());
		
		return transactionDTO;
	}
	
	//method to convert DTO object to Entity Object and return Entity Object
    public Transaction convertDTOtoEntity(TransactionDTO transactionDTO){
    	
    	Transaction transactionEntity = new Transaction();
//    	transactionEntity.setUser(transactionDTO.getUser());
    	transactionEntity.setCardNumber(transactionDTO.getCardNumber());
    	transactionEntity.setType(transactionDTO.getType());
    	transactionEntity.setCurrency(transactionDTO.getCurrency());
    	transactionEntity.setAmount(transactionDTO.getAmount());
    	transactionEntity.setDebitAmount(transactionDTO.getDebitAmount());
    	transactionEntity.setCreditAmount(transactionDTO.getCreditAmount());
    	transactionEntity.setTimeStamp(transactionDTO.getTimeStamp());
		
    	return transactionEntity;
	}

	
	
	
public List<TransactionDTO> convertEntitytoDTO(List<Transaction> transactionEntityList) {
		
		List<TransactionDTO> transactionDTOList = new ArrayList<TransactionDTO>();
		for(int i=0;i<transactionEntityList.size();i++)
		{
			TransactionDTO transactionDTO = new TransactionDTO();
			Transaction transactionEntity = transactionEntityList.get(i);
//			transactionDTO.setUser(transactionEntity.getUser());
			transactionDTO.setCardNumber(transactionEntity.getCardNumber());
			transactionDTO.setType(transactionEntity.getType());
			transactionDTO.setCurrency(transactionEntity.getCurrency());
			transactionDTO.setAmount(transactionEntity.getAmount());
			transactionDTO.setDebitAmount(transactionEntity.getDebitAmount());
			transactionDTO.setCreditAmount(transactionEntity.getCreditAmount());
			transactionDTO.setTimeStamp(transactionEntity.getTimeStamp());
			transactionDTOList.add(transactionDTO);
		}
		return transactionDTOList;
	}

}
