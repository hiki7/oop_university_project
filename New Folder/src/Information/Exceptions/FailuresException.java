package Information.Exceptions;
/**
 * This is the FailuresException class
 */
public class FailuresException extends Exception {
	private static final long serialVersionUID = 459782879296140490L;
	/**
	 * Constructor of the FailuresException class, which accepts message
	 * @param message
	 */
	public FailuresException(String message) {
    	super(message);
    }
	/**
	 * Constructor of the FailuresException class, which accepts message and cause, when student have retake in one course more than 3
	 * @param message
	 * @param cause
	 */
    public FailuresException(String message, Throwable cause) {
    	super(message, cause);
    }
}

