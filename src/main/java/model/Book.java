package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Book {

		
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookId;
	
	@NotNull
	private String isbn;

	private String title;
	private String genre;
	private String author;

	private int shelfNo;

	@OneToOne(mappedBy="book" ,  cascade = CascadeType.ALL)
	private Loan loan;

	// @OneToMany(cascade=CascadeType.ALL)
	// @JoinColumn(name="Member_ID")
	// private List<BookCopy> bookCopies;
	//

	public Book() {
	}

	public Book(String title, String genre, String author, int shelfNo,String isbn) {

		this.title = title;
		this.genre = genre;
		this.author = author;
		this.shelfNo = shelfNo;
		this.isbn=isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	// public List<BookCopy> getBookCopies() {
	// return bookCopies;
	// }
	//
	// public void setBookCopies(List<BookCopy> bookCopies) {
	// this.bookCopies = bookCopies;
	// }

	public long getbookId() {
		return bookId ;
	}
//
//	public void setbookId(long bookId) {
//		this.bookId = bookId;
//	}

	
	}





