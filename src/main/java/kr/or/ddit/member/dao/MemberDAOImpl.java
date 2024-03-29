package kr.or.ddit.member.dao;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import kr.or.ddit.mybatis.mappers.MemberMapper;
import kr.or.ddit.security.MemberVOWrapper;
import kr.or.ddit.vo.MemberVO;


@Repository("userDetailService")
public class MemberDAOImpl implements UserDetailsService{
	
	@Inject
	private MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = mapper.selectMemberByUsername(username);
		if(member==null)
			throw new UsernameNotFoundException(String.format("%s 사용자 없음.", username));
		
		return new MemberVOWrapper(member);
	}

}
