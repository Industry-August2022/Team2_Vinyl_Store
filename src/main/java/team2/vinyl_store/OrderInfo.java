package team2.vinyl_store;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int customerId;
	private String datePlaced;
	private Map<Integer, Integer> vinyl;


	public OrderInfo() {
		super();
		this.vinyl = new HashMap<>();
	}

	public OrderInfo(int orderId, int customerId, String datePlaced, Map<Integer, Integer> vinyl) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.datePlaced = datePlaced;
		this.vinyl = vinyl;
	}

	public int getOrderID() {
		return orderId;
	}

	public void setOrderID(int orderID) {
		this.orderId = orderID;
	}

	public int getCustomerID() {
		return customerId;
	}

	public void setCustomerID(int customerID) {
		this.customerId = customerID;
	}

	public String getDatePlaced() {
		return datePlaced;
	}

	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}

	public Map<Integer, Integer> getVinyl() {
		return vinyl;
	}

	public void addVinyl(int vinyl, int quantity) {
		this.vinyl.put(vinyl, quantity);
	}

	public boolean removeVinyl(int vinyl) {
		return this.vinyl.remove(vinyl) != null;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderID=" + orderId + ", customerID=" + customerId + ", datePlaced=" + datePlaced
				+ ", vinyl=" + vinyl + "]";
	}

}
