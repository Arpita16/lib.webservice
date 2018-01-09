package library.rest;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Books {

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long ISBN;
	
	@NotNull
	int bookId;	
	
	String title;
	String genre;
	int shelfNo;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name="Loan_ID")
	 private Loan loan;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Book_Id")
	private List<Books> books;
	
	

	
	public Books() {}
	
	public Books(int bookId,String title, String genre, int shelfNo) {
		super();
		this.bookId=bookId;
		this.title = title;
		this.genre = genre;
		this.shelfNo = shelfNo;
		
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

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getShelfNo() {
		return shelfNo;
	}

	public void setShelfNo(int shelfNo) {
		this.shelfNo = shelfNo;
	}

	public int getbookId() {
		return bookId;
	}

	public void setbookId(int bookId) {
		this.bookId = bookId;
	}






}

