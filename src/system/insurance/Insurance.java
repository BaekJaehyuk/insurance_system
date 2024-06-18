package src.system.insurance;

import src.system.user.Join;
import src.system.compensation.Compensation;
import src.system.product.Product;

public class Insurance {

	private static Long LastId = 0L;
	private Long insuranceID;
	private Long customerID; // Add this line
	private InsuranceFee insuranceFee;
	private String paymentStatus;
	private Policy policy;
	private int rate;

	// Getters
	public Long getInsuranceID() {
		return insuranceID;
	}

	public Long getCustomerID() { // Add this getter
		return customerID;
	}

	public InsuranceFee getInsuranceFee() {
		return this.insuranceFee;
	}

	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public Policy getPolicy() {
		return this.policy;
	}

	public int getRate() {
		return this.rate;
	}

	// Setters
	public void setId() {
		this.insuranceID = ++LastId;
	}

	public void setCustomerID(Long customerID) { // Add this setter
		this.customerID = customerID;
	}

	public void setInsuranceFee(InsuranceFee insuranceFee) {
		this.insuranceFee = insuranceFee;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Join m_Join;
	public Policy m_Policy;
	public InsuranceFee m_InsuranceFee;
	public Compensation m_Compensation;
	public Car m_car;
	public Product m_Product;

	public void finalize() throws Throwable {

	}

	public void design() {

	}

	/**
	 * 상품을 설계한 뒤, 해당 설계한 상품의 ID 값 반환
	 * @return Product Id
	 */
	public Long makeContract() {
		return 0L;
	}

	public void prolong() {

	}

	@Override
	public String toString() {
		return "Insurance{" +
				"보험ID =" + insuranceID +
				", 보험료 ='" + insuranceFee.getAmount() + '\'' +
				", 보험료 납부여부 ='" + paymentStatus + '\'' +
				'}';
	}

}
