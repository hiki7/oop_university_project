package LessonObjects;
import java.util.*;
public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private Major major;
    private CourseType courseType;
    private List<Lesson> lessons;
    
    public Course() {
    	
    }
    
    public Course(String coursecode, String courseName, int credits, Major major, CourseType courseType,
			List<Lesson> lessons) {
		super();
		this.courseCode = coursecode;
		this.courseName = courseName;
		this.credits = credits;
		this.major = major;
		this.courseType = courseType;
		this.lessons = lessons;
	}
    
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String coursecode) {
		this.courseCode = coursecode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseName, courseType, courseCode, credits, lessons, major);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseName, other.courseName) && courseType == other.courseType
				&& Objects.equals(courseCode, other.courseCode) && credits == other.credits
				&& Objects.equals(lessons, other.lessons) && Objects.equals(major, other.major);
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", credits=" + credits + ", major="
				+ major + ", courseType=" + courseType + ", lessons=" + lessons + "]";
	}
	
}

