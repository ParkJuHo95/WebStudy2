package kr.or.ddit.dummy.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.or.ddit.security.MemberVOWrapper;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DummyService {
	public void dummyLogic() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MemberVOWrapper principal = (MemberVOWrapper)authentication.getPrincipal();
		MemberVO realUser = principal.getRealUser();
		log.info("현재 로그인되어있는 사용자 : {}", realUser.getMemName());
	}
}
