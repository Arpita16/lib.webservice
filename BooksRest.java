package library.rest;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





	
	
	@Path("/books")
	@RequestScoped
	public class BooksRest {
		
		@Inject
		BooksEJB booksService;
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getBooks() {
			return Response.ok(booksService.listBooks()).build();
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createBooks(Books books) throws URISyntaxException {
			booksService.createbook(books);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/books")).build();
		}
		
		@GET
		@Path("/{title}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchTitle(@PathParam("title") String title) throws URISyntaxException {
			List<Books> books = booksService.searchByTitle(title);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/books/"+title)).build();
		}
		
		@PUT
		@Path("/{bookId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateId(@PathParam("bookId")int bookId) throws URISyntaxException {
			List<Books> books = booksService.updateById(bookId);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/books/"+bookId)).build();
			
		}
	}

		

	
	


