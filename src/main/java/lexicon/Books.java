package lexicon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long ISBN;
	
	String title;
	String genre;
	int shelfNo;
	int numberOfcopies;
	
	public Books() {}
	
	public Books(String title, String genre, int shelfNo, int numberOfcopies) {
		super();
		this.title = title;
		this.genre = genre;
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

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getShelfNo() {
		return shelfNo;
	}

	public void setShelfNo(int shelfNo) {
		this.shelfNo = shelfNo;
	}

	






}

