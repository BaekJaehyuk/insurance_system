package src.system.accident;

public class PropertyDamageAccident extends Accident {
    private String damagedPropertyType;

    public PropertyDamageAccident(long accidentId, String accidentDetails, String date, String location, long customerId, String carNumber, String damagedPropertyType, String assessmentStatus) {
        super(accidentId, accidentDetails, date, location, customerId, carNumber, assessmentStatus);
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
        //System.out.println("Processing property damage accident: " + getAccidentDetails());
    }

    public String getAccidentDetails() {
        return "Accident Details"; // Replace with actual accident details
    }
}
