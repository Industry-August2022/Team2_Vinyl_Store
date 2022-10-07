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
	private int orderInfoId;
	private int customerId;
	private String datePlaced;
	@OneToMany(mappedBy = "orderId")
	private List<OrderEntry> orderEntries;

	public OrderInfo() {
		super();
		this.orderEntries = new ArrayList<>();
	}

	public OrderInfo(int orderInfoId, int customerId, String datePlaced, List<OrderEntry> orderEntries) {
		super();
		this.orderInfoId = orderInfoId;
		this.customerId = customerId;
		this.datePlaced = datePlaced;
		this.orderEntries = orderEntries;
	}

	public int getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(int orderId) {
		this.orderInfoId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
			if (entry.getVinylId() == vinyl) {
				entry.setQuantity(entry.getQuantity() + quantity);
				added = true;
			}
		if (!added)
			this.orderEntries.add(new OrderEntry(0, this.orderInfoId, vinyl, quantity));

	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean removeVinyl(Vinyl vinyl) {
		return this.orderEntries.remove(vinyl);
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderInfoId + ", customerId=" + customerId + ", datePlaced=" + datePlaced
				+ ", orderEntries=" + orderEntries + "]";
	}

}
