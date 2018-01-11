package library.rest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;




@Stateful
public class LoanEJB {
	


	
	@Inject
	EntityManager em;
	
	public void createloan(Loan loan) {
		em.persist(loan);
	}



	public List<Loan> listLoans() {
		
		TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l", Loan.class);
			   List<Loan> results = query.getResultList();
			   return results;
	}
	
	



public Loan searchById(int loanId) {
	
		  TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan b WHERE l.loanId= :replace", Loan.class);
	  		query.setParameter("replace", loanId);
		   Loan loan= query.getSingleResult();
		   return loan;
	
	}
	
	
public Loan updateById(long loanId, LocalDate newstartdate) {
	Loan loan= findById(loanId);
//	TypedQuery<Books> query = em.createQuery("SELECT b FROM Books b WHERE b.bookId = :update", Books.class);
//	query.setParameter("update",id );
//	Books books  = query.getSingleResult();
	loan.setStartdate(newstartdate);
	
	return loan;



}


public Loan findById(Long loanId) {
	return em.find(Loan.class, loanId);
}
		

public List<Loan> searchByMemberId(int memberId) {
	
	  TypedQuery<Loan> query = em.createQuery("SELECT l FROM loan l WHERE l.memberId= :replace", Loan.class);
	  		query.setParameter("replace", memberId);
		   List<Loan> loan = query.getResultList();
		   return loan;
	
}


}
	
	



