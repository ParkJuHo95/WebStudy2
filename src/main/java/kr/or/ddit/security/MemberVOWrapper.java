package kr.or.ddit.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.vo.MemberVO;

public class MemberVOWrapper extends User{
	private MemberVO realUser;

	public MemberVOWrapper(MemberVO realUser) {
		super(realUser.getMemId(), realUser.getMemPass(), 
					realUser.getMemRoles().stream()
										.map(SimpleGrantedAuthority::new)
										.collect(Collectors.toList()));
		this.realUser = realUser;
	}
	
	public MemberVO getRealUser() {
		return realUser;
	}
}
