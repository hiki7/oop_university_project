package Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Information.Complaint;
import Information.Data;

public class Dean extends Employee implements Serializable{
	private static final long serialVersionUID = -7164199736517287011L;
	private Faculty faculty;
    

	public Dean(String username, String password, UserRole role, String name, String surname, Gender gender, int id,
			boolean isResearcher, boolean isSupervisor, int salary, Faculty faculty) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor,  salary);
		this.faculty = faculty;
	}
	public Faculty getFaculty() { 
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(faculty);
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
		return faculty == other.faculty;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Dean [faculty=" + faculty + "]";
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

