package src.system.accident;

public abstract class Accident {
    protected long accidentId;
    protected String accidentDetails;
    protected String date;
    protected String location;
    protected long customerId;
    protected String assessmentStatus;
    protected String status;

    public long getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(long accidentId) {
        this.accidentId = accidentId;
    }

    public String getAccidentDetails() {
        return accidentDetails;
    }

    public void setAccidentDetails(String accidentDetails) {
        this.accidentDetails = accidentDetails;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getAssessmentStatus() {
        return assessmentStatus;
    }

    public void setAssessmentStatus(String assessmentStatus) {
        this.assessmentStatus = assessmentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Accident(long accidentId, String accidentDetails, String date, String location, long customerId, String assessmentStatus, String status) {
        this.accidentId = accidentId;
        this.accidentDetails = accidentDetails;
        this.date = date;
        this.location = location;
        this.customerId = customerId;
        this.assessmentStatus = assessmentStatus;
        this.status = "Pending";
    }

    // Abstract method for receiving accident
    public abstract void receiveAccident();

    @Override
    public String toString() {
        return "[ " + accidentId + " ]\n" +
                "접수 날짜: " + date + "\n" +
                "고객ID: " + customerId + "\n";
    }


    // Abstract method to get the type of accident
    public abstract String getType();
}
