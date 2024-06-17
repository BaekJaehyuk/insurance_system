package src.system;

import java.text.NumberFormat;

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
		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(true);
		nf.setMaximumFractionDigits(0);
		return "가입 상품" +
				" 보험 아이디: " + getInsuranceID() +
				", 보험이름: '" + insuranceName + '\'' +
				", 보험료: " + nf.format(getInsuranceFee().getAmount()) + "원" +
				", 보험금 한도: " + nf.format(getRate()) + "원" +
				", 정책: " +  getPolicy().toString()+ "\n" +
				"고객 가입 정보" +
				" 운전경력: " + drivingExperience +
				", 주행거리: " + nf.format(getMileage()) + "km" +
				", 보험금 납입 확인: " + getPaymentStatus();
	}

	@Override
	public void finalize() throws Throwable {
		super.finalize();
	}
}
