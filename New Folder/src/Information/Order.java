package Information;
import java.io.Serializable;
import java.util.Objects;
/**
 * This is the Order class
 */
public class Order implements Serializable{
	private static final long serialVersionUID = -2127113805535329692L;
	private String description;
    private OrderStatus status;
    private int orderId;
    /**
     * Empty constructor of the Order class
     */
    public Order() {
    	
    }
    /**
     * Constructor of the Order class, which accepts description and order id
     * @param description
     * @param orderId
     */
	public Order(String description,  int orderId) {
		super();
		this.description = description;
		this.status = OrderStatus.NEW;
		this.orderId = orderId;
	}
	  /**
	   * This method is used to return orderId
	   * @return orderId
	   */
	public int getOrderId() {
		return orderId;
	}
    /**
     * This method takes an integer called an orderId
     * @param orderId
     */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
    /**This method returns a description
     * 
     * @return
     */
	public String getDescription() {
		return description;
	}
	   /**
	   * This method accepts a description
	   * @param description
	   */
	public void setDescription(String description) {
		this.description = description;
	}
	   /**
	    * This method returns the status
	    * @return status
	    */
	public OrderStatus getStatus() {
		return status;
	}
	/**
	 * This method accepts a status
	 * @param status
	 */
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	/**
	 * Overriding method hashCode to Order class
	 */
	@Override
	public int hashCode() {
		return Objects.hash(description, orderId, status);
	}
	/**
	 * Overriding method equals to Order class
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(description, other.description) && orderId == other.orderId && status == other.status;
	}
	/**
	 * Overriding method toString to Order class
	 */
	@Override
	public String toString() {
		return "Order [description=" + description + ", status=" + status + ", orderId=" + orderId + "]";
	}

	
    
}

