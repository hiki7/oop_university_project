package Information.Exceptions;
public class NotResearcherException extends Exception {
	private static final long serialVersionUID = 2024098840646279652L;

	public NotResearcherException(String message) {
    	super(message);
    }

    public NotResearcherException(String message, Throwable cause) {
    	super(message, cause);
    }
}
