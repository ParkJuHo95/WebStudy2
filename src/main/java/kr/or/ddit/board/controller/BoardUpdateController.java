package kr.or.ddit.board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.board.exception.BoardException;
import kr.or.ddit.board.exception.WriterAuthenticationException;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.vo.BoardVO;


@Controller
@RequestMapping("{boardType}/board")
public class BoardUpdateController {
	public static final String MODELNAME = "targetBoard";
	
	@Inject
	private BoardService service;
	
	@GetMapping("{boNo}/auth")
	public String authenticateForm() {
		return "board/authForm";
	}
	
	@PostMapping("{boNo}/auth")
	public String authenticateWriter(BoardVO inputData, RedirectAttributes redirectAttributes) {
		// Post-Redirect-Get 패턴으로 리다이렉션 이후 발생하는 요청은 @GetMapping 핸들러에서 처리됨.
		try {
			BoardVO authenticated = service.writerAuthenticate(inputData);
			redirectAttributes.addFlashAttribute(MODELNAME, authenticated);
			return "redirect:/{boardType}/board/{boNo}/update";
		}catch (WriterAuthenticationException e) {
			redirectAttributes.addFlashAttribute("message", "작성자 인증 오류");
			return "redirect:/{boardType}/board/{boNo}/auth";
		}
	}
	
	@GetMapping("{boNo}/update")
	public String form(Model model) {
		if(model.containsAttribute(MODELNAME)) {
			return "board/boardEdit";
		}else {
			return "redirect:/{boardType}/board/{boNo}/auth";
		}
	}
	
	@PostMapping("{boNo}/update")
	public String update(@ModelAttribute(MODELNAME) BoardVO board, RedirectAttributes redirectAttributes) {
		try {
			service.modifyBoard(board);
			return "redirect:/{boardType}/board/{boNo}";
		}catch (BoardException e) {
			redirectAttributes.addFlashAttribute(MODELNAME, board);
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "redirect:/{boardType}/board/{boNo}/auth";
		}
	}
	
	@PostMapping("{boNo}/delete")
	public String delete(@ModelAttribute(MODELNAME) BoardVO board, RedirectAttributes redirectAttributes) {
		try {
			service.removeBoard(board);
			return "redirect:/{boardType}/board";
		}catch (BoardException e) {
			redirectAttributes.addFlashAttribute("message", e.getMessage());
			return "redirect:/{boardType}/board/{boNo}/auth";
		}
	}
	
	
}
