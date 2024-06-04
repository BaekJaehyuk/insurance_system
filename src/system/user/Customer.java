package src.system.user;

import src.system.*;
import src.system.accident.Accident;
import src.system.counseling.Counseling;

import java.util.*;

/**
 * @author SW?????????????
 * @version 1.0
 * @created 29-5-2024 ???? 10:34:51
 */


public class Customer {
	private long customerID;
	private String name;
	private String sex;
	private String phoneNumber;
	private String birthDay;

	public Join m_Join;
	public Compensation m_compensation;
	public Counseling m_Counseling;

	private int accidentHistory;
	private Account Account;
	private int joinDate;
	private ArrayList loanInsuranceDetails;
	private ArrayList registeredInsuranceDetails;
	public Account m_Account;
	public Compensation m_Compensation;
	public Accident m_Accident;
	public Loan m_Loan;

	public Customer() {
		super();
	}


	public Customer(long customerID, String name, String sex, String phoneNumber, String birthDay) {
		this.customerID = customerID;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.birthDay = birthDay;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	public void pay(){

	}



	@Override
	public String toString() {
		return "Customer{" +
				"customerID=" + customerID +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", birthDay='" + birthDay + '\'' +
				'}';
	}


	public void finalize() throws Throwable {

	}

}

