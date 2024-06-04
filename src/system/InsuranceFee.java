package src.system;

import java.util.Date;

public class InsuranceFee {

	private int amount;
	private Date dateOfPayment;

	public InsuranceFee(int amount){
		this.amount = amount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
}