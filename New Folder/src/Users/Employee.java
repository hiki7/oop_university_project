package Users;
import java.io.Serializable;
import java.util.*;
import Information.*;
public abstract class Employee extends User implements Serializable {
	private static final long serialVersionUID = -5515987365717826466L;
	private int salary;    
	public Employee() {
		super();
	}
	public Employee(String username, String password, UserRole role, String name, String surname, Gender gender,
			int id, boolean isResearcher, boolean isSupervisor, int salary) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor);
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
	public String sendMessage(String nameR, String surnameR, String role, String content) {
		User user = null;
		boolean m = false;
		for(User u: Data.getInstance().getUsers()) {
			if(u.getName().equals(nameR) && u.getSurname().equals(surnameR) && u.getRole() == UserRole.valueOf(role) ) {
				user = u;
				m = true;
				break;
			}
		}
		if(m == false) {
			return "Wrong credentials";
		}
		Data.getInstance().getWorkMessages().add(new Message(this, (Employee)user, content));
		return "Message sended succesfully";
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
	public String sendOrder(String description) {
		Data.getInstance().getOrders().add(new Order(description, Data.getInstance().getOrders().size() + 1));
		return "Order sended succesfully";
    }
}

