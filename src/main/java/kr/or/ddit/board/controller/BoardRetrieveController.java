package kr.or.ddit.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.common.paging.BootstrapFormBasePaginationRenderer;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.common.paging.PaginationRenderer;
import kr.or.ddit.common.paging.SearchCondition;
import kr.or.ddit.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

/**
 * 비동기 처리 기반(RESTful URI)
 * 다건 조회 : /{boardType}/board GET
 * 단건 조회 : /{boardType}/board/{boNo} GET
 * 등록 : /{boardType}/board POST
 * 수정 : /{boardType}/board/{boNo} PUT
 * 삭제 : /{boardType}/board/{boNo} DELETE
 * 
 * 동기 처리 기반(non-RESTful URI)
 * 다건 조회 : /{boardType}/board GET
 * 단건 조회 : /{boardType}/board/{boNo} GET
 * 등록 폼 : /{boardType}/board/insert GET
 * 답글등록 폼 : /{boardType}/board/{boParent}/child GET
 * 등록 : /{boardType}/board/insert POST
 * 답글등록 : /{boardType}/board/{boParent}/child POST
 * 수정 폼 : /{boardType}/board/{글번호}/update GET
 * 수정 : /{boardType}/board/{글번호}/update POST
 * 삭제 : /{boardType}/board/{boNo}/delete POST
 *
 */
@Slf4j
@Controller
@RequestMapping("/{boardType}/board")
public class BoardRetrieveController {
	
	@Inject
	private BoardService service;
	
	// /notice/board
	@GetMapping
	public String list(@PathVariable String boardType
			, @RequestParam(required = false, defaultValue = "1") int page
			, Model model
			, @ModelAttribute("simpleCondition") SearchCondition simpleCondition
	) {
		PaginationInfo paging = new PaginationInfo();
		paging.setCurrentPage(page);
		paging.setSimpleCondition(simpleCondition);
		
		List<BoardVO> boardList = service.retrieveBoardList(paging);
		model.addAttribute("boardList", boardList);
		PaginationRenderer renderer = new BootstrapFormBasePaginationRenderer("#searchForm");
		String pagingHTML = renderer.renderPagination(paging);
		model.addAttribute("pagingHTML", pagingHTML);
		log.info("게시판 종류 : {}", boardType);
		return "board/boardList";
	}
	
	// /notice/board/34	
	@GetMapping("{boNo}")
	public String detail(@PathVariable String boardType, @PathVariable int boNo, Model model) {
		BoardVO board = service.retrieveBoard(boNo);
		model.addAttribute("board", board);
		log.info("게시판 종류 : {}, 글번호 : {}", boardType, boNo);
		return "board/boardView";
	}

}












