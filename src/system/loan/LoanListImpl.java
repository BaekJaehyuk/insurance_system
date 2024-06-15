package src.system.loan;

import java.util.*;

/**
 * @author tiemo
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:55
 */
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
                prev.setLoanStatus(loan.isLoanStatus());
                prev.setCopyOfIdenrificationCard((loan.getCopyOfIdenrificationCard()));
                prev.setIncomeProofDocument(loan.getIncomeProofDocument());
            }
        }
        return false;
    }
}