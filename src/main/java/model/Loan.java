package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long loanId;
	
	private Date startdate;
	private Date endDate;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="book_ID")
	private Books book;
	
	public Loan() {}
	
	
  public Loan(Date startdate, Date endDate) {
		super();
		this.startdate = startdate;
		this.endDate = endDate;
	}




	public long getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
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
