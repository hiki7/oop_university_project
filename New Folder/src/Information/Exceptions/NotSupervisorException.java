package Information.Exceptions;
public class NotSupervisorException extends Exception {
	private static final long serialVersionUID = -7654021041397568603L;

	public NotSupervisorException(String message) {
    	super(message);
    }
    
    public NotSupervisorException(String message, Throwable cause) {
    	super(message, cause);
    }
}

