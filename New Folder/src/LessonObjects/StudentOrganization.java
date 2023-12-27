package LessonObjects;
import java.io.Serializable;
import java.util.*;
import Users.*;
/**
 * This is the StudentOrganization class
 */
public class StudentOrganization implements Serializable{
	private static final long serialVersionUID = 980271336796308620L;
	private String organizationName;
    private List<Student> members;
    private Student head;
    /**
     * Empty constructor of the StudentOrganization class
     */
    public StudentOrganization() {
    	
    }
    /**
     * Constructor of the StudentOrganization class, accepts name of organization, members and head of the this organization
     * @param organizationName
     * @param head
     */
    public StudentOrganization(String organizationName,  Student head) {
		super();
		this.organizationName = organizationName;
		this.members = new ArrayList<Student>();
		this.head = head;
	}
    /**
     * This method returns name of organization
     * @return organizationName
     */
	public String getOrganizationName() {
		return organizationName;
	}
	/**
	 * This method accepts name of organization
	 * @param organizationName
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	/**
	 * This method returns list of the members
	 * @return members
	 */
	public List<Student> getMembers() {
		return members;
	}
	/**
	 * This method accepts list of the members
	 * @param members
	 */
	public void setMembers(List<Student> members) {
		this.members = members;
	}
	/**
	 * This method returns head of the student organization 
	 * @return head
	 */
	public Student getHead() {
		return head;
	}
	/**
	 * This method accepts head of the student organization
	 * @param head
	 */
	public void setHead(Student head) {
		this.head = head;
	}
	/**
	 * This method add student to members
	 * @param student
	 */
	public void addMember(Student student) {
		members.add(student);
    }
	/**
	 * Overriding method hashCode to StudentOrganization class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(organizationName);
	}
	/**
	 * Overriding method equals to StudentOrganization class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentOrganization other = (StudentOrganization) obj;
		return   Objects.equals(organizationName, other.organizationName);
	}
	/**
	 * Overriding method toString to StudentOrganization class
	 */
	@Override
	public String toString() {
		return "StudentOrganization [organizationName=" + organizationName + ", members=" + members + ", head=" + head
				+ "]";
	}
	
}

