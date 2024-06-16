package src.system.accident;

public class LiabilityAccident extends Accident {
    private String medicalRecords;
    private int victimInjuryDegree;
    private String victimName;
    private String victimPhoneNumber;

    public LiabilityAccident(long accidentId, String accidentDetails, String date, String location, long customerId, String carNumber, String medicalRecords, int victimInjuryDegree, String victimName, String victimPhoneNumber, String assessmentStatus) {
        super(accidentId, accidentDetails, date, location, customerId, carNumber, assessmentStatus);
        this.medicalRecords = medicalRecords;
        this.victimInjuryDegree = victimInjuryDegree;
        this.victimName = victimName;
        this.victimPhoneNumber = victimPhoneNumber;
    }

    public String getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(String medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public int getVictimInjuryDegree() {
        return victimInjuryDegree;
    }

    public void setVictimInjuryDegree(int victimInjuryDegree) {
        this.victimInjuryDegree = victimInjuryDegree;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public String getVictimPhoneNumber() {
        return victimPhoneNumber;
    }

    public void setVictimPhoneNumber(String victimPhoneNumber) {
        this.victimPhoneNumber = victimPhoneNumber;
    }

    @Override
    public void receiveAccident() {
        // Handle liability accident
    }

    @Override
    public String getType() {
        return "Liability Accident";
    }
}
