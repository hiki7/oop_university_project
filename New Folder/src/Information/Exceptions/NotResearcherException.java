package Information.Exceptions;
/**
 * This is the NotResearcherException class
 */
public class NotResearcherException extends Exception {
	private static final long serialVersionUID = 2024098840646279652L;
	/**
	 * Constructor of the NotResearcherException class, which accepts message
	 * @param message
	 */
	public NotResearcherException(String message) {
    	super(message);
    }
	/**
	 * Constructor of the NotResearcherException class, which accepts message and cause, when user is not researcher
	 * @param message
	 * @param cause
	 */
    public NotResearcherException(String message, Throwable cause) {
    	super(message, cause);
    }
}
