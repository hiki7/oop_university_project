package LessonObjects;

import java.util.Objects;

public class Transcript {
    private double gpa;
    private Attestation attestation;
    
    public Transcript() {
    	
    }
     
    public Transcript(double gpa, Attestation attestation) {
		super();
		this.gpa = gpa;
		this.attestation = attestation;
	}
    
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public Attestation getAttestation() {
		return attestation;
	}
	
	public void setAttestation(Attestation attestation) {
		this.attestation = attestation;
	}

	public double calculateGpa() {
		double totalMarks = attestation.getFirstAtt() + attestation.getSecondAtt() 
		+ attestation.getFinalExam();
		
        if (totalMarks >= 95) return 4.0;
        if (totalMarks >= 90) return 3.67;
        if (totalMarks >= 85) return 3.33;
        if (totalMarks >= 80) return 3.0;
        if (totalMarks >= 75) return 2.67;
        if (totalMarks >= 70) return 2.33;
        if (totalMarks >= 65) return 2.0;
        if (totalMarks >= 60) return 1.67;
        if (totalMarks >= 55) return 1.33;
        if (totalMarks >= 50) return 1.0;
        if (totalMarks >= 30) return 0.0; // FX
        return 0.0; // F (Fail)
    }

	@Override
	public int hashCode() {
		return Objects.hash(attestation, gpa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transcript other = (Transcript) obj;
		return Objects.equals(attestation, other.attestation)
				&& Double.doubleToLongBits(gpa) == Double.doubleToLongBits(other.gpa);
	}

	@Override
	public String toString() {
		return "Transcript [gpa=" + gpa + ", attestation=" + attestation + "]";
	}
	
}

