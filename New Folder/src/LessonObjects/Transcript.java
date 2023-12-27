package LessonObjects;

import java.io.Serializable;
import java.util.Objects;
/**
 * This is the Transcript class
 */
public class Transcript implements Serializable {
	private static final long serialVersionUID = -85154577196695259L;
	private double gpa;
    private Attestation attestation;
    /**
     * Empty constructor of the Transcript class
     */
    public Transcript() {
    	
    }
    /**
     * Constructor of the Transcript class, which accepts gpa and attestation
     * @param gpa
     * @param attestation
     */
    public Transcript(double gpa, Attestation attestation) {
		super();
		this.gpa = gpa;
		this.attestation = attestation;
	}
    /**
     * This method returns gpa
     * @return gpa 
     */
	public double getGpa() {
		return gpa;
	}
	/**
	 * This method accepts gpa
	 * @param gpa
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	/**
	 * This method returns attestation
	 * @return attestation
	 */
	public Attestation getAttestation() {
		return attestation;
	}
	/**
	 * This method accepts attestation
	 * @param attestation
	 */
	public void setAttestation(Attestation attestation) {
		this.attestation = attestation;
	}
	/**
	 * This method calculates gpa by total mark
	 * @return gpa
	 */
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
	/**
	 * Overriding method hashCode to Transcript class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(attestation, gpa);
	}
	/**
	 * Overriding method equals to Transcript class
	 */
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
	/**
	 * Overriding method toString to Transcript class
	 */
	@Override
	public String toString() {
		return "Transcript [gpa=" + gpa + ", attestation=" + attestation + "]";
	}
	
}

