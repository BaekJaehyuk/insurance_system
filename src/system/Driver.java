package src.system;

import java.util.Date;

public class Driver extends Car {

	private Date drivingExperience;

	public Driver(InsuranceFee insuranceFee, int insurancePayment, Policy policy, int rate, int mileage, Date date) {
		this.setId();
		this.setInsuranceFee(insuranceFee);
		this.setInsurancePayment(insurancePayment);
		this.setPolicy(policy);
		this.setRate(rate);
		this.setMileage(mileage);
		this.drivingExperience = date;
	}
}