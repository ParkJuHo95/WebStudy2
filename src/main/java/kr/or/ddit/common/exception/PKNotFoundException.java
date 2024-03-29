package kr.or.ddit.common.exception;

public class PKNotFoundException extends RuntimeException{
	private int status;

	public PKNotFoundException(String message) {
		this(500, message);
	}

	public PKNotFoundException(int status, String message) {
		super(message);
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
