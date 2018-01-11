package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookCopy {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private boolean loanable;

	@Enumerated(EnumType.STRING)
	private BookCopyStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "BookId")
    private Book book;

}
