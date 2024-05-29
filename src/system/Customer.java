package src.system;

import java.util.Date;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:51
 */
public class Customer {

	private Date birthDay;
	private int customerID;
	private String name;
	private String phoneNumber;
	private String sex;
	public Join m_Join;
	public Compensation m_compensation;
	public Counseling m_Counseling;

	public Customer(){

	}

	public void finalize() throws Throwable {

	}

}