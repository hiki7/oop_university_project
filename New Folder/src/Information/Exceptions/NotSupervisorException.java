package Information.Exceptions;
/**
 * This is the NotSupervisorException class
 */
public class NotSupervisorException extends Exception {
	private static final long serialVersionUID = -7654021041397568603L;
	/**
	 * Constructor of the NotSupervisorException class, which accepts message
	 * @param message
	 */
	public NotSupervisorException(String message) {
    	super(message);
    }
	/**
	 * Constructor of the NotSupervisorException class, which accepts message and cause, when user is not supervisor
	 * @param message
	 * @param cause
	 */
    public NotSupervisorException(String message, Throwable cause) {
    	super(message, cause);
    }
}

