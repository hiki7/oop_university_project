package Users;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import LessonObjects.*;
public class GraduateStudent extends Student implements Serializable{
	private static final long serialVersionUID = -348607983230567150L;
	private DiplomaProject diploma;
    

	public GraduateStudent(String username, String password, UserRole role, String name, String surname, Gender gender,
			int id, boolean isResearcher, boolean isSupervisor, 
			int totalFailures, int totalCredits, Users.Faculty faculty, HashMap<Course, Attestation> courseAttestation,
			int yearOfStudy,Major major, DiplomaProject diploma) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, 
				totalFailures, totalCredits, faculty, courseAttestation, yearOfStudy, major);
		this.diploma = diploma;
		// TODO Auto-generated constructor stub
	}

	public DiplomaProject getDiploma() {
		return diploma;
	}

	public void setDiploma(DiplomaProject diploma) {
		this.diploma = diploma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diploma);
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
		GraduateStudent other = (GraduateStudent) obj;
		return Objects.equals(diploma, other.diploma);
	}

	@Override
	public String toString() {
		return super.toString() + "GraduateStudent [diploma=" + diploma + "]";
	}

	public String writeDiploma() {
        return "Student started to write the diploma project with name: " + diploma.getName() + " and theme of the diploma project is " + diploma.getTheme();
    }

}

