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
        // Handle property damage accident
    }

    @Override
    public String getType() {
        return "Property Damage Accident";
    }

    public String propertyDamageAccidentDetail() {
        return "접수날짜: " + date + "\n" +
                "고객ID: " + customerId + "\n" +
                "사고 위치: " + location + "\n" +
                "사고 설명: " + accidentDetails + "\n" +
                "차량 번호: " + assessmentStatus + "\n" +
                "피해재산종류: " + damagedPropertyType+ "\n" +
                "사고현장사진: " + accidentPhotoUrl +  "\n"+
                "재산 손해액: " + receiptUrl +  "\n";
    }
}
