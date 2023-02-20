package med.card.services.dao;

import java.util.List;


import med.card.services.dto.UserDTO;
import med.card.services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	//mysql queries to retrieve or save data from database
	
    @Transactional
	@Query(value = "select balance from user u where u.userCardNumber = :cardNumber",nativeQuery = true)
	Double getBalanceByCard(@Param("cardNumber") Long cardNumber);

	
    @Transactional
	@Query(value = "select * from user u where u.userCardNumber = :cardNumber",nativeQuery = true)
	User getUserByCardId(@Param("cardNumber") Long cardNumber);
    
    @Transactional
	@Query(value = "select * from user u where u.userid = :userid",nativeQuery = true) 
	User getUserById(@Param("userid") Integer userId);
    
    
    @Transactional
	@Query(value = "select userid,balance,totalcredits, totaldebits from user",nativeQuery = true)
	List<UserBalance> getUserBalance();


	Object save(UserDTO userDTO);

    
}
