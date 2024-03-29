package kr.or.ddit.board.exception;

/**
 * 게시판에서 발생할 수 있는 모든 예외적 상황의 표현
 *
 */
public class BoardException extends RuntimeException{

	public BoardException() {
		super();
	}

	public BoardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BoardException(String message, Throwable cause) {
		super(message, cause);
	}

	public BoardException(String message) {
		super(message);
	}

	public BoardException(Throwable cause) {
		super(cause);
	}

}
