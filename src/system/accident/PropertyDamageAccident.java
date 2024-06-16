package src.system.accident;

public class PropertyDamageAccident extends Accident {
    private String damagedPropertyType;
    private String accidentPhotoUrl;
    private String receiptUrl;

    public PropertyDamageAccident(long accidentId, String accidentDetails, String date, String location, long customerId, String carNumber, String damagedPropertyType, String accidentPhotoUrl, String receiptUrl, String assessmentStatus) {
        super(accidentId, accidentDetails, date, location, customerId, carNumber, assessmentStatus);
        this.damagedPropertyType = damagedPropertyType;
        this.accidentPhotoUrl = accidentPhotoUrl;
        this.receiptUrl = receiptUrl;
    }

    public String getDamagedPropertyType() {
        return damagedPropertyType;
    }

    public void setDamagedPropertyType(String damagedPropertyType) {
        this.damagedPropertyType = damagedPropertyType;
    }

    public String getAccidentPhotoUrl() {
        return accidentPhotoUrl;
    }

    public void setAccidentPhotoUrl(String accidentPhotoUrl) {
        this.accidentPhotoUrl = accidentPhotoUrl;
    }

    public String getReceiptUrl() {
        return receiptUrl;
    }

    public void setReceiptUrl(String receiptUrl) {
        this.receiptUrl = receiptUrl;
    }

    @Override
    public void receiveAccident() {
        System.out.println("대물배상 사고를 처리 중입니다: " + getAccidentDetails());
    }
}
