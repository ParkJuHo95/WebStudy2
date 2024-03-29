package kr.or.ddit.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginAndLogOutController {
	@GetMapping("/myLogin")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/myLogout")
	public String logoutForm() {
		return "logout";
	}
}
