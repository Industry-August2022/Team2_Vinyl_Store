package team2.vinyl_store;

import java.util.HashMap;
import java.util.Map;

public class OrderInfo {

	private int orderID;
	private int customerID;
	private String datePlaced;
	private Map<Integer, Integer> vinyl;

	public OrderInfo() {
		vinyl = new HashMap<>();
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
		return "OrderInfo [orderID=" + orderID + ", customerID=" + customerID + ", datePlaced=" + datePlaced
				+ ", vinyl=" + vinyl + "]";
	}

}
