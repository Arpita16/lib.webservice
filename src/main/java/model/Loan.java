package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long loanId;
	private int loanPeriod;
	
	private Date startdate;
	private Date endDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="book_ID")
	private Books book;
	
	public Loan() {}
	
	
  public Loan(Date startdate, Date endDate) {
		
		this.startdate = startdate;
		this.endDate = endDate;
	}
  
//  public double calcLoanFinedAmount(Date returnDate) {
//      if (returnDate == null) returnDate = new Date();
//      return getDeadlineOfReturning().before(returnDate) ? 0.2 * (returnDate.getTime() - getDeadlineOfReturning().getTime()) / 86400000 : 0;
//  }




	public Long getLoanId() {
		return loanId;
	}


	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
