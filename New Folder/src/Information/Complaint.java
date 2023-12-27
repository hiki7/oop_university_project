package Information;
import java.io.Serializable;
import java.util.Objects;
import Users.*;
/**
 * This is the Complaint class
 */
public class Complaint implements Serializable {
	private static final long serialVersionUID = -4828746421794721236L;
	private Teacher sender;
    private Dean recipient;
    private UrgencyLevel urgencyLevel;
    private String content;
    private Student student;
    /**
     * Empty constructor of Complaint class
     */
    public Complaint() {
    	
    }
    /**
     * Constructor of Complaint class, which accepts sender, recipient, urgency level, content, student
     * @param sender
     * @param recipient
     * @param urgencyLevel
     * @param content
     * @param student
     */
	public Complaint(Teacher sender, Dean recipient, UrgencyLevel urgencyLevel, String content, Student student) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.urgencyLevel = urgencyLevel;
		this.content = content;
		this.student = student;
	}
	/**
	 * This method returns the sender which is the Teacher type
	 * @return sender
	 */
	public Teacher getSender() {
		return sender;
	}
	/**
	 * This method accepts a sender which is a type of Teacher
	 * @param sender
	 */
	public void setSender(Teacher sender) {
		this.sender = sender;
	}
	/**
	 * This method returns a recipient that is of the Dean type
	 * @return recipient
	 */
	public Dean getRecipient() {
		return recipient;
	}
	/**
	 * This method accepts a recipient
	 * @param recipient
	 */
	public void setRecipient(Dean recipient) {
		this.recipient = recipient;
	}
	/**
	 * This method returns the urgency level
	 * @return urgencyLevel
	 */
	public UrgencyLevel getUrgencyLevel() {
		return urgencyLevel;
	}
	/**
	 * This method accepts the urgency level
	 * @param urgencyLevel
	 */
	public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}
	/**
	 * This method returns the content 
	 * 	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * This method accepts content 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * This method returns all information about student
	 * @return student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * This method accepts all information about student
	 * @param student
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * Overriding method hashCode to Complaint class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, recipient, sender, student, urgencyLevel);
	}
	/**
	 * Overriding method equals to Complaint class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Complaint other = (Complaint) obj;
		return Objects.equals(content, other.content) && Objects.equals(recipient, other.recipient)
				&& Objects.equals(sender, other.sender) && Objects.equals(student, other.student)
				&& urgencyLevel == other.urgencyLevel;
	}
	/**
	 * Overriding method toString to Complaint class
	 */
	@Override
	public String toString() {
		return "Complaint [sender=" + sender + ", recipient=" + recipient + ", urgencyLevel=" + urgencyLevel
				+ ", content=" + content + ", student=" + student + "]";
	}
    
}

