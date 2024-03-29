package kr.or.ddit.security.handler;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import kr.or.ddit.security.MemberVOWrapper;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		HttpSession session = request.getSession(false);
		MemberVOWrapper principal = (MemberVOWrapper) authentication.getPrincipal();
		MemberVO realUser = principal.getRealUser();
		log.info("custom logout success handler 처리, {}가 로그아웃 한 후처리", realUser.getMemName());
		Optional.ofNullable(session)
				.ifPresent(s->s.invalidate());
		super.onLogoutSuccess(request, response, authentication);
	}
}













