package com.paymentservice.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="TRANSACTION")
public class Transaction {
	
	@Id  // primary key 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	Integer ID;
    
	@Column(name="CARDNUMBER", length = 16)
	private Long cardNumber;
    
	@Column(name = "timeStamp")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm") // date time format
	private LocalDateTime timeStamp;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name="CREDITAMOUNT")
	private Double creditAmount;
	
	@Column(name="DEBITAMOUNT")
	private Double debitAmount;
	
	@Column(name="AMOUNT")
	private Double amount;
	
	@ManyToOne // Many to one relation mapping
	private User user;
	
	
	//All getters and setters method to encapsulate member variable
	
	
	
	public Integer getID() {
		return ID;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

		// Parameterized constructor

	public Transaction(Integer iD, Long cardNumber, LocalDateTime timeStamp, String type,
			String currency, Double creditAmount,Double debitAmount,Double amount, User user) {
		super();
		ID = iD;
		this.cardNumber = cardNumber;
		this.timeStamp = timeStamp;
		this.type = type;
		this.currency = currency;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.user = user;
		this.amount = amount;
	}
	// default constructor
	public Transaction() {}

}
