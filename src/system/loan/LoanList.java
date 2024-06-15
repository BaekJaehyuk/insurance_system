package src.system.loan;


import java.util.ArrayList;

public interface LoanList {

	public boolean add(Loan loan);

	public boolean delete(long loanId);

	public Loan get(long loanId);

	public ArrayList<Loan> get();

	public boolean update(long loanId, Loan loan);


}
