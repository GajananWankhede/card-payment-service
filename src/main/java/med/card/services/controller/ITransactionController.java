package med.card.services.controller;

import java.util.List;

import med.card.services.dao.MonthReport;
import med.card.services.dto.TransactionDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface ITransactionController {

	
	public TransactionDTO saveTransaction(@RequestBody TransactionDTO userDTO);
	public List<MonthReport> getAllTransactionMonthwise();
	public List<TransactionDTO> getAllTransactionById(Integer userId);
}
