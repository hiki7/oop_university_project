package Information.Exceptions;
public class CreditsException extends Exception {
	private static final long serialVersionUID = -7751278689285186868L;

	public CreditsException(String message) {
        super(message);
    }

    public CreditsException(String message, Throwable cause) {
        super(message, cause);
    }
}

