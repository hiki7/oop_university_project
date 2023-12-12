package Information;
import java.util.Objects;
import Users.*;
public class Complaint {
    private Teacher sender;
    private Dean recipient;
    private UrgencyLevel urgencyLevel;
    private String content;
    private Student student;
    public Complaint() {
    	
    }

	public Complaint(Teacher sender, Dean recipient, UrgencyLevel urgencyLevel, String content, Student student) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.urgencyLevel = urgencyLevel;
		this.content = content;
		this.student = student;
	}

	public Teacher getSender() {
		return sender;
	}

	public void setSender(Teacher sender) {
		this.sender = sender;
	}

	public Dean getRecipient() {
		return recipient;
	}

	public void setRecipient(Dean recipient) {
		this.recipient = recipient;
	}

	public UrgencyLevel getUrgencyLevel() {
		return urgencyLevel;
	}

	public void setUrgencyLevel(UrgencyLevel urgencyLevel) {
		this.urgencyLevel = urgencyLevel;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, recipient, sender, student, urgencyLevel);
	}

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
	@Override
	public String toString() {
		return "Complaint [sender=" + sender + ", recipient=" + recipient + ", urgencyLevel=" + urgencyLevel
				+ ", content=" + content + ", student=" + student + "]";
	}
    
}

