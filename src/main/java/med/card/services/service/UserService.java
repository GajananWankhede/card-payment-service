package med.card.services.service;

import java.util.List;

import med.card.services.assembler.UserAssembler;
import med.card.services.dao.UserBalance;
import med.card.services.dao.UserRepository;
import med.card.services.dto.UserDTO;
import med.card.services.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


//@Service annotation tells spring boot type of object. spring boot stored it to container for dependancy injection
@Service
public class UserService {
	//Dependency injection 
		//injecting object of type repository and assembler by using @Autowired
		
	@Autowired
	UserRepository userRepo;

	@Autowired
	UserAssembler userAssembler;
   //method to get All User details
	public List<UserDTO> getAllUsers() {

		List<User> userEntityList = userRepo.findAll();

		List<UserDTO> userDTOList = userAssembler.convertEntityToDTO(userEntityList);

		return userDTOList;
	}
	
	
	public List<UserBalance> getUserBalance() {

		List<UserBalance> userBalance = userRepo.getUserBalance();

		return userBalance;
	}
	
       public Double getBalanceByCard(Long cardNumber){
		
		Double Balance = userRepo.getBalanceByCard(cardNumber);

		return Balance;
	}
	
       //method to get User by cardNumber
	public UserDTO getUserByCardId(Long cardNumber) {	

		User userEntity = userRepo.getUserByCardId(cardNumber);

		UserDTO userDTO = userAssembler.convertEntitytoDTO(userEntity);

		return userDTO;
	}
	
	//Method to save New NUser to database
	@Transactional
	public UserDTO saveUser(UserDTO userDTO) {
		
		User userEntity = userAssembler.convertDTOtoEntity(userDTO);
		userRepo.save(userEntity);
		userDTO  = userAssembler.convertEntitytoDTO(userEntity);
		return userDTO;

	}
	
	
}















