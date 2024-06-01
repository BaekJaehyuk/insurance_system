package src.system.accident;

public class LiabilityAccident extends Accident { //대인배상
    private String medicalRecords;
    private int victimInjuryDegree;
    private String victimName;
    private String victimPhoneNumber;

    public LiabilityAccident(int accidentId, String accidentDetails, String date, String location, int memberId, String medicalRecords, int victimInjuryDegree, String victimName, String victimPhoneNumber) {
        super(accidentId, accidentDetails, date, location, memberId);
        this.medicalRecords = medicalRecords;
        this.victimInjuryDegree = victimInjuryDegree;
        this.victimName = victimName;
        this.victimPhoneNumber = victimPhoneNumber;
    }

    @Override
    public void receiveAccident() {
        System.out.println("Processing liability accident: " + accidentDetails);
        // Liability specific processing code here
    }
}
