package src.system;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:57
 */
public class Policy {

	private int insuranceID;
	private int memberID;

	public Policy(){

	}

	public void finalize() throws Throwable {

	}

	public void setInsuranceId(Long insuranceID) {
		this.insuranceID = insuranceID.intValue();
	}
	public void setMemberId(int memberID) {
		this.memberID = memberID;
	}
}