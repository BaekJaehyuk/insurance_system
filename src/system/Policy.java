package src.system;

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
