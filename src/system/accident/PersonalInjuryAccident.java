package src.system.accident;

public class PersonalInjuryAccident extends Accident { //본인상해
    private int injuryDegree;
    private int vehicleDamageDegree;

    public PersonalInjuryAccident(int accidentId, String accidentDetails, String date, String location, int memberId, int injuryDegree, int vehicleDamageDegree) {
        super(accidentId, accidentDetails, date, location, memberId);
        this.injuryDegree = injuryDegree;
        this.vehicleDamageDegree = vehicleDamageDegree;
    }

    @Override
    public void receiveAccident() {
        System.out.println("Processing personal injury accident: " + accidentDetails);
        // Personal injury specific processing code here
    }
}
