package Users;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import Information.*;
import LessonObjects.*;
import ResearchObjects.Citation;
public class Teacher extends Employee {
	private TeacherTitle title;
	private List<Course> taughtCourses;
	private List<Complaint> complaints;
	private List<Integer> teacherRates;
	public Teacher() {
		super();
	}
	public Teacher(String username, String password, UserRole role, String name, String surname, Gender gender,
			String id, boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher, int salary, TeacherTitle title, List<Course> taughtCourses, List<Complaint> complaints,
	List<Integer> teacherRates) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, citationsOfResearcher, salary);
		this.title = title;
		this.taughtCourses = taughtCourses;
		this.complaints = complaints;
		this.teacherRates = teacherRates;
	}
	public TeacherTitle getTitle() {
		return title;
	}
	public void setTitle(TeacherTitle title) {
		this.title = title;
	}
	public List<Course> getTaughtCourses() {
		return taughtCourses;
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
		result = prime * result + Objects.hash(complaints, taughtCourses, teacherRates, title);
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
		return Objects.equals(complaints, other.complaints) && Objects.equals(taughtCourses, other.taughtCourses)
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
	public void sendComplaint(Complaint complaint) {
		Data.getInstance().getComplaints().add(complaint);
	}
	public String viewCourses() {
		return taughtCourses.toString();
	}
	public String viewStudentsInfo(Student student) {
		return student.toString();
	}
	public void putMark(Student student, Lesson lesson, double grade) {
		lesson.getGrades().put(student,grade);
	}
	public void manageCourse(Lesson lesson, LessonFormat format, Date date) {
		if(lesson.getTeacher().equals(this)) {
			lesson.setFormat(format);
			lesson.setDate(date);
		}
	}
	public void sendRequest(Manager manager, Course course) {
		manager.viewRequests().put(this, course);
 } 
}

