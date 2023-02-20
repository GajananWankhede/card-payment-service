package med.card.services.service;
import med.card.services.dto.UserDTO;

import java.util.List;

public interface IUserService {
	// method declaration without definition 
	public List<UserDTO> getAllUser();
	public Double getBalanceByCard(Long cardNumber);
	public UserDTO getUserByCardId(Long cardNumber);
	public UserDTO saveUser(UserDTO userDTO);
	

}
