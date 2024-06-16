package src.system.loan;

import java.util.*;


public class LoanListImpl implements LoanList {

    private ArrayList<Loan> loanList;
    public Loan m_Loan;

    public LoanListImpl() {
        this.loanList = new ArrayList<>();
    }

    public void finalize() throws Throwable {

    }


    @Override
    public boolean add(Loan loan) {
        return this.loanList.add(loan);
    }

    @Override
    public boolean delete(long loanId) {
        for (Loan loan : this.loanList) {
            if (loan.getLoanID() == loanId) {
                this.loanList.remove(loan);
                return true;
            }
        }
        return false;
    }

    @Override
    public Loan get(long loanId) {
        for (Loan loan : this.loanList) {
            if (loan.getLoanID() == loanId) {
                return loan;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Loan> get() {
        return loanList;
    }


    @Override
    public boolean update(long loanId, Loan loan) {
        for (Loan prev : this.loanList) {
            if (prev.getLoanID() == loanId) {
                prev.setApprovalLoan(loan.isApprovalLoan());
                prev.setCopyOfIdenrificationCard((loan.getCopyOfIdenrificationCard()));
                prev.setIncomeProofDocument(loan.getIncomeProofDocument());
                prev.setLoanStatus(loan.getLoanStatus());
            }
        }
        return false;
    }
}
