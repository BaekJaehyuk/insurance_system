package src.system.accident;

public class PropertyDamageAccident extends Accident {
    private String damagedPropertyType;

    public PropertyDamageAccident(long accidentId, String accidentDetails, String date, String location, long customerId, String damagedPropertyType, String assessmentStatus) {
        super(accidentId, accidentDetails, date, location, customerId, assessmentStatus);
        this.damagedPropertyType = damagedPropertyType;
    }

    public String getDamagedPropertyType() {
        return damagedPropertyType;
    }

    public void setDamagedPropertyType(String damagedPropertyType) {
        this.damagedPropertyType = damagedPropertyType;
    }

    @Override
    public void receiveAccident() {
        System.out.println("Processing property damage accident: " + accidentDetails);
    }
}
