package src.system.counseling;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SW개발자
 * @version 1.0
 * @created 29-5-2024 오전 10:34:51
 */
// Counseling.java
public class Counseling {
	private int customerID;
	private int employeeID;
	private String title;
	private String content;
	private CounsellingStatus status;

	public Counseling(int customerID, int employeeID, String title, String content) {
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.title = title;
		this.content = content;
		this.status = CounsellingStatus.REQUESTED;
	}

	public void confirm() {
		this.status = CounsellingStatus.CONFIRMED;
	}

	public void complete() {
		this.status = CounsellingStatus.COMPLETED;
	}

	public void cancel() {
		this.status = CounsellingStatus.CANCELLED;
	}

	public int getCustomerID() {
		return customerID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public CounsellingStatus getStatus() {
		return status;
	}
}

