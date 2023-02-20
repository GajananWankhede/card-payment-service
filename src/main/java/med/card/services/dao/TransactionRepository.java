package med.card.services.dao;

import med.card.services.entity.Transaction;
import med.card.services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    
	
	//mysql queries to retrieve or save data from database
	
	@Transactional
	@Query(value = "select * from transaction t where"+ " t.cardNumber = :cardNumber",nativeQuery = true)
	List<Transaction> getAllTransactionByUserId(@Param("cardNumber") Long cardNumber);
	
	
	
	
	@Transactional
	@Query(value = "select * from user u where u.userCardNumber = :cardNumber",nativeQuery = true)
	User getUserByCardId(@Param("cardNumber") Long cardNumber);



	@Transactional
	@Query(value = "select * from transaction t where t.cardNumber = :cardNumber",nativeQuery = true)
	List<Transaction> getAllTransactionByUserCard(@Param("cardNumber") Long cardNumber);

	
	@Query(value = "select substr(t.time_stamp,6,2) as month, "
			+ "t.currency as currency, "
			+ " sum(t.creditamount) as totalCredits, "
			+ "sum(t.debitamount) as totalDebits "
			+ "from transaction t " +  
			" group by substr(t.time_stamp,6,2)", nativeQuery = true)
	List<MonthReport> getAllTransactionMonthwise();
}



//select month(time_stamp) as Month ,t.currency as Currency ,sum(creditamount),sum(debitamount)from paymentschema.transaction t, paymentschema.user u
//where t.cardnumber = u.usercardnumber
//group by substr(time_stamp,6,2);








