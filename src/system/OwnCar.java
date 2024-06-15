package src.system;

public class OwnCar extends Car {

	private int model;
	private int vehicleNumber;

	public OwnCar(int customerId, InsuranceFee insuranceFee, String paymentStatus, Policy policy, int rate, int mileage, int model, int vehicleNumber) {
		this.setId();
		this.setCustomerID((long) customerId); // Set customer ID
		this.setInsuranceFee(insuranceFee);
		this.setPaymentStatus(paymentStatus);
		policy.setInsuranceId(getInsuranceID());
		policy.setMemberId(customerId);
		this.setPolicy(policy);
		this.setRate(rate);
		this.setMileage(mileage);
		this.model = model;
		this.vehicleNumber = vehicleNumber;
	}

	// Getters and Setters for OwnCar specific fields
	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	@Override
	public String toString() {
		return "OwnCar{" +
				"model=" + model +
				", vehicleNumber=" + vehicleNumber +
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
