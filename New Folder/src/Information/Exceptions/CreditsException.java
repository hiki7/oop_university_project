package Information.Exceptions;
/**
 * This is the CreditsException class
 */
public class CreditsException extends Exception {
	private static final long serialVersionUID = -7751278689285186868L;
	/**
	 * Constructor of the CreditsException class, which accepts message 
	 * @param message
	 */
	public CreditsException(String message) {
        super(message);
    }
	/**
	 * Constructor of the CreditsException class, which accepts message and cause when credits more than 21
	 * @param message
	 * @param cause
	 */
    public CreditsException(String message, Throwable cause) {
        super(message, cause);
    }
}

