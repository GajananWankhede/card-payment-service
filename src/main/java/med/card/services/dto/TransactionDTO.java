package med.card.services.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import med.card.services.entity.User;


//exact clone of Transaction Entity (Data Transfer Object)
public class TransactionDTO {

	private User user;
	private Long cardNumber;
	@Column(name = "timeStamp")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")// date time format
	private LocalDateTime timeStamp;
	private String type;
	private String currency;
	private Double creditAmount;
	private Double debitAmount;
	private Double amount;
	
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	public TransactionDTO(User user, Long cardNumber, LocalDateTime timeStamp, String type, String currency,
			Double creditAmount,Double debitAmount,Double amount) {
		super();
		this.user = user;
		this.cardNumber = cardNumber;
		this.timeStamp = timeStamp;
		this.type = type;
		this.currency = currency;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.amount = amount;
	}
	
	public TransactionDTO() {}
	@Override
	public String toString() {
		return "TransactionDTO [user=" + user + ", cardNumber=" + cardNumber + ", timeStamp=" + timeStamp + ", type="
				+ type + ", currency=" + currency + ", creditAmount=" + creditAmount + ", debitAmount=" + debitAmount
				+ ", amount=" + amount + "]";
	}
	
	
	
}
