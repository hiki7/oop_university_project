package Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import Information.Data;
import LessonObjects.*;

public class Student extends User implements Serializable{
	private static final long serialVersionUID = 2494906127312361806L;
	private int totalFailures;
    private int totalCredits;
    private Faculty Faculty;
    private HashMap<Course, Attestation> courseAttestation;
    private int yearOfStudy;
    private Major major;
    

	public Student() {
		super();
	}

	public Student(String username, String password, UserRole role, String name, String surname, Gender gender,
			int id, boolean isResearcher, boolean isSupervisor,  int totalFailures, int totalCredits, Users.Faculty faculty,
			HashMap<Course, Attestation> courseAttestation, int yearOfStudy, Major major) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor);
		this.totalFailures = totalFailures;
		this.totalCredits = totalCredits;
		Faculty = faculty;
		this.courseAttestation = courseAttestation;
		this.yearOfStudy = yearOfStudy;
		this.major = major;
	}
	
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public int getTotalFailures() {
		return totalFailures;
	}

	public void setTotalFailures(int totalFailures) {
		this.totalFailures = totalFailures;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	public Faculty getFaculty() {
		return Faculty;
	}

	public void setFaculty(Faculty faculty) {
		Faculty = faculty;
	}

	public HashMap<Course, Attestation> getCourseAttestation() {
		return courseAttestation;
	}

	public void setCourseAttestation(HashMap<Course, Attestation> courseAttestation) {
		this.courseAttestation = courseAttestation;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	@Override
	public String toString() {
		return super.toString() + "Student [totalFailures=" + totalFailures + ", totalCredits=" + totalCredits +
				  ", Faculty=" + Faculty + ", yearOfStudy="
				+ yearOfStudy + "]";
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(Faculty,  major, totalCredits, totalFailures, yearOfStudy);
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
		Student other = (Student) obj;
		return Faculty == other.Faculty 
				&& major == other.major && totalCredits == other.totalCredits && totalFailures == other.totalFailures
				&& yearOfStudy == other.yearOfStudy;
	}

	public String viewCourses() {
		return courseAttestation.keySet().toString();
    }
    public List<String> viewTeacherInfo() {
    	List<String> teachers = new ArrayList<String>();
    	for(Course course: courseAttestation.keySet()) {
    		for(Teacher teacher: Data.getInstance().getTeachers()) {
    			if(teacher.viewCourses().contains(course)) {
    				teachers.add(teacher.getName() + teacher.getSurname());
    			}
    		}
    	}
        return teachers;
    }
    public String viewMarks( String courseName, String lessonCode) {
    	for(Course course: courseAttestation.keySet()) {
    		if(course.getCourseName().equals(courseName)) {
    			for(Lesson lesson: course.getLessons()) {
    				if(lesson.getLessonCode().equals(lessonCode)) {
        				return "For course " + courseName + " for lesson " + lessonCode + "the grade is" 
        						+ lesson.getGrades().get(this).toString();
    				}
    			}
    		}
    	}
        return "Incorrect datas";
    }
    public String viewTranscript() {
        StringBuilder transcriptTable = new StringBuilder();
        double totalGPA = 0, sum = 0;
        // Header of the transcript table
        transcriptTable.append(String.format("%-20s %-15s %-10s %-20s %-10s%n",
                "Course Name", "Course Code", "Credits", "Total Scores", "GPA"));
        transcriptTable.append("------------------------------------------------------------\n");
        // Populate the transcript table
        for (Map.Entry<Course, Attestation> e : courseAttestation.entrySet()) {
            Attestation attestation = e.getValue();
            Course course = e.getKey();
            // Calculate GPA for the course
            double courseGpa = attestation.calculateGpa();
            sum += courseGpa;
            transcriptTable.append(String.format("%-20s %-15s %-10d %-20.2f %-10.2f%n",
                    course.getCourseName(), course.getCourseCode(), course.getCredits(),
                    attestation.getFirstAtt() + attestation.getSecondAtt() + attestation.getFinalExam(), courseGpa));
        }
        totalGPA = sum/courseAttestation.size();
        // Add overall GPA at the end
        transcriptTable.append("------------------------------------------------------------\n");
        transcriptTable.append(String.format("%-45s %-10.2f%n", "Overall GPA:", totalGPA));
        return transcriptTable.toString();
    }

    
	public String rateTeacher(String teacherName, int rating) {
		for(Teacher teacher: Data.getInstance().getTeachers()) {
			if(teacher.getName().equals(teacherName)) {
		    	teacher.getTeacherRates().add(rating);
		    	return "Thank you!";
			}
		}
		return "Incorrect data";
    }
    public String joinStudentOrganization(String name) {
    	for(StudentOrganization so: Data.getInstance().getStudentOrganizations()) {
    		if(so.getOrganizationName().equals(name)) {
    			so.addMember(this);
    			return "You added succesfully";
    		}
    	}
    	return "Incorrect data";
    }
    public String sendRequest(String courseName) {
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
    		return "Incorrect data";
    	}
    	for(User user: Data.getInstance().getUsers()) {
    		if(user.getRole() == UserRole.MANAGER && ((Manager)user).getManagerType() == this.getFaculty()){
    			((Manager)user).viewRequests().put(this, course);
    		}
    	}
    	return "Your faculty manager has get it!";
    }
    public String createStOrg(String name) {
    	Data.getInstance().getStudentOrganizations().add(new StudentOrganization(name, this));
    	return "Student organization added succesfully";
    }
    
}

