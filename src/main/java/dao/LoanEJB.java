package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import daoInterface.LoanEjbInt;
import model.Loan;

@Stateless
public class LoanEJB implements LoanEjbInt {


	@Inject
	EntityManager em;

	@Override
	public void create(Loan loan) {
		em.persist(loan);
	}

	@Override
	public void delete(Loan loan) {
		em.remove(loan);
	}


	@Override
	public void update(Long id) {
		em.merge(id);
	}



	@Override
	public Loan findById(Long id) {
		return em.find(Loan.class, id);
	}



	@Override
	public List<Loan> findByLoan(Loan loan) {
		return em.createQuery("SELECT l FROM LoanItem l WHERE l.loan = :loanid", Loan.class)
				.setParameter("loanid", loan)
				.getResultList();
	}


	@Override
	public List<Loan> findAll() {
		return em.createQuery("select l from LoanItem l", Loan.class).getResultList();
	}
}
