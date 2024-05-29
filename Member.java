package 설계.도메인2;


/**
 * @author SW인재육성사업단
 * @version 1.0
 * @created 29-5-2024 오후 10:34:56
 */
public class Member extends Customer {

	private int accidentHistory;
	private Account Account;
	private int joinDate;
	private Array loanInsuranceDetails;
	private int memberID;
	private Array registeredInsuranceDetails;
	public Account m_Account;
	public Compensation m_Compensation;
	public Accident m_Accident;
	public Loan m_Loan;

	public Member(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void pay(){

	}

}