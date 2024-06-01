package src.system.accident;

public abstract class Accident {
	protected int accidentId;
	protected String accidentDetails;
	protected String date;
	protected String location;
	protected int memberId;

	public Accident(int accidentId, String accidentDetails, String date, String location, int memberId) {
		this.accidentId = accidentId;
		this.accidentDetails = accidentDetails;
		this.date = date;
		this.location = location;
		this.memberId = memberId;
	}

	// 공통 메서드
	public abstract void receiveAccident();
}
