package daoInterface;

import java.util.List;

import model.Books;

public interface BooksEjbInt {

	void createbook(Books book);

	List<Books> listBooks();

	List<Books> searchByTitle(String title);

	Books updateById(long id, long ISBN);

	Books findById(Long id);

}