package src.system;

public class Insurance {

	private static Long insuranceID = 0L;
	private InsuranceFee InsuranceFee;
	private int insurancePayment;
	private Policy Policy;
	private Product Product;
	private int rate;
	public Join m_Join;
	public Policy m_Policy;
	public InsuranceFee m_InsuranceFee;
	public Compensation m_Compensation;
	public Car m_car;
	public Product m_Product;

	public Insurance(){
		insuranceID++;
	}

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

}
