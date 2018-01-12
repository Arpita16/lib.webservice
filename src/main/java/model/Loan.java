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

	/**One Loan can have many books with @OneToMany we represented this**/
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Book_Id")
	private List<Books> books;
	
	/**One Loan can have only One Member with @OneToOne we represented this**/
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_Id")
	private Member member;
	
	public Loan() {}
	
	
  public Loan(Date startdate, Date endDate) {
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


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEndDate() {
		return startdate.plusMonths(2);
		
	}


	public List<Books> getBooks() {
		return books;
	}


	public void setBooks(List<Books> books) {
		this.books = books;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
