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
	
	/* (non-Javadoc)
	 * @see dao.MemberEjbInt#createMember(model.Member)
	 */
	@Override
	public void createMember(Member member) {
		em.persist(member);
	}



	/* (non-Javadoc)
	 * @see dao.MemberEjbInt#listMembers()
	 */
	@Override
	public List<Member> listMembers() {
		
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
			   List<Member> results = query.getResultList();
			   return results;
	}



	/* (non-Javadoc)
	 * @see dao.MemberEjbInt#searchByLastName(java.lang.String)
	 */
	@Override
	public List<Member> searchByLastName(String name) {
		
		  TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.lastName= :replace", Member.class);
		  		query.setParameter("replace", name);
			   List<Member> member = query.getResultList();
			   return member;
		
	}
	
	
	/* (non-Javadoc)
	 * @see dao.MemberEjbInt#updateById(int)
	 */
	@Override
	public Member updateById(int memberId) {
		 TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.memberId= :update", Member.class);
	  		query.setParameter("update",memberId );
		  Member member = query.getSingleResult();
		return member;
		
		
		
	}
}



