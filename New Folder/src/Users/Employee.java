package Users;
import java.util.*;
import Information.*;
import ResearchObjects.Citation;
public abstract class Employee extends User {
    private int salary;    
	public Employee() {
		super();
	}
	public Employee(String username, String password, UserRole role, String name, String surname, Gender gender,
			String id, boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher, int salary) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, citationsOfResearcher);
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Employee [salary=" + salary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(salary);
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
		Employee other = (Employee) obj;
		return salary == other.salary;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void sendMessage(Message message) {
		Data.getInstance().getWorkMessages().add(message);
    }
    public List<Message> viewMessage() {
    	List<Message> m = new ArrayList<Message>();
    	for(Message message: Data.getInstance().getWorkMessages() ) {
    		if(message.getRecipient().equals(this)) {
    			m.add(message);
    		}
    	}
    	return m;
    }
    public List<Message> viewSentMessage() {
    	List<Message> m = new ArrayList<Message>();
    	for(Message message: Data.getInstance().getWorkMessages() ) {
    		if(message.getSender().equals(this)) {
    			m.add(message);
    		}
    	}
    	return m;
    }
	public void sendOrder(Order order) {
		Data.getInstance().getOrders().add(order);
    }
}

