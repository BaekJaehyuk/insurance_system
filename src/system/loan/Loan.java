package src.system.loan;

import src.system.user.Customer;


public class Loan {
    private static long lastID = 0L;

    private String copyOfIdenrificationCard;
    private String incomeProofDocument;
    private long loanID;
    private boolean approvalLoan;
    private Customer customer;
    private String rejectionReason;
    private LoanStatus loanStatus;


    public Loan(String copyOfIdenrificationCard, String incomeProofDocument, Customer customer) {
        lastID++;
        this.loanID = lastID;
        this.copyOfIdenrificationCard = copyOfIdenrificationCard;
        this.incomeProofDocument = incomeProofDocument;
        this.customer = customer;
        approvalLoan = false;
        rejectionReason = "대출 심사 중입니다.";
        this.loanStatus = null;
    }

    public LoanStatus getLoanStatus(){
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getRejectionReason(){
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getCopyOfIdenrificationCard() {
        return copyOfIdenrificationCard;
    }

    public void setCopyOfIdenrificationCard(String copyOfIdenrificationCard) {
        this.copyOfIdenrificationCard = copyOfIdenrificationCard;
    }

    public String getIncomeProofDocument() {
        return incomeProofDocument;
    }

    public void setIncomeProofDocument(String incomeProofDocument) {
        this.incomeProofDocument = incomeProofDocument;
    }

    public long getLoanID() {
        return loanID;
    }

    public void setLoanID(long loanID) {
        this.loanID = loanID;
    }

    public boolean isApprovalLoan() {
        return approvalLoan;
    }

    public void setApprovalLoan(boolean approvalLoan) {
        this.approvalLoan = approvalLoan;
    }

    public void finalize() throws Throwable {

    }


    public void apply() {

    }

    public void execute() {

    }

    public void judge() {

    }

    public void redeem() {

    }

    @Override
    public String toString() {
        return "[ " + loanID + " ]" + '\n' +
                "고객 ID: " + customer.getCustomerID() + '\n' +
                "이름: " + customer.getName() + '\n' +
                "전화번호: " + customer.getPhoneNumber() + '\n' +
                "신분증 사본: " + copyOfIdenrificationCard + '\n' +
                "소득 증빙 서류: " + incomeProofDocument + '\n' +
                "----------------------------------------------------";
    }

}
