package model;

public class DuplicateIdException extends Exception {

	public DuplicateIdException() {
		super();
	}
	
	public DuplicateIdException(String msg) {
		super(msg);
	}
	
	public DuplicateIdException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
