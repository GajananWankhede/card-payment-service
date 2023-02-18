package com.paymentservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;


@Entity
@Table(name="USER",uniqueConstraints={@UniqueConstraint(columnNames = {"USERID"}),
		                               @UniqueConstraint(columnNames = {"CONTACTNO"})})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	int ID;
    
	@OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "transaction_id")
	private List<Transaction> transaction;
    
	public  List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
    
	@NotNull
	@Column(name="USERID", unique=true)
	Integer userId;
	
	@NotNull
	@Column(name="USERCARDNUMBER", unique=true, length = 16)
	Long userCardNumber;
    

	@NotNull
	@Column(name="USERNAME")
	String userName;
	
	@NotNull
	@Column(name="CONTACTNO", length = 10)
	Long contacttNo;
	
	@NotNull
	@Column(name="ADDRESS")
	String address;
	
	@NotNull
	@Column(name="CURRENCY")
	String currency;
	
	@NotNull
	@Column(name="BALANCE")
	Double balance;
	
	@NotNull
	@Column(name="TOTALCREDITS")
	Double totalCredits;
	
	@NotNull
	@Column(name="TOTALDEBITS")
	Double totalDebits;
	
	
	public int getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Long getContacttNo() {
		return contacttNo;
	}


	public void setContacttNo(Long contacttNo) {
		this.contacttNo = contacttNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Double getTotalCredits() {
		return totalCredits;
	}
	
	


	public Long getUserCardNumber() {
		return userCardNumber;
	}


	public void setUserCardNumber(Long userCardNumber) {
		this.userCardNumber = userCardNumber;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public void setTotalCredits(Double totalCredits) {
		this.totalCredits = totalCredits;
	}


	public Double getTotalDebits() {
		return totalDebits;
	}


	public void setTotalDebits(Double totalDebits) {
		this.totalDebits = totalDebits;
	}
	

	
	public User(int iD, Integer userId, Long userCardNumber, String userName,
			   Long contacttNo, String address, String currency, Double balance, Double totalCredits, Double totalDebits) {
		super();
		ID = iD;
		this.userId = userId;
		this.userCardNumber = userCardNumber;
		this.userName = userName;
		this.contacttNo = contacttNo;
		this.address = address;
		this.currency = currency;
		this.balance = balance;
		this.totalCredits = totalCredits;
		this.totalDebits = totalDebits;
	}
	
	// Parameterized constructor
   public User(int iD, List<Transaction> transaction, Integer userId, Long userCardNumber, String userName,
		   Long contacttNo, String address, String currency, Double balance, Double totalCredits, Double totalDebits) {
	super();
	ID = iD;
	this.transaction = transaction;
	this.userId = userId;
	this.userCardNumber = userCardNumber;
	this.userName = userName;
	this.contacttNo = contacttNo;
	this.address = address;
	this.currency = currency;
	this.balance = balance;
	this.totalCredits = totalCredits;
	this.totalDebits = totalDebits;
}
   
   public User() {}


@Override
public String toString() {
	return "User [ID=" + ID + ", transaction=" + transaction + ", userId=" + userId + ", userCardNumber="
			+ userCardNumber + ", userName=" + userName + ", contacttNo=" + contacttNo + ", address=" + address
			+ ", currency=" + currency + ", balance=" + balance + ", totalCredits=" + totalCredits + ", totalDebits="
			+ totalDebits + "]";
}
   
   

}
