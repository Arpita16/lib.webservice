package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import daoInterface.LoanEjbInt;
import model.Books;
import model.Loan;

@Stateless
public class LoanEJB implements LoanEjbInt {


	@Inject
	EntityManager em;

	@Override
	public void create(Loan loanItem) {
		em.persist(loanItem);
	}

	@Override
	public void delete(Loan loanItem) {
		em.remove(loanItem);
	}



	@Override
	public Loan findById(Long id) {
		return em.find(Loan.class, id);
	}



	@Override
	public List<Loan> findByLoan(Loan loan) {
		return em.createQuery("SELECT l FROM Loan l WHERE l.loan = :loanid", Loan.class)
				.setParameter("loanid", loan)
				.getResultList();
	}


	@Override
	public List<Loan> findAll() {
		TypedQuery<Loan> query = em.createQuery("select l from Loan l", Loan.class);
		List<Loan> results = query.getResultList();
		return results;
	}

	@Override
	public void updateById(long loanId) {
		em.merge(loanId);
	}
}
