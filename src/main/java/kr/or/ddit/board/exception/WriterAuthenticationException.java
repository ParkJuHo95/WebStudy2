package kr.or.ddit.board.exception;

/**
 * 작성자 인증 실패 상황 표현
 *
 */
public class WriterAuthenticationException extends BoardException{

	public WriterAuthenticationException(int boNo) {
		super(String.format("%d번 게시글 작성자 인증 실패", boNo));
	}
}
