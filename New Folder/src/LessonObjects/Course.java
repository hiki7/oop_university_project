package LessonObjects;
import java.io.Serializable;
import java.util.*;
/**
 * This is the Course class
 */
public class Course implements Serializable{
	private static final long serialVersionUID = -1236500806819709110L;
	private String courseCode;
    private String courseName;
    private int credits;
    private List<Lesson> lessons;
    private Map<Major, CourseType> types;
    /**
     * Empty constructor of the Course class
     */
    public Course() {
    	
    }
    /**
     * Constructor of the Course class, which accepts course code, name, credits, list of lessons, type of course
     * @param coursecode
     * @param courseName
     * @param credits
     * @param list
     * @param types
     */
    public Course(String coursecode, String courseName, int credits, 
			ArrayList<Lesson> list, HashMap<Major, CourseType> types) {
		super();
		this.courseCode = coursecode;
		this.courseName = courseName;
		this.credits = credits;
		this.lessons = list;
		this.types = types;
	}
    /**
     * This method returns map of major and course type
     * @return types
     */
	public Map<Major, CourseType> getTypes() {
		return types;
	}
	   /**
     * This method returns map of major and course type
     * @return types
     */
	public void setTypes(Map<Major, CourseType> types) {
		this.types = types;
	}
	/**
	 * This method returns course code
	 * @return courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}
	/**
	 * This method accepts course code
	 * @param coursecode
	 */
	public void setCourseCode(String coursecode) {
		this.courseCode = coursecode;
	}

	/**
	 * This method returns course name
	 * @return courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * This method accepts course name
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * This method returns credits of course
	 * @return credits
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * This method accepts credits of course
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	/**
	 * This method returns list of the lessons
	 * @return lessons
	 */
	public List<Lesson> getLessons() {
		return lessons;
	}
	/**
	 * This method accepted list of the lessons
	 * @param lessons
	 */
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	/**
	 * Overriding method hashCode to Course class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(courseCode, courseName, credits);
	}
	/**
	 * Overriding method equals to Course class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseCode, other.courseCode) && Objects.equals(courseName, other.courseName)
				&& credits == other.credits;
	}
	
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", credits=" + credits;
	}
	
}


