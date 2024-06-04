package src.system.accident;

public abstract class Accident {
	protected long accidentId;
	protected String accidentDetails;
	protected String date;
	protected String location;
	protected long customerId;

	public long getAccidentId() {
		return accidentId;
	}

	public void setAccidentId(long accidentId) {
		this.accidentId = accidentId;
	}

	public String getAccidentDetails() {
		return accidentDetails;
	}

	public void setAccidentDetails(String accidentDetails) {
		this.accidentDetails = accidentDetails;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Accident(long accidentId, String accidentDetails, String date, String location, long customerId) {
		this.accidentId = accidentId;
		this.accidentDetails = accidentDetails;
		this.date = date;
		this.location = location;
		this.customerId = customerId;
	}

	// 공통 메서드
	public abstract void receiveAccident();

	@Override
	public String toString() {
		return "Accident{" +
				"accidentId=" + accidentId +
				", accidentDetails='" + accidentDetails + '\'' +
				", date='" + date + '\'' +
				", location='" + location + '\'' +
				", customerId='" + customerId + '\'' +
				'}';
	}

}
