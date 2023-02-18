package com.paymentservice.assembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.paymentservice.dto.UserDTO;
import com.paymentservice.entity.User;

@Component
public class UserAssembler {
	
	
	//method to convert list of Entity Object to list of  DTO Object and return List of DTO Object	
public List<UserDTO> convertEntityToDTO(List<User> userEntityList) {
		
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		for(int i=0;i<userEntityList.size();i++)
		{
			UserDTO userDTO = new UserDTO();
			User userEntity = userEntityList.get(i);
			userDTO.setUserId(userEntity.getUserId());
			userDTO.setBalance(userEntity.getBalance());
			userDTO.setCurrency(userEntity.getCurrency());
			userDTO.setTotalCredits(userEntity.getTotalCredits());
			userDTO.setTotalDebits(userEntity.getTotalDebits());
			userDTOList.add(userDTO);
		}
		Collections.sort(userDTOList);
		return userDTOList;
	}
  
//method to convert DTO object to Entity Object and return Entity Object
    public User convertDTOtoEntity(UserDTO userDTO){
	
	User userEntity = new User();
	userEntity.setUserId(userDTO.getUserId());
	userEntity.setUserName(userDTO.getUserName());
	userEntity.setContacttNo(userDTO.getContacttNo());
	userEntity.setAddress(userDTO.getAddress());
	userEntity.setUserCardNumber(userDTO.getUserCardNumber());
	userEntity.setBalance(userDTO.getBalance());
	userEntity.setCurrency(userDTO.getCurrency());
	userEntity.setTotalCredits(userDTO.getTotalCredits());
	userEntity.setTotalDebits(userDTO.getTotalDebits());
	
	return userEntity;
    }
    
  //method to convert Entity Object to DTO Object and return DTO Object	
    public UserDTO convertEntitytoDTO(User userEntity){
    	
    	UserDTO userDTO = new UserDTO();
    	userDTO.setUserId(userEntity.getUserId());
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setContacttNo(userEntity.getContacttNo());
		userDTO.setAddress(userEntity.getAddress());
		userDTO.setUserCardNumber(userEntity.getUserCardNumber());
		userDTO.setBalance(userEntity.getBalance());
		userDTO.setCurrency(userEntity.getCurrency());
		userDTO.setTotalCredits(userEntity.getTotalCredits());
		userDTO.setTotalDebits(userEntity.getTotalDebits());
    	
    	return userDTO;
        }

}
