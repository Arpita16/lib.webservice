package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import daoInterface.BooksEjbInt;
import model.Books;

@Stateless
public class BooksEJB implements BooksEjbInt {

	@Inject
	EntityManager em;

	
	@Override
	public void createbook(Books book) {
		em.persist(book);
	}



	@Override
	public List<Books> listBooks() {

		TypedQuery<Books> query = em.createQuery("SELECT b FROM Books b", Books.class);
		List<Books> results = query.getResultList();
		return results;
	}



	
	@Override
	public List<Books> searchByTitle(String title) {

		TypedQuery<Books> query = em.createQuery("SELECT b FROM Books b WHERE b.title LIKE :replace", Books.class);
		query.setParameter("replace", title+"%");
		List<Books> books= query.getResultList();
		return books;

	}


	@Override
	public Books updateById(long ISBN) {
		TypedQuery<Books> query = em.createQuery("SELECT b FROM Books b WHERE b.title= :update", Books.class);
		query.setParameter("update",ISBN );
		Books books  = query.getSingleResult();
		return books;



	}

	
	@Override
	public Books findById(Long id) {
		return em.find(Books.class, id);
	}


}
