package src.system.user;

import src.system.Accident;
import src.system.Account;
import src.system.Compensation;
import src.system.Loan;
import src.system.user.Customer;

import java.util.*;
/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:56
 */
public class Member extends Customer {

	private int accidentHistory;
	private src.system.Account Account;
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