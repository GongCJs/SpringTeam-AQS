package team.spring.aqs.exception;

public class FileException extends RuntimeException {

	private static final long serialVersionUID = -6619492799828778496L;
	public FileException() {
		super();
	}

	public FileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileException(String message) {
		super(message);
	}

	public FileException(Throwable cause) {
		super(cause);
	}
}
