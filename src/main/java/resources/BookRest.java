package resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import daoInterface.BooksEjbInt;
import model.Books;


@Path("/books")
@RequestScoped
public class BookRest {
	
	@Inject
	BooksEjbInt booksService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBooks() {
		return Response.ok(booksService.listBooks()).build();
	}
	
	@POST
	@Path("/new/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createBooks(Books books) throws URISyntaxException {
		booksService.createbook(books);
		return Response.created(new URI("localhost:8080/webservice/rest/books")).build();
	}
	
	@GET
	@Path("/title/{title}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchTitle(@PathParam("title") String title) throws URISyntaxException {
		return Response.ok(booksService.searchByTitle(title)).build();
	}
	
	@PUT
	@Path("/updateisbn/{bookId}/{isbn}/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateId(@PathParam("bookId")long bookId, @PathParam("isbn")long isbn) throws URISyntaxException {
//		Response.created(new URI("localhost:8080/webservice/rest/books/"+bookId+"/"+isbn)).build();
		return Response.ok(booksService.updateById(bookId, isbn)).build();
		
	}
}

	




