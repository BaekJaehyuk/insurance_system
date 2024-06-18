package src.system.user;


public class Account {

    private String accountNumber;
    private String bankName;
    private String depositor;

    public Account(String accountNumber, String bankName, String depositor) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.depositor = depositor;
    }


    @Override
    public String toString() {
        return "계좌번호:" + accountNumber + '\n' +
                "은행: " + bankName + '\n' +
                "계좌주: " + depositor + '\n';
    }

    public void finalize() throws Throwable {

    }

}
