package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import daoInterface.BooksEjbInt;
import model.Book;

@Stateless
public class BooksEJB implements BooksEjbInt {

	@Inject
	EntityManager em;

	
	@Override
	public void createbook(Book book) {
		em.persist(book);
	}



	@Override
	public List<Book> listBooks() {

		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
		List<Book> results = query.getResultList();
		return results;
	}



	
	@Override
	public List<Book> searchByTitle(String title) {

		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :replace", Book.class);
		query.setParameter("replace", title+"%");
		List<Book> books= query.getResultList();
		return books;

	}


	@Override
	public Book updateById(long id, String newisbn) {
		Book book = findById(id);
//		TypedQuery<Books> query = em.createQuery("SELECT b FROM Books b WHERE b.bookId = :update", Books.class);
//		query.setParameter("update",id );
//		Books books  = query.getSingleResult();
		book.setIsbn(newisbn);
		em.merge(book);
		return book;



	}

	
	@Override
	public Book findById(Long bookId) {
		return em.find(Book.class, bookId);
	}


}
