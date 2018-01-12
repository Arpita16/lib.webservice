package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Member{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int memberId;
	
	private String firstName;
	private String lastName;
	private String address;
	private long PhoneNo;
	private String email;
	
	/**One Member can have many books created this join just to find out which member is having which book**/
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_ID")
	private List<Book>book;
	
	/**One member can have many loans**/
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_ID")
	private List<Loan>loan;
	
	
	public Member() {}
	
	public Member(String firstName, String lastName, String address, long phoneNo, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.PhoneNo = phoneNo;
		this.email = email;
	}






	public String getEmail() {
		return email;
	}

   public void setEmail(String email) {
		this.email = email;
	}




	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhoneNo() {
		return PhoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		PhoneNo = phoneNo;
	}

       	public List<Books> getBook() {
		return book;
	}

	public void setBook(List<Books> book) {
		this.book = book;
	}

	public List<Loan> getLoan() {
		return loan;
	}

	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}





}
