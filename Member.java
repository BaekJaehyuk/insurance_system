import java.util.*;
/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:56
 */
public class Member extends Customer {

	private int accidentHistory;
	private Account Account;
	private int joinDate;
	private ArrayList loanInsuranceDetails;
	private int memberID;
	private ArrayList registeredInsuranceDetails;
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