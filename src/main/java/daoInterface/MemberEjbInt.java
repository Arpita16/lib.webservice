package daoInterface;

import java.util.List;

import model.Member;

public interface MemberEjbInt {

	void createMember(Member member);

	List<Member> listMembers();

	List<Member> searchByLastName(String name);

	Member updateById(int memberId, String address);

}