package daoInterface;

import java.util.List;

import model.Book;

public interface BooksEjbInt {

	void createbook(Book book);

	List<Book> listBooks();

	List<Book> searchByTitle(String title);

	Book updateById(long id, String isbn);

	Book findById(Long id);

}