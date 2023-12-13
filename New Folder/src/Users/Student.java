package Users;
import java.util.HashMap;
import java.util.Objects;
import LessonObjects.*;

public class Student extends User{
    private int totalFailures;
    private int totalCredits;
    private Faculty faculty;
    private HashMap<Course, Attestation> courseAttestation;
    private int yearOfStudy;
    
    public Student(int totalFailures, int totalCredits, Users.Faculty faculty,
			HashMap<Course, Attestation> courseAttestation, int yearOfStudy) {
		super();
		this.totalFailures = totalFailures;
		this.totalCredits = totalCredits;
		this.faculty = faculty;
		this.courseAttestation = courseAttestation;
		this.yearOfStudy = yearOfStudy;
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
		return this.faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
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
		return super.toString() + "Student [totalFailures=" + totalFailures + ", totalCredits=" + totalCredits + ", transcript="
				 + ", Faculty=" + faculty + ", courseAttestation=" + courseAttestation + ", yearOfStudy="
				+ yearOfStudy + "]";
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ Objects.hash(faculty, courseAttestation, totalCredits, totalFailures, yearOfStudy);
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
		return faculty == other.faculty && Objects.equals(courseAttestation, other.courseAttestation)
				&& totalCredits == other.totalCredits && totalFailures == other.totalFailures
				 && yearOfStudy == other.yearOfStudy;
	}

	public String viewCourses() {
		return courseAttestation.keySet().toString();
    }
    public String viewTeacherInfo(Teacher teacher) {
        return teacher.toString();
    }
    public double viewMarks(Lesson lesson) {
        return lesson.getGrades().get(this);
    }
    public String viewTranscript() {
        StringBuilder transcriptTable = new StringBuilder();
        double totalGPA = 0, sum = 0;
        // Header of the transcript table
        transcriptTable.append(String.format("%-20s %-15s %-10s %-20s %-10s%n",
                "Course Name", "Course Code", "Credits", "Total Scores", "GPA"));
        transcriptTable.append("------------------------------------------------------------\n");
        // Populate the transcript table
        for (Course course : courseAttestation.keySet()) {
            Attestation attestation = courseAttestation.get(course);

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
	public void rateTeacher(Teacher teacher, int rating) {
    	teacher.getTeacherRates().add(rating);
    }
    public void joinStudentOrganization(StudentOrganization studentOrganization) {
    	studentOrganization.addMember(this);
    }
    public void sendRequest(Manager manager, Course course) {
    	manager.viewRequests().put(this, course);
    }
}

