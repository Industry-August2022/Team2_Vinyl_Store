package team2.vinyl_store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartContent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartContentId;
	private int cartId;
	private int vinylId;
	private int quantity;
	
	public CartContent() {
	}

	public CartContent(int cartContentId, int cartId, int vinylId, int quantity) {
		this.cartContentId = cartContentId;
		this.cartId = cartId;
		this.vinylId = vinylId;
		this.quantity = quantity;
	}

	public int getCartContentId() {
		return cartContentId;
	}

	public void setCartContentId(int cartContentId) {
		this.cartContentId = cartContentId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getVinylId() {
		return vinylId;
	}

	public void setVinylId(int vinylId) {
		this.vinylId = vinylId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartContent [cartContentId=" + cartContentId + ", cartId=" + cartId + ", vinylId=" + vinylId
				+ ", quantity=" + quantity + "]";
	}
	
}
