package src.system;

import java.util.ArrayList;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:53
 */
public class Employee {

	private long employeeID;
	private String id;
	private String password;
	private String name;
	private String sex;
	private String phoneNumber;
	private String department;
	private String enteringDate;

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

	public Employee(int employeeID, String id, String password, String name, String sex, String phoneNumber, String department, String enteringDate) {
		this.employeeID = employeeID;
		this.id = id;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.department = department;
		this.enteringDate = enteringDate;
	}

	public long getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEnteringDate() {
		return enteringDate;
	}

	public void setEnteringDate(String enteringDate) {
		this.enteringDate = enteringDate;
	}

	public Employee(){

	}

	public void finalize() throws Throwable {

	}

	public void toAssessDamages(){

	}

	public void toSettleAccounts(){

	}

}