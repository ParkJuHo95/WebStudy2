package kr.or.ddit.dummy.controlller;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.dummy.service.DummyService;
import kr.or.ddit.security.MemberVOWrapper;
import kr.or.ddit.security.RealUser;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class DummyController {
	@Inject
	private DummyService service;
	
	@GetMapping("/dummy")
	public String dummy(
			Principal authentication1
			, Authentication authentication2
			, @AuthenticationPrincipal MemberVOWrapper principal
			, @AuthenticationPrincipal(expression = "realUser") MemberVO realUser1
			, @RealUser MemberVO realUser2
	) {
		log.info("case1 principal : {}", authentication1);
		log.info("case2 authentication : {}", authentication2);
		log.info("case3 MemberVOWrapper : {}", principal);
		log.info("case4 MemberVO : {}", realUser1);
		log.info("case5 MemberVO : {}", realUser2);
		
		service.dummyLogic();
		return "index";
	}
}













