package Information;
import java.util.Objects;
public class Order {
    private String description;
    private OrderStatus status;
    
    public Order() {
    	
    }

	public Order(String description, OrderStatus status) {
		super();
		this.description = description;
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(description, other.description) && status == other.status;
	}

	@Override
	public String toString() {
		return "Order [description=" + description + ", status=" + status + "]";
	}
    
}

