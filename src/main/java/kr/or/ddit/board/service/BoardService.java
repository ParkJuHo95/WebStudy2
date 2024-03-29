package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.exception.BoardException;
import kr.or.ddit.board.exception.WriterAuthenticationException;
import kr.or.ddit.common.paging.PaginationInfo;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.BoardVO;

public interface BoardService {
	/**
	 * 새글 작성
	 * @param board
	 */
	public void createBoard(BoardVO board);
	/**
	 * 글 조회
	 * @param boNo
	 * @return
	 */
	public BoardVO retrieveBoard(int boNo) throws BoardException;
	/**
	 * 글 목록 조회
	 * @param paging
	 * @return
	 */
	public List<BoardVO> retrieveBoardList(PaginationInfo paging);
	/**
	 * 작성자 인증
	 * @param target
	 * @return
	 */
	public BoardVO writerAuthenticate(BoardVO target) throws WriterAuthenticationException;
	/**
	 * 글 수정
	 * @param board
	 */
	public void modifyBoard(BoardVO board);
	/**
	 * 글 삭제
	 * @param board
	 */
	public void removeBoard(BoardVO board);
	
	/**
	 * 첨부파일 다운로드
	 * @param attNo
	 * @return
	 */
	public AttatchVO downloadAttatch(int attNo);
	
	/**
	 * 첨부파일 삭제
	 * @param attNo
	 */
	public void removeAttatch(int attNo);
}
















