package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Loan;

@Stateless
public class LoanEJB {

	
	@Inject
	EntityManager em;
	
	 public void create(Loan loanItem) {
	       em.persist(loanItem);
	    }
	 public void delete(Loan loanItem) {
	        em.remove(loanItem);
	    }

	    public void update(Loan loanItem) {
	        em.merge(loanItem);
	    }

	
	    public Loan findById(Long id) {
	        return em.find(Loan.class, id);
	    }

	
	    public List<Loan> findByLoan(Loan loan) {
	        return em.createQuery("SELECT l FROM LoanItem l WHERE l.loan = :loanid", Loan.class)
	                                                                    .setParameter("loanid", loan)
	                                                                    .getResultList();
	    }

	   
	    public List<Loan> findAll() {
	        return em.createQuery("select l from LoanItem l", Loan.class).getResultList();
	    }
}
