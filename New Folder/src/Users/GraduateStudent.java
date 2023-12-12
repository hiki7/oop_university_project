package Users;
import java.util.HashMap;
import java.util.Objects;

import LessonObjects.*;
public class GraduateStudent extends Student {
    private DiplomaProject diploma;
	public GraduateStudent(int totalFailures, int totalCredits, Transcript transcript, Users.Faculty faculty,
			HashMap<Course, Attestation> courseAttestation, int yearOfStudy, DiplomaProject diploma) {
		super(totalFailures, totalCredits, transcript, faculty, courseAttestation, yearOfStudy);
		this.diploma = diploma;
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

