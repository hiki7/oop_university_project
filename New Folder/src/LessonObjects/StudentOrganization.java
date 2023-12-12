package LessonObjects;
import java.util.*;
import Users.*;

public class StudentOrganization {
    private String organizationName;
    private List<Student> members;
    private Student head;
    
    public StudentOrganization() {
    	
    }
     
    public StudentOrganization(String organizationName, List<Student> members, Student head) {
		super();
		this.organizationName = organizationName;
		this.members = members;
		this.head = head;
	}
    
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public List<Student> getMembers() {
		return members;
	}

	public void setMembers(List<Student> members) {
		this.members = members;
	}

	public Student getHead() {
		return head;
	}

	public void setHead(Student head) {
		this.head = head;
	}

	public void addMember(Student student) {
		members.add(student);
    }

	@Override
	public int hashCode() {
		return Objects.hash(head, members, organizationName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentOrganization other = (StudentOrganization) obj;
		return Objects.equals(head, other.head) && Objects.equals(members, other.members)
				&& Objects.equals(organizationName, other.organizationName);
	}

	@Override
	public String toString() {
		return "StudentOrganization [organizationName=" + organizationName + ", members=" + members + ", head=" + head
				+ "]";
	}
	
}

