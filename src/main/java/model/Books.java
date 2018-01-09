package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	int shelfNo;
	int numberOfcopies;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="loan_ID")
	private Loan loan;
		
	public Books() {}
	
	public Books(String title, String gener, int shelfNo, int numberOfcopies) {
		this.title = title;
		this.genre = gener;
		this.shelfNo = shelfNo;
		this.numberOfcopies = numberOfcopies;
	}


public int getNumberOfcopies() {
		return numberOfcopies;
	}

	public void setNumberOfcopies(int numberOfcopies) {
		this.numberOfcopies = numberOfcopies;
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

	






}

