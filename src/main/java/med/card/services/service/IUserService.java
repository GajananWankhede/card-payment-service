package com.paymentservice.service;

import java.util.List;

import com.paymentservice.dto.UserDTO;

public interface IUserService {
	// method declaration without definition 
	public List<UserDTO> getAllUser();
	public Double getBalanceByCard(Long cardNumber);
	public UserDTO getUserByCardId(Long cardNumber);
	public UserDTO saveUser(UserDTO userDTO);
	

}
