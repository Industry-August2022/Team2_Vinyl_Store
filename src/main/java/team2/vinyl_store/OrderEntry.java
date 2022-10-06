package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderEntryId;
	private int orderId;
	private int vinyl;
	private int quantity;

	public OrderEntry() {
		super();
	}

	public OrderEntry(int orderEntryId, int orderId, int vinyl, int quantity) {
		super();
		this.orderEntryId = orderEntryId;
		this.orderId = orderId;
		this.vinyl = vinyl;
		this.quantity = quantity;
	}

	public int getOrderInfoId() {
		return orderEntryId;
	}

	public void setOrderInfoId(int orderEntryId) {
		this.orderEntryId = orderEntryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getVinyl() {
		return vinyl;
	}

	public void setVinyl(int vinyl) {
		this.vinyl = vinyl;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderEntryId=" + orderEntryId + ", orderId=" + orderId + ", vinyl=" + vinyl + ", quantity="
				+ quantity + "]";
	}

}
