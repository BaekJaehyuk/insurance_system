package src.system;

import java.util.ArrayList;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:53
 */
public class Employee {

	private int department;
	private int employeeID;
	private int enteringDate;
	private int name;
	private int phoneNumber;
	private ArrayList<Attendance> m_attendance;
	public Attendance m_Attendance;
	public Accident m_Accident;
	public Counseling m_Counseling;
	public Insurance m_Insurance;
	public Loan m_Loan;
	public Employment m_Employment;
	public Interview  m_Interview ;
	public Education m_Education;
	public Campaign  m_Campaign ;

	public Employee(){

	}

	public void finalize() throws Throwable {

	}

	public void toAssessDamages(){

	}

	public void toSettleAccounts(){

	}

}