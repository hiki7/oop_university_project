package Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import Information.*;
import LessonObjects.*;
public class Teacher extends Employee implements Serializable {
	private static final long serialVersionUID = 5594950732558612447L;
	private Faculty faculty;
	private TeacherTitle title;
	private List<Course> taughtCourses;
	private List<Complaint> complaints;
	private List<Integer> teacherRates;
	public Teacher(String username, String password, UserRole role, String name, String surname, Gender gender,
			int id, boolean isResearcher, boolean isSupervisor, int salary, TeacherTitle title,
	 Faculty faculty) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, salary);
		this.title = title;
		this.taughtCourses = new ArrayList<Course>();
		this.complaints = new ArrayList<Complaint>();
		this.teacherRates = new ArrayList<Integer>();
		this.faculty = faculty;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public TeacherTitle getTitle() {
		return title;
	}
	public void setTitle(TeacherTitle title) {
		this.title = title;
	}
	public void setTaughtCourses(List<Course> taughtCourses) {
		this.taughtCourses = taughtCourses;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(complaints, faculty, taughtCourses, teacherRates, title);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return Objects.equals(complaints, other.complaints) && faculty == other.faculty
				&& Objects.equals(taughtCourses, other.taughtCourses)
				&& Objects.equals(teacherRates, other.teacherRates) && title == other.title;
	}
	@Override
	public String toString() {
		return super.toString() + "Teacher [title=" + title + ", taughtCourses=" + taughtCourses + ", complaints=" + complaints
				+ ", teacherRates=" + teacherRates + "]";
	}
	public List<Integer> getTeacherRates() {
		return teacherRates;
	}
	public void setTeacherRates(List<Integer> teacherRates) {
		this.teacherRates = teacherRates;
	}
	public String sendComplaint(int level, int stId, String content) {
		Student s = null;
		boolean m = false;
		for(Student student: Data.getInstance().getStudents()) {
			if(student.getId() == stId) {
				s = student;
				m = true;
				break;
			}
		}
		if(m == false) {
			return "Incorrect data";
		}
		Dean d = null;
		for(User user: Data.getInstance().getUsers()) {
			if(user instanceof Dean && ((Dean) user).getFaculty() == s.getFaculty()) {
				d = (Dean) user;
			}
		}
		UrgencyLevel u = null;
		if(level == 1) {
			u = UrgencyLevel.LOW;
		}else if(level == 2){
			u = UrgencyLevel.MEDIUM;
		}else if(level == 3) {
			u = UrgencyLevel.HIGH;
		}
		Data.getInstance().getComplaints().add(new Complaint(this, d, u, content,s ));
		return "Complaint sent";
	}
	public List<Course> viewCourses() {
		return taughtCourses;
	}
	public String viewStudentsInfo(int stId) {
		Student s = null;
		for(Student student: Data.getInstance().getStudents()) {
			if(student.getId() == stId) {
				s = student;
				return s.toString();
			}
		}
		return "Incorrect data";
	}
	public String putMark(int stId, String courseName, String lessonCode, double grade) {
		Student s = null;
		boolean m = false;
		for(Student student: Data.getInstance().getStudents()) {
			if(student.getId() == stId) {
				s = student;
				m = true;
				break;
			}
		}
		if(m == false) {
			return "Incorrect data";
		}
		m = false;
		Lesson l = null;
    	for(Course course: s.getCourseAttestation().keySet()) {
    		if(course.getCourseName().equals(courseName)) {
    			for(Lesson lesson: course.getLessons()) {
    				if(lesson.getLessonCode().equals(lessonCode)) {
    					l = lesson;
    					m = true;
    					break;
    				}
    			}
    			if(m == true) {
    				break;
    			}
    		}
    	}
		l.getGrades().put(s,grade);
		return "Mark put";
	}
	public String putAtt(int stId, String courseName,int which, double finalGrade) {
		Student s = null;
		boolean m = false;
		for(Student student: Data.getInstance().getStudents()) {
			if(student.getId() == stId) {
				s = student;
				m = true;
				break;
			}
		}
		if(m == false) {
			return "Incorrect ID";
		}
		m = false;
    	Course course = null;
    	for(Course c : Data.getInstance().getCourses()) {
    		if(c.getCourseName().equals(courseName)) {
    			course = c;
    			m = true;
    			break;
    		}
    	}
		if(m == false) {
			return "Incorrect course name";
		}
		double grade = 0;
		if(which == 1) {
			for(int i = 0; i < course.getLessons().size(); i++) {
				if(i == course.getCredits() * 15) {
					break;
				}
				Lesson l = course.getLessons().get(i);
				if(l.getGrades().get(s) != null) {
					grade += l.getGrades().get(s);
				}
			}
			s.getCourseAttestation().get(course).setFirstAtt(grade);
		}else if(which == 2) {
			s.getCourseAttestation().get(course).setSecondAtt(grade);
			for(int i = course.getCredits() * 15; i < course.getLessons().size(); i++ ) {
				if(i == course.getCredits() * 30) {
					break;
				}
				Lesson l = course.getLessons().get(i);
				if(l.getGrades().get(s) != null) {
					grade += l.getGrades().get(s);
				}
			}
			s.getCourseAttestation().get(course).setFirstAtt(grade);
		}else if(which == 3) {
			s.getCourseAttestation().get(course).setFinalExam(finalGrade);
		}
		return "Attestation put";
	}
	public String manageCourse(String courseName ,String lessonCode, LessonFormat format) {
    	Course course = null;
    	boolean m = false;
    	for(Course c : Data.getInstance().getCourses()) {
    		if(c.getCourseName().equals(courseName)) {
    			course = c;
    			m = true;
    			break;
    		}
    	}
		if(m == false) {
			return "Incorrect course name";
		}
		m = false;
		Lesson ll = null;
		for(Lesson l : course.getLessons()) {
			if(l.getLessonCode().equals(lessonCode)) {
				ll = l;
				m = true;
				break;
			}
		}
		if(m == false) {
			return "Incorrect lesson code";
		}
		ll.setFormat(format);
		return "Course managed succesfully";
	}
	public String sendRequest(String courseName) {
    	Course course = null;
    	boolean m = false;
    	for(Course c : Data.getInstance().getCourses()) {
    		if(c.getCourseName().equals(courseName)) {
    			course = c;
    			m = true;
    		}
    	}
    	if(m == false) {
    		return "Incorrect data";
    	}
    	for(User user: Data.getInstance().getUsers()) {
    		if(user.getRole() == UserRole.MANAGER && ((Manager)user).getManagerType() == this.getFaculty()){
    			((Manager)user).viewRequests().put(this, course);
    		}
    	}
    	return "Your faculty manager has get it!";
 } 
}

