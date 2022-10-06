package team2.vinyl_store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private int customerId;
	private String datePlaced;
	@OneToMany(mappedBy = "orderId")
	private List<OrderEntry> orderEntries;

	public OrderInfo() {
		super();
		this.orderEntries = new ArrayList<>();
	}

	public OrderInfo(int orderId, int customerId, String datePlaced, List<OrderEntry> orderEntries) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.datePlaced = datePlaced;
		this.orderEntries = orderEntries;
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

	public List<OrderEntry> getOrderEntries() {
		return orderEntries;
	}

	public void addVinyl(int vinyl, int quantity) {
		boolean added = false;
		for (OrderEntry entry : this.orderEntries)
			if (entry.getVinyl() == vinyl) {
				entry.setQuantity(entry.getQuantity() + quantity);
				added = true;
			}
		if (!added)
			this.orderEntries.add(new OrderEntry(0, this.orderId, vinyl, quantity));

	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean removeVinyl(Vinyl vinyl) {
		return this.orderEntries.remove(vinyl);
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", customerId=" + customerId + ", datePlaced=" + datePlaced
				+ ", orderEntries=" + orderEntries + "]";
	}

}
