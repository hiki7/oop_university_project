package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Information.Complaint;
import Information.Data;
import ResearchObjects.Citation;

public class Dean extends Employee {
    private String department;
    
    public Dean() {
		super();
		
	}

	public Dean(String username, String password, UserRole role, String name, String surname, Gender gender, String id,
			boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher, int salary, String department) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, citationsOfResearcher, salary);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Dean [department=" + department + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department);
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
		Dean other = (Dean) obj;
		return Objects.equals(department, other.department);
	}

	public List<Complaint> viewComplaint() {
		List<Complaint> c = new ArrayList<Complaint>();
		for(Complaint complaint: Data.getInstance().getComplaints()) {
			if(complaint.getRecipient().equals(this)) {
				c.add(complaint);
			}
		}
		return c;
    }
}

