package library.rest;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Loan {
	
	
	@Column(name="Loan_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int loanId;
	
	@NotNull
	LocalDate startdate;
	
	
	LocalDate endDate;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Book_Id")
	private List<Books> books;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Book_Id")
	private Books book;
	
	
	
	
	
	
	public Loan() {}
	
	
  public Loan(LocalDate startdate, LocalDate endDate) {
		super();
		this.startdate = startdate;
		this.endDate = endDate;
	}




	public int getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}


	public LocalDate getStartdate() {
		return startdate;
	}


	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}


	public LocalDate getEndDate() {
		return startdate.plusMonths(2);
		
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
	
	
}
