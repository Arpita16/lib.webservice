package daoInterface;

import java.util.List;

import model.Loan;

public interface LoanEjbInt {

	void create(Loan loanItem);

	void delete(Loan loanItem);

	void update(Loan loanItem);

	Loan findById(Long id);

	List<Loan> findByLoan(Loan loan);

	List<Loan> findAll();

}