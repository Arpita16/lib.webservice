package daoInterface;

import java.util.List;

import model.Books;

public interface BooksEjbInt {

	void createbook(Books book);

	List<Books> listBooks();

	Books searchByTitle(String title);

	Books updateById(long ISBN);

	Books findById(Long id);

}