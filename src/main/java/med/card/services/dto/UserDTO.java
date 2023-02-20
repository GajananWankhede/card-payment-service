package med.card.services.dto;


//exact clone of User Entity(Data Transfer Object)
public class UserDTO implements Comparable<UserDTO> {

	private Integer ID;
	private Long userCardNumber;
	private Integer userId;
	private String userName;
	private Long contacttNo;
	private String address;
	private String currency;
	private Double balance;
	private Double totalCredits;
	private Double totalDebits;
public Integer getID() {
	return ID;
}
public void setID(Integer iD) {
	ID = iD;
}

public Long getUserCardNumber() {
	return userCardNumber;
}
public void setUserCardNumber(Long userCardNumber) {
	this.userCardNumber = userCardNumber;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
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


public UserDTO(Integer iD, Long userCardNumber, Integer userId, String userName, Long contacttNo, String address,
		String currency, Double balance, Double totalCredits, Double totalDebits) {
	super();
	ID = iD;
	this.userCardNumber = userCardNumber;
	this.userId = userId;
	this.userName = userName;
	this.contacttNo = contacttNo;
	this.address = address;
	this.currency = currency;
	this.balance = balance;
	this.totalCredits = totalCredits;
	this.totalDebits = totalDebits;
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
public void setTotalCredits(Double totalCredits) {
	this.totalCredits = totalCredits;
}
public Double getTotalDebits() {
	return totalDebits;
}
public void setTotalDebits(Double totalDebits) {
	this.totalDebits = totalDebits;
}
public UserDTO() {}
@Override
public int compareTo(UserDTO userDTO) {
	return this.userId - userDTO.userId;
}
@Override
public String toString() {
	return "UserDTO [ID=" + ID + ", userCardNumber=" + userCardNumber + ", userId=" + userId + ", userName=" + userName
			+ ", contacttNo=" + contacttNo + ", address=" + address + ", currency=" + currency + ", balance=" + balance
			+ ", totalCredits=" + totalCredits + ", totalDebits=" + totalDebits + "]";
}



}
