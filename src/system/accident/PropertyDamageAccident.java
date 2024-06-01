package src.system.accident;

public class PropertyDamageAccident extends Accident { //대물배상
    private String damagedPropertyType;

    public PropertyDamageAccident(int accidentId, String accidentDetails, String date, String location, int memberId, String damagedPropertyType) {
        super(accidentId, accidentDetails, date, location, memberId);
        this.damagedPropertyType = damagedPropertyType;
    }

    @Override
    public void receiveAccident() {
        System.out.println("Processing property damage accident: " + accidentDetails);
        // Property damage specific processing code here
    }
}
