package src.system.loan;

import src.system.user.Customer;

/**
 * @author SW�������������
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:55
 */
public class Loan {
    private static long lastID = 0L;

    private String copyOfIdenrificationCard;
    private String incomeProofDocument;
    private long loanID;
    private boolean loanStatus;
    private Customer customer;
    private String rejectionReason;


    public Loan(String copyOfIdenrificationCard, String incomeProofDocument, Customer customer) {
        lastID++;
        this.loanID = lastID;
        this.copyOfIdenrificationCard = copyOfIdenrificationCard;
        this.incomeProofDocument = incomeProofDocument;
        this.customer = customer;
        loanStatus = false;
        rejectionReason = "대출 심사 중입니다.";
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

    public boolean isLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(boolean loanStatus) {
        this.loanStatus = loanStatus;
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