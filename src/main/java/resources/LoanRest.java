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

import daoInterface.LoanEjbInt;
import model.Loan;


@Path("/loan")
@RequestScoped
public class LoanRest {
	

	    @Inject
		LoanEjbInt loanService;
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getLoan() {
			return Response.ok(loanService.findAll()).build();
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createLoan(Loan loan) throws URISyntaxException {
			loanService.create(loan);
			return Response.created(new URI("localhost:8080/webservice/rest/loan")).build();
		}
		
		@GET
		@Path("/{loanId}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchLoanId(@PathParam("loanId") long loanId) throws URISyntaxException {
			return Response.ok(loanService.findById(loanId)).build();
		}
		
		@PUT
		@Path("/{loanId}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateInfo(@PathParam("loanId")long loanId) throws URISyntaxException {
			 loanService.updateById(loanId);
			 return Response.created(new URI("localhost:8080/webservice/rest/loan/"+loanId)).build();
			
		}
		

	
	
	
	
	
	

}
