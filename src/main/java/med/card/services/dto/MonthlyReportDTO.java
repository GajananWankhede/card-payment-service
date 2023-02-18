package com.paymentservice.dto;

public class MonthlyReportDTO {
	
	String month;
	String currency;
	double totalCredits;
	double totalDebits;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(double totalCredits) {
		this.totalCredits = totalCredits;
	}
	public double getTotalDebits() {
		return totalDebits;
	}
	public void setTotalDebits(double totalDebits) {
		this.totalDebits = totalDebits;
	}
	public MonthlyReportDTO(String month, String currency, double totalCredits, double totalDebits) {
		super();
		this.month = month;
		this.currency = currency;
		this.totalCredits = totalCredits;
		this.totalDebits = totalDebits;
	}
	public MonthlyReportDTO() {}
	@Override
	public String toString() {
		return "MonthlyReportDTO [month=" + month + ", currency=" + currency + ", totalCredits=" + totalCredits
				+ ", totalDebits=" + totalDebits + "]";
	}
	
	
	
	

}
