package src.system;

import java.util.Date;

public class InsuranceFee {

	private double amount;
	private Date dateOfPayment;

	public InsuranceFee(double amount){
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
}