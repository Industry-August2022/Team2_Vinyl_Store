package team2.vinyl_store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team2.vinyl_store.Cart;
import team2.vinyl_store.repositories.CartRepository;

@Service
public class CartService {

	private final CartRepository cartRepository;

	@Autowired
	protected CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public Cart getCartByID(int id) {
		return cartRepository.findById(id).get();
	}
	
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public Cart insertCart(Cart cart) {
		return cartRepository.save(cart);
	}

	public List<Cart> getAllCategories() {
		return cartRepository.findAll();
	}

}
