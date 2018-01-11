package library.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Date;
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


@Path("/loan")
@RequestScoped
public class LoanRest {
	

	    @Inject
		LoanEJB loanService;
		
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getLoan() {
			return Response.ok(loanService.listLoans()).build();
		}
		
		@POST
		@Path("/{new}/")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createLoan(Loan loan) throws URISyntaxException {
			loanService.createloan(loan);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/loan")).build();
		}
		
		@GET
		@Path("/{loanId}/{loanId}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchLoanId(@PathParam("loanId") int loanId) throws URISyntaxException {
			Loan loan = loanService.searchById(loanId);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/loan/"+loanId)).build();
		}
		
		@PUT
		@Path("/updatestartdate/{loanId}/{newstartdate}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response updateByloanId(@PathParam("loanId")int loanId,LocalDate startdate) throws URISyntaxException {
			 Loan loan =loanService.updateById(loanId,startdate);
			 return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/loan/"+loanId)).build();
			
		}
		
		@GET
		@Path("/{memberId}/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response searchMember(@PathParam("memberId") int memberId) throws URISyntaxException {
			List<Loan> loan = loanService.searchByMemberId(memberId);
			return Response.created(new URI("localhost:8080/jboss-javaee-webapp/rest/member/"+memberId)).build();
		}
	
	
	
	
	
	

}
