package src.system.user;

import src.system.*;
import src.system.accident.Accident;
import java.util.*;


public class Customer {

	private static long lastID = 0L;

	private long customerID;
	private String name;
	private String sex;
	private String phoneNumber;
	private String birthDay;
	private ArrayList<Long> productList;

	public Join m_Join;
	public Compensation m_compensation;
	public Counseling m_Counseling;

	private int accidentHistory;
	private Account Account;
	private int joinDate;
	private ArrayList<String> loanInsuranceDetails;
	private ArrayList<String> registeredInsuranceDetails;

	public Account m_Account;
	public Compensation m_Compensation;
	public Accident m_Accident;
	public Loan m_Loan;

	public Customer() {

	}

	public Customer(String name, String sex, String phoneNumber, String birthDay) {
		lastID++;
		this.customerID = lastID;
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

	public void addProduct(Long productId) {
		this.productList.add(productId);
	}

	public void pay(Long productId){
		//여기서 가입한 보험을 꺼낸다.
		//꺼낸 보험의 insuranceFee를 get해온다.
		//보험료를 지불한다.
		//납부일을 기록한다.

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

