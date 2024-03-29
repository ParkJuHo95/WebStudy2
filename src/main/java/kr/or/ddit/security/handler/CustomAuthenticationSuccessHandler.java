package kr.or.ddit.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import kr.or.ddit.security.MemberVOWrapper;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		MemberVOWrapper principal = (MemberVOWrapper) authentication.getPrincipal();
		MemberVO realUser = principal.getRealUser();
		log.info("custom success handler 처리. 로그인에 성공한 사용자는 {}", realUser.getMemName());
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
