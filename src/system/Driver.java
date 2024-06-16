package src.system;

import java.util.Date;

public class Driver extends Car {

	private Date drivingExperience;

	public Driver(int customerId, InsuranceFee insuranceFee, String paymentStatus, Policy policy, int rate, int mileage, Date date) {
		this.setId();
		this.setCustomerID((long) customerId); // Set customer ID
		this.setInsuranceFee(insuranceFee);
		this.setPaymentStatus(paymentStatus);
		policy.setInsuranceId(getInsuranceID());
		policy.setMemberId(customerId);
		this.setPolicy(policy);
		this.setRate(rate);
		this.setMileage(mileage);
		this.drivingExperience = date;
	}

	public Date getDrivingExperience() {
		return drivingExperience;
	}

	public void setDrivingExperience(Date drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	@Override
	public String toString() {
		return "Driver{" +
				"drivingExperience=" + drivingExperience +
				", insuranceID=" + getInsuranceID() +
				", insuranceFee=" + getInsuranceFee().getAmount() +
				", insurancePayment=" + getPaymentStatus() +
				", policy=" + getPolicy() +
				", rate=" + getRate() +
				", mileage=" + getMileage() +
				'}';
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}
}