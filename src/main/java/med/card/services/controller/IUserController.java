package com.paymentservice.controller;

import java.util.List;

import com.paymentservice.dto.UserDTO;



public interface IUserController {
	
	public List<UserDTO> getAllUser();

}
