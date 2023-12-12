package LessonObjects;

import java.util.Objects;

public class Attestation {
	private double firstAtt;
	private double secondAtt;
	private double finalExam;

	public Attestation() {
		
	}
	
	public Attestation(double firstAtt, double secondAtt, double finalExam) {
		super();
		this.firstAtt = firstAtt;
		this.secondAtt = secondAtt;
		this.finalExam = finalExam;
	}
	
	public double getFirstAtt() {
		return firstAtt;
	}

	public void setFirstAtt(double firstAtt) {
		this.firstAtt = firstAtt;
	}

	public double getSecondAtt() {
		return secondAtt;
	}

	public void setSecondAtt(double secondAtt) {
		this.secondAtt = secondAtt;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public boolean failedFinal() {
		return finalExam <= 9.5;
	}

	public boolean failedAtt() {
		return (firstAtt + secondAtt) < 30;
	}
	
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

	@Override
	public int hashCode() {
		return Objects.hash(finalExam, firstAtt, secondAtt);
	}

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

	@Override
	public String toString() {
		return "Attestation [firstAtt=" + firstAtt + ", secondAtt=" + secondAtt + ", finalExam=" + finalExam + "]";
	}
	
}


