package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.MemberRoleDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.MemberRole;

@Service
public class MybatisHomeService {
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Autowired
	private MemberDao memberDao;

	public String getDefaultRoleName(String memberId) {
		// memberRoleDao를 이용
		List<MemberRole> list = memberRoleDao.getList(memberId);
		String roleName = "ROLE_STUDENT";
		for(MemberRole role : list) {
			if(role.getDefaultRole())
				roleName = role.getRoleName();
		}
		return roleName;
	}

	public boolean isEmailDuplicated(String email) {
		Member member = memberDao.getByEmail(email);
		
		if(member != null)
			return true;
		
		return false;
	}

	public boolean isIdDuplicated(String id) {
		Member member = memberDao.get(id);
		
		if(member != null)
			return true;
		
		return false;
		
	}

	public int insertMember(Member member) {
		int result = memberDao.insert(member);
		memberRoleDao.insert(new MemberRole(member.getId(), "ROLE_STUDENT", true));
		return result;
	}

	public Member getMember(String id) {
		Member member = memberDao.get(id);
		return member;
	}
	
}