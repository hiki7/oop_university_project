package Information.Exceptions;
public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 6629567322205746698L;

	public UserNotFoundException(String message) {
    	super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
    	super(message, cause);
    }
}


