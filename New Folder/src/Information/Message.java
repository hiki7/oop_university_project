package Information;
import java.util.*;
import Users.*;
public class Message {
    private Employee sender;
    private Employee recipient;
    private String content;
    private Date timestamp;
    public Message() {
    	
    }
	public Message(Employee sender, Employee recipient, String content, Date timestamp) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.content = content;
		this.timestamp = timestamp;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}

	public Employee getRecipient() {
		return recipient;
	}

	public void setRecipient(Employee recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, recipient, sender, timestamp);
	}

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

	@Override
	public String toString() {
		return "Message [sender=" + sender + ", recipient=" + recipient + ", content=" + content + ", timestamp="
				+ timestamp + "]";
	}
    
}

