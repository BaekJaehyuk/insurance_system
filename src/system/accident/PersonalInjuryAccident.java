package src.system.accident;

public class PersonalInjuryAccident extends Accident {
    private int injuryDegree;
    private int vehicleDamageDegree;

    public PersonalInjuryAccident(long accidentId, String accidentDetails, String date, String location, long customerId, int injuryDegree, int vehicleDamageDegree, String assessmentStatus) {
        super(accidentId, accidentDetails, date, location, customerId, assessmentStatus);
        this.injuryDegree = injuryDegree;
        this.vehicleDamageDegree = vehicleDamageDegree;
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

    @Override
    public void receiveAccident() {
        System.out.println("Processing personal injury accident: " + accidentDetails);
    }
}
