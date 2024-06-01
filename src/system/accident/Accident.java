package src.system.accident;

/**
 * @author SW
 * @version 1.0
 * @created 29-5-2024
 */
public class Accident {

	private int accidentId; // 사고 ID
	private int accidentDetails;
	private int billingCost;
	private int date;
	private String fieldPhoto;
	private int injuryDegree;
	private int location;
	private int medicalRecords;
	private int memberID;
	private int time;
	private int typeOfPropertyDamaged;
	private int victimInjuryDegree;
	private String victimName;
	private String victimPhoneNumber;
	private int vehicleDamageDegree;

	public Accident(int accidentId, int accidentDetails, int billingCost, int date, String fieldPhoto, int injuryDegree,
					int location, int medicalRecords, int memberID, int time, int typeOfPropertyDamaged,
					int victimInjuryDegree, String victimName, String victimPhoneNumber, int vehicleDamageDegree) {
		this.accidentId = accidentId;
		this.accidentDetails = accidentDetails;
		this.billingCost = billingCost;
		this.date = date;
		this.fieldPhoto = fieldPhoto;
		this.injuryDegree = injuryDegree;
		this.location = location;
		this.medicalRecords = medicalRecords;
		this.memberID = memberID;
		this.time = time;
		this.typeOfPropertyDamaged = typeOfPropertyDamaged;
		this.victimInjuryDegree = victimInjuryDegree;
		this.victimName = victimName;
		this.victimPhoneNumber = victimPhoneNumber;
		this.vehicleDamageDegree = vehicleDamageDegree;
	}

	public int getAccidentId() {
		return accidentId;
	}

	public void finalize() throws Throwable {

	}

	public void request() {

	}

	// Getters and Setters
}
