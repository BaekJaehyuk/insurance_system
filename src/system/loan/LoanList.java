package src.system.loan;

import src.system.user.Customer;

import java.util.ArrayList;

/**
 * @author tiemo
 * @version 1.0
 * @created 29-5-2024 ���� 10:34:55
 */
public interface LoanList {

	public boolean add(Loan loan);

	public boolean delete(long loanId);

	public Loan get(long loanId);

	public ArrayList<Loan> get();

	public boolean update(long loanId, Loan loan);


}