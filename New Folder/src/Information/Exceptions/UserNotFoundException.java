package Information.Exceptions;
/**
 * This is the UserNotFoundException class
 */
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 6629567322205746698L;
	/**
	 * Constructor of the UserNotFoundException class, which accepts message
	 * @param message
	 */
	public UserNotFoundException(String message) {
    	super(message);
    }
	/**
	 * Constructor of the UserNotFoundException class, which accepts message, when user did not find
	 * @param message
	 * @param cause
	 */
    public UserNotFoundException(String message, Throwable cause) {
    	super(message, cause);
    }
}


