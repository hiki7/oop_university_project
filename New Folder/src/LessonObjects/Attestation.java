package LessonObjects;

import java.io.Serializable;
import java.util.Objects;
/**
 * This is the Attestation class
 */
public class Attestation implements Serializable {
	private static final long serialVersionUID = -4211993099867758187L;
	private double firstAtt;
	private double secondAtt;
	private double finalExam;
	/**
	 * Empty constructor of the Attestation class
	 */
	public Attestation() {
		
	}
	/**
	 * Constructor of the Attestation class, which accepts mark of first and second attestation and final exam
	 * @param firstAtt
	 * @param secondAtt
	 * @param finalExam
	 */
	public Attestation(double firstAtt, double secondAtt, double finalExam) {
		this.firstAtt = firstAtt;
		this.secondAtt = secondAtt;
		this.finalExam = finalExam;
	}
	/**
	 * This method returns the grade for the first attestation
	 * @return firstAtt
	 */
	public double getFirstAtt() {
		return firstAtt;
	}
	/**
	 * This method accepts the grade for the first attestation
	 * @param firstAtt
	 */
	public void setFirstAtt(double firstAtt) {
		this.firstAtt = firstAtt;
	}
	/**
	 * This method returns the grade for the second attestation
	 * @return secondAtt
	 */
	public double getSecondAtt() {
		return secondAtt;
	}
	/**
	 * This method accepts the grade for the second attestation
	 * @param secondAtt
	 */
	public void setSecondAtt(double secondAtt) {
		this.secondAtt = secondAtt;
	}
	/**
	 * This method returns the grade for the final exam
	 * @return finalExam
	 */
	public double getFinalExam() {
		return finalExam;
	}
	/**
	 * This method accepts the grade for the final exam
	 * @param finalExam
	 */
	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}
	/**
	 * This method shows whether the student failed the final exam
	 * @return
	 */
	public boolean failedFinal() {
		return finalExam <= 9.5;
	}
	/**
	 * This method shows whether the student was able to get a sufficient score in two attestation
	 * @return
	 */
	public boolean failedAtt() {
		return (firstAtt + secondAtt) < 30;
	}
	/**
	 * This method calculates based on the full estimate of the GPA
	 * @return the GPA that coincides with the total mark
	 */
	public double calculateGpa() {
		double totalMarks = firstAtt + secondAtt + finalExam;
	    
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
	 * Overriding method hashCode to Attestation class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(finalExam, firstAtt, secondAtt);
	}
	/**
	 * Overriding method equals toAttestation  class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attestation other = (Attestation) obj;
		return Double.doubleToLongBits(finalExam) == Double.doubleToLongBits(other.finalExam)
				&& Double.doubleToLongBits(firstAtt) == Double.doubleToLongBits(other.firstAtt)
				&& Double.doubleToLongBits(secondAtt) == Double.doubleToLongBits(other.secondAtt);
	}
	/**
	 * Overriding method toString to Attestation class
	 */
	@Override
	public String toString() {
		return "Attestation [firstAtt=" + firstAtt + ", secondAtt=" + secondAtt + ", finalExam=" + finalExam + "]";
	}
	
}


