package src.system;

public class Insurance {

	private static Long LastId = 0L;
	private Long insuranceID;
	private InsuranceFee insuranceFee;
	private int insurancePayment;
	private Policy policy;
	private int rate;

	// get
	public Long getInsuranceID(){
		return insuranceID;
	}
	public InsuranceFee getInsuranceFee(){
		return this.insuranceFee;
	}
	public int getInsurancePayment(){
		return this.insurancePayment;
	}
	public Policy getPolicy(){
		return this.policy;
	}
	public int getRate(){
		return this.rate;
	}

	//set

	public void setId() {
		this.insuranceID = LastId++;
	}
	public void setInsuranceFee(InsuranceFee insuranceFee){
		this.insuranceFee = insuranceFee;
	}
	public void setInsurancePayment(int insurancePayment){
		this.insurancePayment = insurancePayment;
	}
	public void setPolicy(Policy policy){
		this.policy = policy;
	}
	public void setRate(int rate){
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
	public Long makeContract(){
	 	return 0L;
	}

	public void prolong(){

	}

	@Override
	public String toString() {
		return "Insurance{" +
				"InsuranceID=" + insuranceID +
				", InsuranceFeeAmount='" + insuranceFee.getAmount() + '\'' +
				", InsuranceFeeDatePayment='" + insuranceFee.getDateOfPayment() + '\'' +
				", InsurancePayment='" + insurancePayment + '\'' +
				'}';
	}

}
