package team2.vinyl_store;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int customerId;
	@OneToMany(mappedBy = "cartId")
	private List<CartContent> cartContents;

	public Cart() {
		this.cartContents = new ArrayList<>();
	}

	public Cart(int cartId, int customerId, List<CartContent> cartcontent) {
		this.cartId = cartId;
		this.customerId = customerId;
		this.cartContents = cartcontent;
	}

	public void addToCart(CartContent cartContent) {
		for (CartContent content : cartContents) {
			if (content.getCartContentId() == cartContent.getCartContentId()) {
				int cartContentQuantity = content.getQuantity();
				content.setQuantity(cartContentQuantity++);
			} else {
				cartContents.add(cartContent);
			}
		}
	}

	public void removeFromCart(CartContent cartContent) {
		if (cartContents.contains(cartContent)) {
			cartContents.remove(cartContent);
		}
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public List<CartContent> getCartContents() {
		return this.cartContents;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", cartContents=" + cartContents + "]";
	}

}
