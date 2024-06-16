package src.system.user;

import src.system.*;
import src.system.accident.Accident;
import src.system.compensation.Compensation;
import src.system.counseling.Counseling;
import src.system.loan.Loan;

import java.util.*;

public class Customer {

	private static long lastID = 0L;

	private long customerID;
	private String name;
	private String sex;
	private String phoneNumber;
	private String birthDay;
	private ArrayList<Long> productList;
	private int drivingExperience;
	public Join m_Join;
	public Compensation m_compensation;
	public Counseling m_Counseling;

	private int accidentHistory;
	private Account account;
	private int joinDate;
	private ArrayList<String> loanInsuranceDetails;
	private ArrayList<Insurance> insuranceList;

	public Compensation m_Compensation;
	public Accident m_Accident;
	private Loan loan;

	public Customer() {
		this.productList = new ArrayList<>();
		this.insuranceList = new ArrayList<>();
	}

	public Customer(String name, String sex, String phoneNumber, String birthDay, int drivingExperience) {
		lastID++;
		this.customerID = lastID;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.birthDay = birthDay;
		this.productList = new ArrayList<>();
		this.insuranceList = new ArrayList<>();
		this.drivingExperience = drivingExperience;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public int getDrivingExperience() {
		return drivingExperience;
	}

	public void setDrivingExperience(int drivingExperience) {
		this.drivingExperience = drivingExperience;
	}

	public Account getAccount(){
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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

	public ArrayList<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void addInsurance(Insurance insurance) {
		this.insuranceList.add(insurance);
	}

	public void pay(Insurance insurance){
		insurance.setPaymentStatus("O");
		insurance.getInsuranceFee().setDateOfPayment(new Date());
	}

	@Override
	public String toString() {
		return "Customer{" +
				"customerID=" + customerID +
				", name='" + name + '\'' +
				", sex='" + sex + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", birthDay='" + birthDay + '\'' +
				", Account='" + account + '\'' +
				'}';
	}

	public void finalize() throws Throwable {

	}
}
