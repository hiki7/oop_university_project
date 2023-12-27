package Users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Information.*;
public class TechSupporter extends Employee implements Serializable{
	private static final long serialVersionUID = -233760161044445865L;
	public TechSupporter(String username, String password, UserRole role, String name, String surname, Gender gender,
			int id, boolean isResearcher, boolean isSupervisor,  int salary) {
		super(username, password, role, name, surname, gender, id, isResearcher, isSupervisor,  salary);
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
    public String acceptOrder(int id) {
    	for(Order o: Data.getInstance().getOrders()) {
    		if(o.getOrderId() == id) {
    			o.setStatus(OrderStatus.ACCEPTED);
    			return "Order accepted";
    		}
    	}
    	return "Wrong id of order";
    	
    }
    public String rejectOrder(int id) {
    	for(Order o: Data.getInstance().getOrders()) {
    		if(o.getOrderId() == id) {
    			o.setStatus(OrderStatus.REJECTED);
    			return "Order rejected";
    		}
    	}
    	return "Wrong id of order";
    }
}

