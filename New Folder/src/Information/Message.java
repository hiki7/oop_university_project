package Information;
import java.io.Serializable;
import java.util.*;
import Users.*;
/**
 * This is the Message class
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 209362398059827367L;
	private Employee sender;
    private Employee recipient;
    private String content;
    private Date timestamp;
    /**
     * Empty constructor of the Message class
     */
    public Message() {
    	
    }
    /**
     * Constructor of the Message class, which accepts sender, recipient, content
     * @param sender
     * @param recipient
     * @param content
     */
	public Message(Employee sender, Employee recipient, String content) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
		this.timestamp = new Date() ;
	}
	/**
	 * With this method, we get information about the sender, 
	 * which can be any object of the Employee class or its child classes
	 * @return sender
	 */
	public Employee getSender() {
		return sender;
	}
	/**
	 * With this method, we accept information about the sender,
	 * which can be any object of the Employee class or its child classes
	 * @param sender
	 */
	public void setSender(Employee sender) {
		this.sender = sender;
	}
	/**
	 * Using this method, we get information about the recipient,
     * which can be any object of the Employee class or its child classes
	 * @return recipient
	 */
	public Employee getRecipient() {
		return recipient;
	}
	/**
	 * Using this method, we accept information about the recipient,
	 * which can be any object of the Employee class or its child classes
	 * @param recipient
	 */
	public void setRecipient(Employee recipient) {
		this.recipient = recipient;
	}
	/**
	 * This method returns the content whose type is string
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * This method accepts content whose type is string
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * This method returns timestamp 
	 * @return timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * This method accepts timestamp 
	 * @param timestamp
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * Overriding method hashCode to Message class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, recipient, sender, timestamp);
	}
	/**
	 * Overriding method equals to Message class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(content, other.content) && Objects.equals(recipient, other.recipient)
				&& Objects.equals(sender, other.sender) && Objects.equals(timestamp, other.timestamp);
	}
	/**
	 * Overriding method toString to Message class
	 */
	@Override
	public String toString() {
		return "Message [sender=" + sender + ", recipient=" + recipient + ", content=" + content + ", timestamp="
				+ timestamp + "]";
	}
    
}

