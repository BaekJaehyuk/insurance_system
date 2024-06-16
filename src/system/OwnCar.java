package src.system;

public class OwnCar extends Car {

	private int model;
	private int vehicleNumber;
	private String insuranceName;

	public OwnCar(int customerId, String insuranceName, InsuranceFee insuranceFee, String paymentStatus, Policy policy, int rate, int mileage, int model, int vehicleNumber) {
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
		this.insuranceName = insuranceName;
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

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	@Override
	public String toString() {
		return "OwnCar{" +
				"model=" + model +
				", vehicleNumber=" + vehicleNumber +
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
