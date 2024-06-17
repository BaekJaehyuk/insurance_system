package src.system;

public class Driver extends Car {

	private int drivingExperience;
	private String insuranceName;

	public Driver(int customerId, String insuranceName, InsuranceFee insuranceFee, String paymentStatus, Policy policy, int rate, int mileage, int date) {
		this.setId();
		this.setCustomerID((long) customerId); // Set customer ID
		this.setInsuranceFee(insuranceFee);
		this.setPaymentStatus(paymentStatus);
		this.setPolicy(policy);
		this.setPolicy(policy);
		this.setRate(rate);
		this.setMileage(mileage);
		this.drivingExperience = date;
		this.insuranceName = insuranceName;
	}




	public int getDrivingExperience() {
		return drivingExperience;
	}

	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	@Override
	public String toString() {
		return "Driver{" +
				"drivingExperience=" + drivingExperience +
				", insuranceName='" + insuranceName + '\'' +
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
