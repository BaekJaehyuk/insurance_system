package src.system;

import java.text.NumberFormat;

public class OwnCar extends Car {

	private int model;
	private int vehicleNumber;
	private String insuranceName;

	public OwnCar(int customerId, String insuranceName, InsuranceFee insuranceFee, String paymentStatus, Policy policy, int rate, int mileage, int model, int vehicleNumber) {
		this.setId();
		this.setCustomerID((long) customerId); // Set customer ID
		this.setInsuranceFee(insuranceFee);
		this.setPaymentStatus(paymentStatus);
		this.setPolicy(policy);
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
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(true);
		nf.setMaximumFractionDigits(0);
		return "가입 상품" +
				" 보험 아이디: " + getInsuranceID() +
				", 보험이름: '" + insuranceName + '\'' +
				", 보험료: " + nf.format(getInsuranceFee().getAmount()) + "원" +
				", 보험금 한도: " + nf.format(getRate()) + "원" +
				", 정책: " +  getPolicy().toString() + "\n" +
				"고객 가입 정보" +
				" 차량 모델: " + model +
				", 차량 번호: " + vehicleNumber +
				", 주행거리: " + nf.format(getMileage()) + "km" +
				", 보험금 납입 확인: " + getPaymentStatus();
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}
}
