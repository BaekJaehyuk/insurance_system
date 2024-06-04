package src.system;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:56
 */
public class OwnCar extends Car {

	private int model;
	private int vehicleNumber;


	public OwnCar(int customerId, InsuranceFee insuranceFee, int insurancePayment, Policy policy, int rate, int mileage, int model, int vehicleNumber) {

		this.setId();
		this.setInsuranceFee(insuranceFee);
		this.setInsurancePayment(insurancePayment);
		policy.setInsuranceId(getInsuranceID());
		policy.setMemberId(customerId);
		this.setPolicy(policy);
		this.setRate(rate);
		this.setMileage(mileage);
		this.model = model;
		this.vehicleNumber = vehicleNumber;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}