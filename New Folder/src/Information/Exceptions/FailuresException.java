package Information.Exceptions;
public class FailuresException extends Exception {
	private static final long serialVersionUID = 459782879296140490L;

	public FailuresException(String message) {
    	super(message);
    }

    public FailuresException(String message, Throwable cause) {
    	super(message, cause);
    }
}

