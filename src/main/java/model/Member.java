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


@Entity
public class Member{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long memberId;
	
	String firstName;
	String lastName;
	String address;
	long PhoneNo;
	String email;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="Member_ID")
	private List<Books>book;
	
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




	public Long getMemberId() {
		return memberId;
	}


	public void setMemberId(Long memberId) {
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







}