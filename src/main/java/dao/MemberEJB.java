package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import daoInterface.MemberEjbInt;
import model.Member;



@Stateless
public class MemberEJB implements MemberEjbInt {
	
	@Inject
	EntityManager em;
	
	/**simple function to create member**/
	@Override
	public void createMember(Member member) {
		em.persist(member);
	}


        /**simple function to get list of members**/
	@Override
	public List<Member> listMembers() {
		
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
			   List<Member> results = query.getResultList();
			   return results;
	}


         /**simple function to get list of members through last name**/
	@Override
	public List<Member> searchByLastName(String name) {
		
		  TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.lastName LIKE :replace", Member.class);
		  		query.setParameter("replace", name);
			   List<Member> member = query.getResultList();
			   return member;
		
	}
	
	
	@Override
	public Member updateById(int memberId, String address) {
		 TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.memberId= :update", Member.class);
	  		query.setParameter("update",memberId );
		  Member member = query.getSingleResult();
		  member.setAddress(address);
		return member;
		
		
		
	}
}



