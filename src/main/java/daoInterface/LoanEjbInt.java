package daoInterface;

import java.util.List;

import model.Loan;

public interface LoanEjbInt {

	void create(Loan loanItem);

	void delete(Loan loanItem);

	void updateById(long loanId);

	Loan findById(Long id);

	List<Loan> findByLoan(Loan loan);

	List<Loan> findAll();

}