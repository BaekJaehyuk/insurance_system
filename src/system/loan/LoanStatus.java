package src.system.loan;

public class LoanStatus {

    private long capacity; // 한도
    private double interestRate; // 이자율
    private long loanPrincipal; // 대출원금

    private long loanBalance; // 대출잔액
    private int loanTerm; // 대출기간 (상환기간)
    private int repaymentSchedule; // 상환 일정 (매달 n일 (n<=28))

    private int repaymentPeriod; // 상환회차


    public LoanStatus(long capacity, long loanPrincipal, double interestRate, int loanTerm, int repaymentSchedule) {
        this.capacity = capacity;
        this.loanPrincipal = loanPrincipal;
        this.interestRate = interestRate;
        this.loanBalance = calculateTotalPayment(loanPrincipal, loanTerm);
        this.loanTerm = loanTerm;
        this.repaymentSchedule = repaymentSchedule;
        this.repaymentPeriod = 0;
    }

    public int getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(int repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }


    public long getLoanPrincipal() {
        return loanPrincipal;
    }

    public void setLoanPrincipal(int loanPrincipal) {
        this.loanPrincipal = loanPrincipal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public long getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(long loanBalance) {
        this.loanBalance = loanBalance;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public int getRepaymentSchedule() {
        return repaymentSchedule;
    }

    public void setRepaymentSchedule(int repaymentSchedule) {
        this.repaymentSchedule = repaymentSchedule;
    }


    public long calculateTotalPayment(long loanPrincipal, int loanTerm) {
        return calculateMonthlyPayment(loanPrincipal, loanTerm) * loanTerm;
    }

    public long calculateMonthlyPayment(long loanPrincipal, int loanTerm) {
        double monthlyPayment = (loanPrincipal * (interestRate / 12)) / (1 - Math.pow(1 + (interestRate / 12), -loanTerm));
        return Math.round(monthlyPayment);
    }

    public long getMonthlyPayment(){
        return calculateMonthlyPayment(loanPrincipal, loanTerm);
    }

    @Override
    public String toString() {
        return "-------------------[ 대출 정보 조회 ]------------------" + '\n' +
                "대출원금: " + loanPrincipal + "원\n" +
                "이자율: " + interestRate + "%\n" +
                "대출잔액: " + loanBalance + "원\n" +
                "대출기간: " + loanTerm + "개월\n" +
                "상환일정: 매월 " + repaymentSchedule + "일\n" +
                "월 상환금액: " + getMonthlyPayment() + "원\n" +
                "----------------------------------------------------";
    }

    public void finalize() throws Throwable {

    }

}
