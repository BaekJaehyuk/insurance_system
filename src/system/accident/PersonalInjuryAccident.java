package src.system.accident;

public class PersonalInjuryAccident extends Accident {
    private int injuryDegree;
    private int vehicleDamageDegree;
    private String medicalReceipt;
    private String repairReceipt;

    public PersonalInjuryAccident(long accidentId, String accidentDetails, String date, String location, long customerId, String carNumber, int injuryDegree, int vehicleDamageDegree, String medicalReceipt, String repairReceipt, String assessmentStatus) {
        super(accidentId, accidentDetails, date, location, customerId, carNumber, assessmentStatus);
        this.injuryDegree = injuryDegree;
        this.vehicleDamageDegree = vehicleDamageDegree;
        this.medicalReceipt = medicalReceipt;
        this.repairReceipt = repairReceipt;
    }

    public int getInjuryDegree() {
        return injuryDegree;
    }

    public void setInjuryDegree(int injuryDegree) {
        this.injuryDegree = injuryDegree;
    }

    public int getVehicleDamageDegree() {
        return vehicleDamageDegree;
    }

    public void setVehicleDamageDegree(int vehicleDamageDegree) {
        this.vehicleDamageDegree = vehicleDamageDegree;
    }

    public String getMedicalReceipt() {
        return medicalReceipt;
    }

    public void setMedicalReceipt(String medicalReceipt) {
        this.medicalReceipt = medicalReceipt;
    }

    public String getRepairReceipt() {
        return repairReceipt;
    }

    public void setRepairReceipt(String repairReceipt) {
        this.repairReceipt = repairReceipt;
    }

    @Override
    public void receiveAccident() {
        // Handle personal injury accident
    }

    @Override
    public String getType() {
        return "대인배상";
    }

    public String personalInjuryAccidentDetail() {
        return "접수날짜: " + date + "\n" +
                "고객ID: " + customerId + "\n" +
                "사고 위치: " + location + "\n" +
                "사고 설명: " + accidentDetails + "\n" +
                "차량 번호: " + assessmentStatus + "\n" +
                "부상정도(1~10): " + injuryDegree+ "\n" +
                "차량피해정도(1~10): " + vehicleDamageDegree+ "\n" +
                "의료 손해액: " + medicalReceipt +  "\n"+
                "처량수리 손해액: " + repairReceipt +  "\n";
    }
}
