package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Books {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long ISBN;
	
	String title;
	String genre;
	private String author;

	int shelfNo;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loan_ID")
	private Loan loan;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_ID")
    private List<BookCopy> bookCopies;
		
	
	public Books() {}
	
	

public Books(long iSBN, String title, String genre, String author, int shelfNo, Loan loan,
			List<BookCopy> bookCopies) {
		
		ISBN = iSBN;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.shelfNo = shelfNo;
		this.loan = loan;
		this.bookCopies = bookCopies;
	}


		
	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String gener) {
		this.genre = gener;
	}

	public int getShelfNo() {
		return shelfNo;
	}

	public void setShelfNo(int shelfNo) {
		this.shelfNo = shelfNo;
	}

	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}






}

