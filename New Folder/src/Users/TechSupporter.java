package Users;

import java.util.ArrayList;
import java.util.List;

import Information.*;
import ResearchObjects.Citation;
public class TechSupporter extends Employee {
	
    public TechSupporter() {
		super();
	}
	public TechSupporter(String username, String password, UserRole role, String name, String surname, Gender gender,
			String id, boolean isResearcher, boolean isSupervisor, List<Citation> citationsOfResearcher, int salary) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor, citationsOfResearcher, salary);
	}
	public List<Order> seeOrders() {
		List<Order> lo = new ArrayList<Order>();
		for(Order order: Data.getInstance().getOrders()) {
			if(order.getStatus() == OrderStatus.NEW) {
				lo.add(order);
			}
		}
		return lo;
    }
    public void acceptOrder(Order order) {
    	order.setStatus(OrderStatus.ACCEPTED);
    }
    public void rejectOrder(Order order) {
    	order.setStatus(OrderStatus.REJECTED);
    }
}

