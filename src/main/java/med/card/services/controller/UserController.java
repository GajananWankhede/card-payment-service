package com.paymentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.dao.UserBalance;
import com.paymentservice.dao.UserRepository;
import com.paymentservice.dto.UserDTO;
import com.paymentservice.entity.User;
import com.paymentservice.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/payment-services")
public class UserController {
	
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  UserService userService;
  
  //method to get user balance report   
  @GetMapping("/user/getAllUserBalance")
  public List<UserBalance> getUserBalance() {
      return  userService.getUserBalance();

  }
  
  //method to get User details using card number
  @GetMapping("/user/getUserByCardId/{cardNumber}")
      public UserDTO getUserByCardId(@PathVariable  Long cardNumber) {
          return  userService.getUserByCardId(cardNumber);

      }
  
  //method to get create user
  @PostMapping("/user/create")
  public UserDTO saveUser(@RequestBody UserDTO userDTO) {
      return  userService.saveUser(userDTO);

  }
  
  // method to get list of users
  @GetMapping("/user/all")
      public List<User> getAllUsers() {
          return userRepository.findAll();
      }
}
